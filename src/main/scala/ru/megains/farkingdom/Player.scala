package ru.megains.farkingdom

import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.scenes.scene2d.Actor

class Player(val sprite:Sprite)  extends Actor{

    var playerX:Int = 0
    var playerY:Int = 0
    def setPos(x:Int,y:Int): Unit ={
        playerX = x
        playerY = y
        setPosition(28+playerX*88-playerY*88,35+ playerY*44+playerX*44)
    }

    override def draw(batch: Batch, parentAlpha: Float): Unit ={
        // super.draw(batch, parentAlpha)
        if(sprite!= null){
            sprite.setPosition(getX,getY)
            sprite.draw(batch)
        }

    }
}
