package org.springboard.admin

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springboard.auth.AuthAuthority
import org.springboard.user.UserCreationRequest
import org.springboard.user.UserCreationResult
import org.springboard.user.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

interface IAdminService {
    fun createAdminFromEmail(email: String, password: String): UserCreationResult
}

@Component
class AdminServiceImpl(private val userService: UserService,
                       @Value("\${admin-user.email:}") private val adminEmailFromEnv: String,
                       @Value("\${admin-user.password:}") private val adminPasswordFromEnv: String
) : IAdminService, ApplicationListener<ContextRefreshedEvent> {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(AdminServiceImpl::class.java)
    }

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        if (adminEmailFromEnv.isNotEmpty() && adminPasswordFromEnv.isNotEmpty()) {
            createAdminFromEmail(adminEmailFromEnv, adminPasswordFromEnv)
        }
    }

    override fun createAdminFromEmail(email: String, password: String): UserCreationResult {
        return userService.createUser(UserCreationRequest("Default Admin",
                email,
                password,
                "DefaultAdmin",
                listOf(AuthAuthority.ADMIN))).also {
            if (it is UserCreationResult.CreatedUser) {
                LOGGER.info("Created an admin account with email {}", email)
            }
        }
    }

}
