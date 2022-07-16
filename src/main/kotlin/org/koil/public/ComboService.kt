package org.koil.public

import org.springframework.stereotype.Service

interface IComboService {
    fun getPotentialCombos(cards: List<Card>): List<Combo>
}

@Service
class ComboService : IComboService {
    val allCombos = Combo.values().toList()

    override fun getPotentialCombos(cards: List<Card>): List<Combo> {
        return allCombos.filter { combo ->
            combo.cards.all { cards.contains(it) }
        }
    }
}