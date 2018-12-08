package ru.megains.farlands

import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.scenes.scene2d.Actor
import ru.megains.farlands.old.DangeAtlasLoader

class WarpCell(cellX:Int, cellY:Int) extends Actor{
    var sprite:Sprite = DangeAtlasLoader.enter
    setSize(100.0F, 100.0F)
    setBounds(0.0F, 0.0F, 100.0F, 100.0F)
    setPosition(cellX * 100, cellY * 100)



    override def draw(batch: Batch, parentAlpha: Float): Unit = {
        if (this.sprite != null) batch.draw(sprite, getX, getY, getOriginX, getOriginY, getWidth, getHeight, getScaleX, getScaleY, getRotation)
    }
}
