package ru.megains.farkingdom.world

import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.{Label, Skin}
import ru.megains.farkingdom.Army

class GameCell(var name: String, val xCell: Int, val yCell: Int) extends Actor {

    var army: Army = _
    var sprite: Sprite = _
    var lable:Label = new Label( s"x:$xCell,y:$yCell",GameCell.skin)
    // setSize(174.0F, 88.0F)
    setBounds(0.0F, 0.0F, 174.0F, 88.0F)

  //  setPosition(xCell * 88 - yCell * 88, yCell * 44 + xCell * 44)
    setPosition(xCell*88 + yCell*88,-xCell*44+yCell*44)

    override def draw(batch: Batch, parentAlpha: Float): Unit = {
        // super.draw(batch, parentAlpha)
        if (sprite != null) {
            sprite.setPosition(getX(),getY())
            sprite.draw(batch)
            lable.setPosition(55+getX,33+ getY)
            lable.draw(batch,parentAlpha)

        }
        if (army != null) {
            army.sprite.setPosition(28+getX,35+ getY())
            army.sprite.draw(batch)
        }
    }

    override def hit(x: Float, y: Float, touchable: Boolean): Actor = {
        val xIn:Float = Math.abs(x - 87)
        val yIn:Float = Math.abs(y - 44)



        //        println(x-87,y-44,xCell,yCell)
        //
        //        if(((174f/88f)/2f * xIn + yIn) <174f/2f){
        //            println("Ok")
        //        }


        if (xIn < 88 && yIn <= 44) {
            if((xIn + 87f/44f * yIn)<87){
//                println("-----------------")
//                println(xIn, yIn)
//                println(x - 174 / 2, y - 44, xCell, yCell)
//                println("*/*********************")
                this
            }else{
                null
            }

        }else{
            null
        }

        //        val xIn =  Math.abs(x - xCell * 174 -174/2)
        //        val yIn = Math.abs( y -  yCell * 88 -42)
        //        if (touchable && (getTouchable != Touchable.enabled)) null
        //        else if (((174f / 2f) / 88f) * xIn + yIn < (88f / 2f)) this
        //        else null

    }


}
object GameCell{
    var skin: Skin =_
}
