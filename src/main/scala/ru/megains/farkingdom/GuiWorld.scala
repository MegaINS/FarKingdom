package ru.megains.farkingdom

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Stage
import ru.megains.farkingdom.screen.WorldMapScreen

class GuiWorld(val worldMapScreen: WorldMapScreen) extends Stage {


    var units: Array[Sprite] = new Array[Sprite](10)

    for (i <- units.indices) {
        units(i) = new Sprite(new Texture(s"unit/$i.png"))
    }


    override def draw(): Unit = {
        super.draw()
        val batch = getBatch
        batch.begin()
        worldMapScreen.selectArmy match {
            case null =>
            case army =>
                for (i <- 0 to 4) {
                    val id = army.array(i)
                    if (id != null) {
                        batch.draw(units(id.name.toInt), 200 + i * 100, 0)
                    }
                }

        }
        batch.end()
    }
}
