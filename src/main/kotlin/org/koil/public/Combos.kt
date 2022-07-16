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
    ),
    GOAL_SNIFFER(
        listOf(Card.OILTHERAPY, Card.MEDITATION, Card.VISUALISING),
        Effects(kicking = 3, speed = 4, technique = 3, jumping = 3, willpower = 4)
    ),
    PITCH_DIRECTOR(
        listOf(Card.ANALYSIS, Card.PKPRACTICE, Card.MEETING),
        Effects(kicking = 5, technique = 2, willpower = 10)
    ),
    SUPER_SUB(listOf(Card.SPRINTING, Card.PKPRACTICE), Effects(kicking = 3, speed = 8, jumping = 6)),
    COMMANDER(
        listOf(Card.SPRINTING, Card.JUDO),
        Effects(kicking = 2, speed = 4, technique = 3, toughness = 4, willpower = 4)
    ),
    OVERTRAINING(
        listOf(Card.RUNNING, Card.SLIDING, Card.WEIGHTS),
        Effects(kicking = -1, stamina = -4, toughness = 24, willpower = -2),
        hiddenCombo = true
    ),
    SHADOW_STRIKER(listOf(Card.ANALYSIS, Card.SHOOTING), Effects(kicking = 7, speed = 5, technique = 2, willpower = 2)),
    RAPID_DRIBBLING(listOf(Card.DRIBBLING, Card.VISUALISING), Effects(speed = 6, technique = 6, willpower = 4)),
    PINPOINT_PASS(listOf(Card.PASSING, Card.JUDO), Effects(speed = 6, technique = 4, willpower = 6)),
    WING_CHANGE(listOf(Card.ANALYSIS, Card.PLACEKICKS), Effects(kicking = 4, stamina = 6, willpower = 6)),
    ATTACK_WAVES(
        listOf(Card.MINIGAME, Card.RUNNING),
        Effects(kicking = 2, speed = 4, stamina = 4, technique = 2, willpower = 4)
    ),
    RISKY_BLOCK(listOf(Card.SLIDING, Card.MEDITATION), Effects(technique = 2, toughness = 6, willpower = 8)),
    HEART_OF_STEEL(listOf(Card.PKPRACTICE, Card.JUDO), Effects(kicking = 3, stamina = 1, willpower = 12)),
    SAMBA_STEPS(
        listOf(Card.ANALYSIS, Card.SLIDING, Card.AGILITY),
        Effects(kicking = 2, speed = 3, technique = 3, toughness = 3, jumping = 4, willpower = 1)
    ),
    TIME_WASTING(
        listOf(Card.PLACEKICKS, Card.RUNNING, Card.SPA),
        Effects(speed = -4, stamina = 24, jumping = -2, willpower = -2),
        hiddenCombo = true
    ),
    DIVING(
        listOf(Card.SHOOTING, Card.AGILITY, Card.VISUALISING),
        Effects(speed = 24, stamina = -4, willpower = -4),
        hiddenCombo = true
    ),
    DRIBBLING_SHOT(listOf(Card.DRIBBLING, Card.SHOOTING), Effects(kicking = 6, speed = 6, technique = 3)),
    KNUCKLE_SHOT(
        listOf(Card.SHOOTING, Card.OILTHERAPY, Card.MINICAMP),
        Effects(kicking = 6, technique = 3, willpower = 6)
    ),
    BODYWORK(
        listOf(Card.WEIGHTS, Card.SPRINTING, Card.STRETCHING),
        Effects(kicking = 5, speed = 1, toughness = 8, jumping = 1)
    ),
    STRATEGIST(listOf(Card.PASSING, Card.GAMING), Effects(speed = 6, technique = 3, willpower = 6)),
    BALL_MAGICIAN(listOf(Card.PLACEKICKS, Card.FREESTYLING, Card.HEADING), Effects(kicking = 7, technique = 8)),
    MOOD_MAKER(
        listOf(Card.ANALYSIS, Card.MINIGAME, Card.KARAOKE),
        Effects(kicking = 2, stamina = 4, technique = 3, willpower = 6)
    ),
    HUNGRY_FOR_GLORY(
        listOf(Card.WEIGHTS, Card.MEDITATION),
        Effects(kicking = 2, stamina = 6, technique = 3, toughness = 4)
    ),
    GOLDEN_FEET(
        listOf(Card.PRESSURING, Card.KICKING, Card.MEETING),
        Effects(kicking = 2, speed = 2, stamina = 1, technique = 2, toughness = 4, willpower = 4)
    ),
    HOLD_UP_PLAY(listOf(Card.PASSING, Card.HEADING), Effects(technique = 6, toughness = 8)),
    BODY_BALANCE(listOf(Card.FREESTYLING, Card.KICKING), Effects(technique = 7, toughness = 7)),
    SECOND_STRIKE(listOf(Card.PRESSURING, Card.SPRINTING), Effects(kicking = 4, speed = 4, technique = 2, jumping = 4)),
    INTERCEPTING(listOf(Card.SLIDING, Card.VISUALISING), Effects(technique = 4, toughness = 6, willpower = 4)),
    HOLDING_GROUND(listOf(Card.MINIGAME, Card.AEROBICS), Effects(stamina = 6, technique = 4, toughness = 4)),
    CONTROL_TOWER(
        listOf(Card.MINIGAME, Card.MINICAMP),
        Effects(kicking = 2, stamina = 4, technique = 2, willpower = 6)
    ),
    TRICKERY(listOf(Card.SETPLAYS, Card.SIGNING), Effects(kicking = 2, speed = 8, stamina = -2, willpower = 6)),
    MULTITOOL(listOf(Card.ANALYSIS, Card.STRETCHING), Effects(kicking = 2, speed = 4, toughness = 4, willpower = 4)),
    FAN_SERVICE(listOf(Card.ANALYSIS, Card.SIGNING), Effects(stamina = 4, willpower = 10)),
    BLIND_PLACE(
        listOf(Card.SETPLAYS, Card.FREESTYLING, Card.WEIGHTS),
        Effects(kicking = 3, technique = 5, toughness = 4, willpower = 2)
    ),
    FIRST_TOUCH_PASS(listOf(Card.PASSING, Card.FREESTYLING), Effects(speed = 7, technique = 6)),
    VELVET_PASS(listOf(Card.PASSING, Card.STRETCHING), Effects(speed = 1, technique = 4, toughness = 4, willpower = 4)),
    SCISSORS_FEINT(listOf(Card.AGILITY, Card.SIGNING), Effects(speed = 4, technique = 3, willpower = 6)),
    VOCAL_TACTICS(listOf(Card.LINECONTROL, Card.KARAOKE), Effects(stamina = 4, technique = 1, willpower = 8)),
    OFFSIDE_TRAP(listOf(Card.LINECONTROL, Card.MEETING), Effects(stamina = 4, technique = 1, willpower = 8)),
    WONDER_BOY(listOf(Card.COUNTERING, Card.OILTHERAPY, Card.GAMING), Effects(kicking = 3, speed = 6, technique = 4)),
    ROCKET_SHOT(listOf(Card.SHOOTING, Card.RUNNING), Effects(kicking = 5, speed = 6, technique = 1)),
    PIVOT_TURN(listOf(Card.AGILITY, Card.AEROBICS), Effects(speed = 6, technique = 6)),
    COMPACT_FIELD(listOf(Card.PRESSURING, Card.LINECONTROL), Effects(speed = 4, stamina = 4, willpower = 4)),
    MARKING_TRANSFER(
        listOf(Card.MARKING, Card.GAMING),
        Effects(stamina = 4, technique = 2, toughness = 2, willpower = 4)
    ),
    RAPID_TURNAROUND(listOf(Card.COUNTERING, Card.SLIDING), Effects(speed = 6, technique = 3, toughness = 3)),
    OPEN_THE_GATES(
        listOf(Card.MARKING, Card.COUNTERING),
        Effects(speed = 2, stamina = 4, technique = 2, toughness = 4)
    ),
    IRON_DEFENCE(listOf(Card.MARKING, Card.PRESSURING), Effects(kicking = 5, technique = 2, toughness = 5)),
    CONTROLLED_SHOT(listOf(Card.SHOOTING, Card.FREESTYLING), Effects(kicking = 6, technique = 5)),
    VOLLEY_SHOT(listOf(Card.SHOOTING, Card.STRETCHING), Effects(kicking = 9, technique = 2)),
    EYE_CONTACT(listOf(Card.MINIGAME, Card.MEETING), Effects(kicking = 1, speed = 2, technique = 2, willpower = 4)),
    IMPULSE_PLAY(
        listOf(Card.SETPLAYS, Card.VISUALISING),
        Effects(kicking = 3, technique = 2, jumping = 4, willpower = 2)
    ),
    OPEN_SPACE(listOf(Card.COUNTERING, Card.MINIGAME), Effects(kicking = 2, speed = 4, stamina = 4, technique = 1)),
    WING_BLOCK(listOf(Card.PRESSURING, Card.VISUALISING), Effects(speed = 3, technique = 3, willpower = 5)),
    DEADLY_SLIDE(listOf(Card.SLIDING, Card.KICKING, Card.JUDO), Effects(kicking = 3, technique = 7, toughness = 1)),
    TRICKY_FEINT(listOf(Card.ANALYSIS, Card.FREESTYLING), Effects(kicking = 2, speed = 4, technique = 4)),
    MAGIC_TRAPPING(listOf(Card.FREESTYLING, Card.JUDO), Effects(technique = 6, willpower = 4)),
    TRICK_PLAY(listOf(Card.MEETING, Card.SETPLAYS), Effects(kicking = 2, willpower = 8)),
    TRIANGLE(listOf(Card.ANALYSIS, Card.PASSING), Effects(kicking = 1, speed = 6, technique = 3)),
    DIAGONAL_RUN(listOf(Card.RUNNING, Card.VISUALISING), Effects(speed = 3, stamina = 6, willpower = 1)),
    ROCK_A_BYE(
        listOf(Card.MARKING, Card.MINIGAME, Card.OILTHERAPY),
        Effects(kicking = 1, stamina = 2, technique = 1, toughness = 2, jumping = 2, willpower = 2)
    ),
    BRICK_WALL(listOf(Card.KICKING, Card.MEDITATION), Effects(technique = 4, toughness = 1, willpower = 4)),
    BLIND_SHOT(listOf(Card.MARKING, Card.SHOOTING), Effects(kicking = 5, technique = 3)),
    WING_ATTACK(listOf(Card.DRIBBLING, Card.RUNNING), Effects(speed = 1, stamina = 1, toughness = 2, willpower = 4)),
    ATTACK_PIVOT(listOf(Card.DRIBBLING, Card.PKPRACTICE), Effects(kicking = 4, stamina = 2, technique = 2)),
    AFTER_CHARGE(
        listOf(Card.PRESSURING, Card.KICKING, Card.KARAOKE),
        Effects(kicking = 12, technique = -2, willpower = -2),
        hiddenCombo = true
    ),
    LUCKY_CHANCE(
        listOf(Card.COUNTERING, Card.SIGNING, Card.PKPRACTICE),
        Effects(kicking = 5, speed = 1, technique = 1)
    ),
    TITANIC_GOALIE(listOf(Card.SETPLAYS, Card.AGILITY), Effects(technique = 2, jumping = 1, willpower = 4)),
    HAND_OF_GOD(
        listOf(Card.PRESSURING, Card.SHOOTING, Card.HEADING),
        Effects(kicking = 12, technique = -1, willpower = -4),
        hiddenCombo = true
    ),
    BANANA_SHOT(listOf(Card.PLACEKICKS, Card.SHOOTING), Effects(willpower = 4)),
    DETERMINATION(listOf(Card.PRESSURING, Card.MEDITATION), Effects(technique = 3, willpower = 1)),
    ESCAPE_REALITY(
        listOf(Card.GAMING, Card.SPA, Card.KARAOKE),
        Effects(technique = 8, toughness = -4, willpower = -2),
        hiddenCombo = true
    ),
    KEEPER_CHARGE(
        listOf(Card.LINECONTROL, Card.SHOOTING, Card.SLIDING),
        Effects(kicking = -2, technique = 8, jumping = -2, willpower = -2),
        hiddenCombo = true
    ),
    SUPER_REFRESHMENT(
        listOf(Card.AEROBICS, Card.OILTHERAPY, Card.KARAOKE),
        Effects(stamina = 12, technique = 2, willpower = 8)
    );

    fun total(): Int =
        effects.kicking + effects.speed + effects.stamina + effects.technique + effects.toughness + effects.jumping + effects.willpower
}

