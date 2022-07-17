package org.koil.public

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

data class IndexViewModel(
    val allCards: List<Card>,
    val allTypes: List<CardType>,
    val cardsByType: Map<CardType, List<Card>>,
    val ownedCards: List<Card>,
    val potentialCombos: List<Combo>,
) {
    fun cardShouldBeChecked(card: Card): Boolean = ownedCards.contains(card)

    fun hasCombos(): Boolean = potentialCombos.isNotEmpty()
}

@Controller
class PublicController(@Autowired private val comboService: IComboService) {
    @GetMapping("/")
    fun index(
        @RequestParam(required = false) cardOwned: List<Card>? = listOf(),
    ): ModelAndView {
        val allCards = Card.values().toList()
        val allTypes = CardType.values().toList()

        val ownedCards: List<Card> = cardOwned ?: listOf()

        val cardsByType = allTypes.associateWith { cardType ->
            allCards.filter { card -> card.cardType == cardType }
        }

        val potentialCombos = comboService.getPotentialCombos(ownedCards)

        val model = IndexViewModel(allCards, allTypes, cardsByType, ownedCards, potentialCombos)
        return ModelAndView("pages/index", mapOf("model" to model))
    }
}
