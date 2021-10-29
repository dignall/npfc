package org.koil.admin

import org.junit.jupiter.api.Test
import org.koil.BaseIntegrationTest
import org.koil.auth.UserAuthority
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class AdminControllerAuthTest : BaseIntegrationTest() {

    @Test
    fun `GIVEN a COMPANY_OWNER user WHEN requesting the admin dashboard THEN return OK`() {
        withTestSession(authorities = listOf(UserAuthority.COMPANY_OWNER)) { admin ->
            mockMvc.perform(get("/admin").with(user(admin)))
                .andExpect(status().isForbidden)
        }
    }

    @Test
    fun `GIVEN a USER user WHEN requesting the admin dashboard THEN return OK`() {
        withTestSession(authorities = listOf(UserAuthority.USER)) { admin ->
            mockMvc.perform(get("/admin").with(user(admin)))
                .andExpect(status().isForbidden)
        }
    }

    @Test
    fun `GIVEN an ADMIN user WHEN requesting the admin dashboard THEN return OK`() {
        withTestSession(authorities = listOf(UserAuthority.ADMIN)) { admin ->
            mockMvc.perform(get("/admin").with(user(admin)))
                .andExpect(status().isOk)
        }
    }

}
