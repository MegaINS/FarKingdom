package ru.megains.farkingdom.world

import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.scenes.scene2d.Actor

class GameCell(val sprite: Sprite) extends Actor{




    override def draw(batch: Batch, parentAlpha: Float): Unit ={
       // super.draw(batch, parentAlpha)
        sprite.draw(batch)
    }



}
