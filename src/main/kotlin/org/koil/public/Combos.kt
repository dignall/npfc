package org.koil.public

enum class Ability {
    KICKING,
    SPEED,
    STAMINA,
    TECHNIQUE,
    TOUGHNESS,
    JUMPING,
    WILLPOWER,
}

data class Effects(
    val kicking: Int = 0,
    val speed: Int = 0,
    val stamina: Int = 0,
    val technique: Int = 0,
    val toughness: Int = 0,
    val jumping: Int = 0,
    val willpower: Int = 0,
)

enum class Combo(
    val cards: List<Card>,
    val effects: Effects,
    val keeperOnly: Boolean = false,
    val hiddenCombo: Boolean = false,
) {
    WILD_MAN(
        cards = listOf(Card.RUNNING, Card.AEROBICS, Card.SPRINTING),
        effects = Effects(speed = 20, stamina = 20, willpower = -2)
    ),
    ROULETTE_TURN(
        cards = listOf(Card.AGILITY, Card.STRETCHING, Card.GAMING),
        effects = Effects(speed = 12, stamina = 4, technique = 4, toughness = 8, willpower = 4)
    ),
    GUTSY_CLEARANCE(
        cards = listOf(Card.HEADING, Card.STRETCHING, Card.JUDO),
        effects = Effects(speed = 6, toughness = 4, jumping = 10, willpower = 10)
    ),
    STAR_TAKEDOWN(
        cards = listOf(Card.MARKING, Card.SLIDING, Card.SPRINTING),
        effects = Effects(speed = 12, stamina = 6, technique = 2, toughness = 10)
    ),
    RUSH_ATTACK(
        cards = listOf(Card.DRIBBLING, Card.PASSING, Card.SIGNING),
        effects = Effects(kicking = 3, speed = 10, stamina = 6, technique = 4, jumping = 6)
    )
    ;

    fun total(): Int =
        effects.kicking + effects.speed + effects.stamina + effects.technique + effects.toughness + effects.jumping + effects.willpower
}

