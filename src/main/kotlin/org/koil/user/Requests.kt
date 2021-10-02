package org.koil.user

import org.koil.auth.UserAuthority
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class UserCreationRequest(
    val fullName: String,
    val email: String,
    val password: HashedPassword,
    val handle: String,
    val authorities: List<UserAuthority> = listOf(UserAuthority.USER)
)

sealed class UserCreationResult {
    data class CreatedUser(val account: Account) : UserCreationResult()
    object UserAlreadyExists : UserCreationResult()
}

data class UpdateUserSettingsRequest(
    @get:NotEmpty(message = "Name cannot be empty") val name: String,
    @get:Email(message = "Must be a valid email address") val email: String,
    val weeklySummary: Boolean?,
    val updateOnAccountChange: Boolean?
) {
    val normalizedEmail: String = email.trim().toLowerCase()

    val notificationSettings: NotificationSettings = NotificationSettings(
        weeklyActivity = weeklySummary ?: false,
        emailOnAccountChange = updateOnAccountChange ?: false
    )

    fun update(account: Account): Account =
        account.updateNotificationSettings(this.notificationSettings)
            .updateName(this.name)
            .updateEmail(this.normalizedEmail)
}

sealed class AccountUpdateResult {
    data class AccountUpdated(val account: Account) : AccountUpdateResult()
    data class EmailAlreadyInUse(val email: String) : AccountUpdateResult()
}
