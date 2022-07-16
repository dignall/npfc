package org.koil.public

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.doesNotContain
import assertk.assertions.isEmpty
import assertk.assertions.isNotEmpty
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class ComboServiceTest(@Autowired private val comboService: ComboService) {

    @Test
    fun noCardsReturnsNoCombos(){
      assertThat (comboService.getPotentialCombos(listOf())).isEmpty()
    }

    @Test
    fun wildManComboCardsReturnAtLeastWildManCombo(){
        val cards = listOf(Card.RUNNING, Card.AEROBICS, Card.SPRINTING)

        val result = comboService.getPotentialCombos(cards)

        assertThat(result).isNotEmpty()
        assertThat(result).contains(Combo.WILD_MAN)
        assertThat(result).doesNotContain(Combo.ROULETTE_TURN)
    }
}