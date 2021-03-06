import {sizes} from "../support/sizes";

sizes.forEach(size => {
    describe(`Error pages on ${size}`, () => {

        beforeEach(() => {
            cy.viewport(size)
        })

        it('should show 404 page for not found', () => {
            cy.visit('/somePageWhichAlmostCertainlyDoesNotExist', {
                failOnStatusCode: false,
                method: 'GET',
            })
            cy.get('[data-test=error-message]')
                .should('contain.text', `It looks like we couldn't find what you were looking for!`)
        })
    })
})
