package org.koil.public

import org.springframework.beans.factory.annotation.Autowired
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

    fun currentUrl(): String = if (ownedCards.isEmpty()) {
        "/"
    } else {
        val stringBuilder: StringBuilder = StringBuilder("/?cardOwned=${ownedCards.first()}")

        ownedCards.takeLast(ownedCards.size - 1).forEach {
            stringBuilder.append("&cardOwned=$it")
        }

        stringBuilder.toString()
    }

    fun sortUrl(ability: String): String {
        return currentUrl() + "&sort=" + ability
    }
}

@Controller
class PublicController(@Autowired private val comboService: IComboService) {
    @GetMapping("/")
    fun index(
        @RequestParam(required = false) cardOwned: List<Card>? = listOf(),
        @RequestParam(required = false) sort: String? = "total",
    ): ModelAndView {
        val allCards = Card.values().toList()
        val allTypes = CardType.values().toList()

        val ownedCards: List<Card> = cardOwned ?: listOf()

        val cardsByType = allTypes.associateWith { cardType ->
            allCards.filter { card -> card.cardType == cardType }
        }

        val potentialCombos = comboService.getPotentialCombos(ownedCards)

        val sortedCombos =
            when (sort) {
                "kicking" -> potentialCombos.sortedByDescending { it.effects.kicking }
                "speed" -> potentialCombos.sortedByDescending { it.effects.speed }
                "stamina" -> potentialCombos.sortedByDescending { it.effects.stamina }
                "technique" -> potentialCombos.sortedByDescending { it.effects.technique }
                "toughness" -> potentialCombos.sortedByDescending { it.effects.toughness }
                "jumping" -> potentialCombos.sortedByDescending { it.effects.jumping }
                "willpower" -> potentialCombos.sortedByDescending { it.effects.willpower }
                else -> potentialCombos.sortedByDescending { it.total() }
            }

        val model = IndexViewModel(allCards, allTypes, cardsByType, ownedCards, sortedCombos)
        return ModelAndView("pages/index", mapOf("model" to model))
    }
}
