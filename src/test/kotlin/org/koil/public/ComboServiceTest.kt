package org.koil.public

import assertk.assertThat
import assertk.assertions.isEmpty
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class ComboServiceTest(@Autowired private val comboService: ComboService) {

    @Test
    fun comboService(){
      assertThat (comboService.getCombos(listOf())).isEmpty()
    }
}