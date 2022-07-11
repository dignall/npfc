package org.koil.public

enum class CardTypes {
    TACTICAL,
    TECHNICAL,
    PHYSICAL,
    SUPPORT
}

enum class Card(types: CardTypes) {
    ANALYSIS(CardTypes.TACTICAL),
    MARKING(CardTypes.TACTICAL),
    PRESSURING(CardTypes.TACTICAL),
    COUNTERING(CardTypes.TACTICAL),
    MINIGAME(CardTypes.TACTICAL),
    LINECONTROL(CardTypes.TACTICAL),
    SETPLAYS(CardTypes.TACTICAL),

    DRIBBLING(CardTypes.TECHNICAL),
    PLACEKICKS(CardTypes.TECHNICAL),
    SHOOTING(CardTypes.TECHNICAL),
    PASSING(CardTypes.TECHNICAL),
    FREESTYLE(CardTypes.TECHNICAL),
    SLIDING(CardTypes.TECHNICAL),
    HEADING(CardTypes.TECHNICAL),

    RUNNING(CardTypes.PHYSICAL),
    WEIGHTS(CardTypes.PHYSICAL),
    KICKING(CardTypes.PHYSICAL),
    SPRINTING(CardTypes.PHYSICAL),
    AGILITY(CardTypes.PHYSICAL),
    AEROBICS(CardTypes.PHYSICAL),
    STRETCHING(CardTypes.PHYSICAL),

    OILTHERAPY(CardTypes.SUPPORT),
    MEDITATION(CardTypes.SUPPORT),
    SIGNING(CardTypes.SUPPORT),
    PKPRACTICE(CardTypes.SUPPORT),
    JUDO(CardTypes.SUPPORT),
    VISUALISING(CardTypes.SUPPORT),
    MEETING(CardTypes.SUPPORT),
    SPA(CardTypes.SUPPORT),
    GAMING(CardTypes.SUPPORT),
    MINICAMP(CardTypes.SUPPORT),
}