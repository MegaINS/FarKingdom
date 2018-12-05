package ru.megains.farkingdom.screen

import com.badlogic.gdx.Screen

abstract class GameScreen extends Screen{




    def touchUp(x: Int, y: Int, pointer: Int, button: Int): Unit

}
