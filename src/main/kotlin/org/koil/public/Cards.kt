package org.koil.public

enum class CardType {
    TACTICAL,
    TECHNICAL,
    PHYSICAL,
    SUPPORT;

    fun toLowercase():String = this.toString().lowercase()
}

enum class Card(val cardType: CardType) {
    ANALYSIS(CardType.TACTICAL),
    MARKING(CardType.TACTICAL),
    PRESSURING(CardType.TACTICAL),
    COUNTERING(CardType.TACTICAL),
    MINIGAME(CardType.TACTICAL),
    LINECONTROL(CardType.TACTICAL),
    SETPLAYS(CardType.TACTICAL),

    DRIBBLING(CardType.TECHNICAL),
    PLACEKICKS(CardType.TECHNICAL),
    SHOOTING(CardType.TECHNICAL),
    PASSING(CardType.TECHNICAL),
    FREESTYLING(CardType.TECHNICAL),
    SLIDING(CardType.TECHNICAL),
    HEADING(CardType.TECHNICAL),

    RUNNING(CardType.PHYSICAL),
    WEIGHTS(CardType.PHYSICAL),
    KICKING(CardType.PHYSICAL),
    SPRINTING(CardType.PHYSICAL),
    AGILITY(CardType.PHYSICAL),
    AEROBICS(CardType.PHYSICAL),
    STRETCHING(CardType.PHYSICAL),

    OILTHERAPY(CardType.SUPPORT),
    MEDITATION(CardType.SUPPORT),
    SIGNING(CardType.SUPPORT),
    PKPRACTICE(CardType.SUPPORT),
    JUDO(CardType.SUPPORT),
    VISUALISING(CardType.SUPPORT),
    MEETING(CardType.SUPPORT),
    SPA(CardType.SUPPORT),
    MINICAMP(CardType.SUPPORT),
    GAMING(CardType.SUPPORT),
    KARAOKE(CardType.SUPPORT)
}