package ru.megains.farkingdom.world

import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.scenes.scene2d.Actor
import ru.megains.farkingdom.Army

class GameCell(var name: String,val xCell:Int,val yCell:Int) extends Actor{

    var army: Army = _
    var sprite: Sprite =_

   // setSize(174.0F, 88.0F)
    setBounds(0.0F, 0.0F, 174.0F, 88.0F)

    setPosition(xCell*88-yCell*88, yCell*44+xCell*44)


    override def draw(batch: Batch, parentAlpha: Float): Unit ={
       // super.draw(batch, parentAlpha)
        if(sprite!= null){
            sprite.setPosition(getX,getY)
            sprite.draw(batch)
        }
        if(army!= null){
            army.sprite.setPosition(getX,getY)
            army.sprite.draw(batch)
        }
    }

    override def hit(x: Float, y: Float, touchable: Boolean): Actor = super.hit(x, y, touchable)



}
