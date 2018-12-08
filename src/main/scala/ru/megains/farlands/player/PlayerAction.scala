package ru.megains.farlands.player

object PlayerAction extends Enumeration {
        type PlayerAction = Value
        val MOVE, WALKING, DEAD,CHANGE_LOC,MINE = Value
}