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
    ),
    HARD_DYNAMO(
        cards = listOf(Card.PRESSURING, Card.RUNNING, Card.AGILITY),
        effects = Effects(speed = 10, stamina = 14, technique = 5)
    ),
    PHANTOM_DRIBBLER(
        cards = listOf(Card.DRIBBLING, Card.AEROBICS, Card.FREESTYLING),
        effects = Effects(speed = 14, stamina = 6, technique = 7)
    ),
    EXPLOSIVE_HEADER(
        cards = listOf(Card.MARKING, Card.HEADING, Card.MINICAMP),
        effects = Effects(kicking = 5, stamina = 4, jumping = 12, willpower = 6)
    ),
    AERIAL_SPECIALIST(
        cards = listOf(Card.SETPLAYS, Card.HEADING, Card.MINICAMP),
        effects = Effects(kicking = 2, technique = 2, toughness = 6, jumping = 16)
    ),
    BALL_CONTROL(
        cards = listOf(Card.FREESTYLING, Card.RUNNING, Card.MEDITATION),
        effects = Effects(speed = 6, stamina = 6, technique = 8, toughness = 6)
    ),
    LONG_THROW(
        cards = listOf(Card.WEIGHTS, Card.AEROBICS, Card.SPA),
        effects = Effects(speed = 6, technique = 4, toughness = 12, willpower = 4)
    ),
    LAST_TRUMP(
        cards = listOf(Card.SETPLAYS, Card.PASSING, Card.SPA),
        effects = Effects(kicking = 8, speed = 8, toughness = 6, willpower = 4)
    ),
    ULTRA_RELAXATION(
        cards = listOf(Card.STRETCHING, Card.OILTHERAPY, Card.SPA),
        effects = Effects(stamina = 6, technique = 2, toughness = 10, willpower = 8)
    ),
    TOUGH_MIDFIELDER(
        cards = listOf(Card.PRESSURING, Card.DRIBBLING, Card.SLIDING),
        effects = Effects(kicking = 3, speed = 6, stamina = 6, technique = 4, toughness = 6)
    ),
    HOMING_CROSS(
        cards = listOf(Card.PLACEKICKS, Card.KICKING, Card.MINICAMP),
        effects = Effects(kicking = 6, speed = 4, stamina = 4, technique = 2, toughness = 4, willpower = 4)
    ),
    RELENTLESS_PRESSURE(
        cards = listOf(Card.PRESSURING, Card.WEIGHTS, Card.MINICAMP),
        effects = Effects(speed = 6, stamina = 8, technique = 2, willpower = 8)
    ),
    MIDFIELD_MAESTRO(
        cards = listOf(Card.PLACEKICKS, Card.PASSING, Card.AGILITY),
        effects = Effects(kicking = 5, speed = 8, technique = 5, willpower = 6)
    ),
    LAST_GASP_MIRACLE(
        cards = listOf(Card.COUNTERING, Card.SETPLAYS, Card.JUDO),
        effects = Effects(kicking = 2, speed = 4, technique = 2, willpower = 16)
    ),
    HEADED_SHOT(
        cards = listOf(Card.HEADING, Card.AGILITY),
        effects = Effects(kicking = 3, toughness = 6, jumping = 14)
    ),
    SLIDING_HEADER(
        cards = listOf(Card.HEADING, Card.SLIDING, Card.SPA),
        effects = Effects(kicking = 3, technique = 2, toughness = 6, jumping = 6, willpower = 6)
    ),
    BODY_OF_STEEL(
        cards = listOf(Card.ANALYSIS, Card.WEIGHTS, Card.KICKING),
        effects = Effects(kicking = 4, technique = 3, toughness = 16)
    ),
    IRON_FIST(
        cards = listOf(Card.MARKING, Card.WEIGHTS, Card.JUDO),
        effects = Effects(kicking = 5, toughness = 12, willpower = 6)
    ),
    TARGET_MAN(
        cards = listOf(Card.COUNTERING, Card.WEIGHTS, Card.HEADING),
        effects = Effects(kicking = 5, speed = 5, stamina = 5, technique = 2, jumping = 5)
    ),
    LINKED_PARTNERS(
        cards = listOf(Card.PASSING, Card.AEROBICS, Card.MINICAMP),
        effects = Effects(speed = 6, stamina = 8, technique = 4, toughness = 2, willpower = 2)
    ),
    LAST_GASP_PASS(
        cards = listOf(Card.COUNTERING, Card.PASSING, Card.MEDITATION),
        effects = Effects(speed = 6, stamina = 4, technique = 4, willpower = 8)
    ),
    MAGNET_TRAPPING(
        cards = listOf(Card.FREESTYLING, Card.STRETCHING, Card.VISUALISING),
        effects = Effects(speed = 6, technique = 8, toughness = 4, willpower = 4)
    ),
    COVERING(
        cards = listOf(Card.LINECONTROL, Card.SPRINTING),
        effects = Effects(kicking = 2, stamina = 4, toughness = 10, jumping = 6)
    ),
    BLOCKING(
        cards = listOf(Card.SLIDING, Card.STRETCHING),
        effects = Effects(speed = 6, technique = 2, toughness = 8, willpower = 6)
    ),
    DOGGED_MARKER(
        cards = listOf(Card.MARKING, Card.RUNNING),
        effects = Effects(speed = 4, stamina = 10, toughness = 4, willpower = 4)
    ),
    WILD_RAGE(
        cards = listOf(Card.MARKING, Card.KICKING, Card.AGILITY),
        effects = Effects(kicking = 2, technique = 6, toughness = 8, jumping = 6)
    ),
    DESPERATE_SAVES(
        cards = listOf(Card.AEROBICS, Card.MEDITATION, Card.PKPRACTICE),
        effects = Effects(stamina = 4, technique = 8, willpower = 10),
        keeperOnly = true
    ),
    FREE_KICK_LEGEND(
        cards = listOf(Card.PLACEKICKS, Card.VISUALISING, Card.MINICAMP),
        effects = Effects(kicking = 11, willpower = 10)
    ),
    ACROBATICS(
        cards = listOf(Card.COUNTERING, Card.AEROBICS, Card.STRETCHING),
        effects = Effects(speed = 6, stamina = 5, technique = 2, toughness = 6, jumping = 2)
    ),
    BICYCLE_KICK(
        cards = listOf(Card.SHOOTING, Card.AEROBICS, Card.JUDO),
        effects = Effects(kicking = 4, stamina = 6, technique = 4, toughness = 6)
    ),
    FAST_DRIBBLE(
        cards = listOf(Card.DRIBBLING, Card.SPRINTING),
        effects = Effects(speed = 12, stamina = 4, technique = 4)
    ),
    SHOCK_DRIBBLE(
        cards = listOf(Card.MINIGAME, Card.DRIBBLING, Card.KICKING),
        effects = Effects(kicking = 2, speed = 6, technique = 6, toughness = 6)
    ),
    NO_LOOK_PASS(
        cards = listOf(Card.PASSING, Card.SPRINTING, Card.VISUALISING),
        effects = Effects(speed = 6, technique = 6, willpower = 8)
    ),
    KILLER_PASS(
        cards = listOf(Card.PASSING, Card.KICKING, Card.OILTHERAPY),
        effects = Effects(kicking = 2, speed = 5, technique = 5, toughness = 5, willpower = 3)
    ),
    FEINT_STEPS(
        cards = listOf(Card.SPRINTING, Card.AGILITY, Card.OILTHERAPY),
        effects = Effects(speed = 10, technique = 6, willpower = 4)
    ),
    CHASING(
        listOf(Card.PRESSURING, Card.AEROBICS),
        Effects(speed = 6, stamina = 8, toughness = 6)
    ),
    THE_CHAIN(
        listOf(Card.ANALYSIS, Card.MARKING, Card.LINECONTROL),
        Effects(kicking = 2, speed = 4, stamina = 6, technique = 2, toughness = 6)
    ),
    STAR_STRIKER(
        listOf(Card.PLACEKICKS, Card.AEROBICS, Card.SIGNING),
        Effects(kicking = 10, technique = 4, toughness = 6)
    ),
    FK_MASTER(
        listOf(Card.SETPLAYS, Card.PLACEKICKS, Card.PKPRACTICE),
        Effects(kicking = 12, willpower = 8)
    ),
    CAPTAINCY(
        listOf(Card.RUNNING, Card.MEETING),
        Effects(stamina = 10, willpower = 10)
    ),
    KEEN_COACHING(
        listOf(Card.MINIGAME, Card.LINECONTROL, Card.JUDO),
        Effects(stamina = 6, technique = 4, willpower = 10)
    ),
    TEAM_RALLY(
        listOf(Card.MARKING, Card.MEETING, Card.KARAOKE),
        Effects(speed = 4, stamina = 4, jumping = 4, willpower = 8)
    ),
    TEAM_LOVE(
        listOf(Card.OILTHERAPY, Card.SIGNING, Card.MEETING),
        Effects(willpower = 20)
    ),
    SUPER_SAVE(
        listOf(Card.HEADING, Card.MEDITATION),
        Effects(stamina = 4, jumping = 8, willpower = 8),
        keeperOnly = true
    ),
    GOALIE_RUNS_UP(
        listOf(Card.SETPLAYS, Card.RUNNING, Card.KARAOKE),
        Effects(kicking = 12, stamina = 8),
        keeperOnly = true
    ),
    DIVING_SHOT(
        listOf(Card.COUNTERING, Card.SHOOTING, Card.SPRINTING),
        Effects(kicking = 9, speed = 10)
    ),
    FLOWING_FOOTBALL(
        listOf(Card.MINIGAME, Card.PASSING, Card.AGILITY),
        Effects(kicking = 3, speed = 10, technique = 6)
    ),
    CHOOCHOO_TRAIN(
        listOf(Card.LINECONTROL, Card.STRETCHING, Card.SPA),
        Effects(speed = 4, stamina = 2, toughness = 7, jumping = 2, willpower = 4)
    ),
    MIDFIELD_STRIKE(
        listOf(Card.WEIGHTS, Card.SHOOTING, Card.SIGNING),
        Effects(kicking = 14, toughness = 4)
    ),
    LONG_PASS(
        listOf(Card.PLACEKICKS, Card.WEIGHTS),
        Effects(kicking = 8, toughness = 6, willpower = 4)
    ),
    OVERLAPPING(
        listOf(Card.COUNTERING, Card.RUNNING),
        Effects(speed = 6, stamina = 12)
    ),
    SUPERIOR_NUMBERS(
        listOf(Card.LINECONTROL, Card.AGILITY),
        Effects(speed = 5, stamina = 5, jumping = 4, willpower = 4)
    ),
    FOOTBALL_PROFESSOR(
        listOf(Card.ANALYSIS, Card.SETPLAYS, Card.GAMING),
        Effects(kicking = 4, speed = 4, technique = 2, willpower = 8)
    ),
    SUPER_LONG_SHOT(
        listOf(Card.SHOOTING, Card.KICKING, Card.GAMING),
        Effects(kicking = 8, technique = 1, toughness = 4, willpower = 4)
    ),
    MIRACLE_LOOP(
        listOf(Card.MINIGAME, Card.SHOOTING, Card.MEDITATION),
        Effects(kicking = 7, technique = 2, willpower = 8)
    )
    ;

    fun total(): Int =
        effects.kicking + effects.speed + effects.stamina + effects.technique + effects.toughness + effects.jumping + effects.willpower
}

