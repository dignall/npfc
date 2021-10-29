// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add("login", (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add("drag", { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add("dismiss", { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite("visit", (originalFn, url, options) => { ... })

function loadPageForCSRF(url) {
    return cy.request(url).its('body')
        .then(body => {
            const $html = Cypress.$(body)
            return $html.find('input[name=_csrf]').val()
        })
}

Cypress.Commands.add('createAccount', (name, username, email, passwd, signupLink) => {
    loadPageForCSRF('/auth/register/employee')
        .then(csrf => {
            cy.request({
                url: '/auth/register/employee',
                form: true,
                method: 'POST',
                body: {
                    name: name,
                    email: email,
                    handle: username,
                    password: passwd,
                    signupLink: signupLink,
                    '_csrf': csrf
                }
            })
        })
})

Cypress.Commands.add('createCompanyAccount', (companyName, name, username, email, passwd) => {
    loadPageForCSRF('/auth/register/company')
        .then(csrf => {
            cy.request({
                url: '/auth/register/company',
                form: true,
                method: 'POST',
                body: {
                    companyName: companyName,
                    name: name,
                    email: email,
                    handle: username,
                    password: passwd,
                    '_csrf': csrf
                }
            })
        })
})

Cypress.Commands.add('createRandomAccount', (requestedSignupLink) => {
    const slug = Math.random()
        .toString(36)
        .substring(7)

    const email = `test+${slug}@getkoil.dev`
    const username = slug
    const passwd = 'SomeSecurePassword123!'
    const name = `Test User ${slug}`

    cy.getCompanySignupLink(requestedSignupLink).then((signupLink) => {
        cy.createAccount(name, username, email, passwd, signupLink)
            .then(() => {
                return {
                    name: name,
                    email: email,
                    passwd: passwd,
                    username: username,
                    slug: slug
                }
            }).as('account')
    })
})

Cypress.Commands.add('createRandomCompanyAccount', () => {
    const slug = Math.random()
        .toString(36)
        .substring(7)

    const email = `test+${slug}@getkoil.dev`
    const username = slug
    const passwd = 'SomeSecurePassword123!'
    const name = `Test User ${slug}`
    const companyName = `Test Company ${slug}`

    cy.createCompanyAccount(companyName, name, username, email, passwd)
        .then(() => {
            return {
                name: name,
                email: email,
                passwd: passwd,
                username: username,
                slug: slug
            }
        }).as('account')
})

Cypress.Commands.add('createRandomAccountAndLogin', () => {
    cy.createRandomAccount()
    cy.get('@account').then(() => {
        cy.visit('/dashboard')
    })
})

Cypress.Commands.add('loginAsAdmin', () => {
    cy.visit('/auth/login')

    cy.get('[data-test=login-form]').within(() => {
        cy.get('input[name=email]').type('admin@getkoil.dev')
        cy.get('input[name=password]').type('SecurePass123!')
        cy.get('button[type=submit]').click()
    })
    cy.get('[data-test=dashboard-index]').should('exist')
    cy.visit('/admin')
})

Cypress.Commands.add('accountDetailsForEmail', (email) => {
    return cy.request({
        url: `/dev/account?email=${encodeURIComponent(email)}`,
        method: 'GET',
    })
})

Cypress.Commands.add('getCompanySignupLink', (companyName) => {
    const companyUrl = companyName ? `/dev/company/${companyName}` : '/dev/company'
    return cy.request({
        url: companyUrl,
        method: 'GET',
    }).then(response => {
        return response.body
    })
})