package ru.megains.farkingdom

import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.scenes.scene2d.Actor

class ButtonArmy(val army: Army,sprite: Sprite) extends Actor{


    setBounds( 0,0,87, 119)


    override def draw(batch: Batch, parentAlpha: Float): Unit = {
        super.draw(batch, parentAlpha)

        sprite.setPosition(getX,getY)
        sprite.draw(batch)

    }

}
