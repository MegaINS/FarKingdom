package ru.megains.farkingdom

object PlayerAction extends Enumeration {
        type PlayerAction = Value
        val MOVE, WALKING, DEAD,CHANGE_LOC,MINE = Value
}