package ru.megains.farkingdom

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.{OrthographicCamera, Texture}
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.Stage
import ru.megains.farkingdom.screen.WorldMapScreen

class GuiWorld(val worldMapScreen: WorldMapScreen) extends Stage {

    val cam = new OrthographicCamera
    cam.setToOrtho(false, Gdx.graphics.getWidth.toFloat, Gdx.graphics.getHeight.toFloat)
    val w = new ArmyWindows()
    w.setVisible(false)
    w.setPosition(300, 300)
    addActor(w)


    for (i <- GuiWorld.units.indices) {
        GuiWorld.units(i) = new Sprite(new Texture(s"unit/$i.png"))
    }

    for (i <- worldMapScreen.armys.indices) {
        val army = worldMapScreen.armys(i)
        val a: ButtonArmy = new ButtonArmy(army, GuiWorld.units(army.name.toInt))

        a.setPosition(200 + i * 100, 0)
        addActor(a)
        // batch.draw(a, 200 + i * 100, 0)
    }

    override def touchUp(x: Int, y: Int, pointer: Int, button: Int): Boolean = {
        val a = super.touchUp(x, y, pointer, button)
        if (a) {
            true
        } else {
            if (button == 0) {
                val vec = cam.unproject(new Vector3().set(x.toFloat, y.toFloat, 0.0F))
                hit(vec.x, vec.y, false) match {
                    case value: ButtonArmy =>
                        if (worldMapScreen.selectArmy != value.army) {
                            worldMapScreen.selectArmy = value.army
                            w.army = value.army
                            w.setVisible(true)


                        }

                        true
                    case value =>
                        println(value)
                        println("=========================")
                        false

                }

            } else {
                false
            }
        }


    }

    //    override def draw(): Unit = {
    //        super.draw()
    ////        val batch = getBatch
    ////        batch.begin()
    ////
    ////        for (i<- worldMapScreen.armys.indices){
    ////            val army =worldMapScreen.armys(i)
    ////           val a:ImageButton = new ImageButton(new SpriteDrawable(units(army.name.toInt)))
    ////            a.setPosition( 200 + i * 100, 0)
    ////            a.draw(batch,1)
    ////           // batch.draw(a, 200 + i * 100, 0)
    ////        }
    ////
    ////
    ////
    //////        worldMapScreen.selectArmy match {
    //////            case null =>
    //////            case army =>
    //////                for (i <- 0 to 4) {
    //////                    val id = army.array(i)
    //////                    if (id != null) {
    //////                        batch.draw(units(id.name.toInt), 200 + i * 100, 0)
    //////                    }
    //////                }
    //////
    //////        }
    ////        batch.end()
    //    }


}

object GuiWorld {
    var units: Array[Sprite] = new Array[Sprite](10)
}

