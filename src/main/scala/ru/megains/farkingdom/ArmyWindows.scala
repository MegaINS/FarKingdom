package ru.megains.farkingdom

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.ui.{Label, TextButton, Window}
import com.badlogic.gdx.scenes.scene2d.{InputEvent, InputListener}
import ru.megains.farkingdom.world.GameCell


class ArmyWindows() extends Window("", GameCell.skin) {
    setBounds(0, 0, 600, 400)
    var army: Army = _

    val name: Label = new Label("Name", GameCell.skin){
        setScale(2)
    }

    val level: Label = new Label("Level", GameCell.skin)
    val hp: Label = new Label("HP", GameCell.skin)
    val minDam: Label = new Label("Min dam", GameCell.skin)
    val maxDam: Label = new Label("Max dam", GameCell.skin)
    val power: Label = new Label("Power", GameCell.skin)

    val levelVal: Label = new Label("0", GameCell.skin)
    val hpVal: Label = new Label("0", GameCell.skin)
    val minDamVal: Label = new Label("0", GameCell.skin)
    val maxDamVal: Label = new Label("0", GameCell.skin)
    val powerVal: Label = new Label("0", GameCell.skin)
    val exit = new TextButton("EXIT", GameCell.skin) {

        addListener(new InputListener {

            override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = true

            override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {
                getParent.setVisible(false)
            }
        })
    }
    exit.setPosition(560, 360)
    addActor(exit)


    var selectUnit: BUnit = _


    override def draw(batch: Batch, parentAlpha: Float): Unit = {
        super.draw(batch, parentAlpha)

        army match {
            case null =>
            case unit =>
                for (i <- 0 to 4) {
                    val id = army.array(i)
                    if (id != null) {
                        batch.draw(GuiWorld.units(id.name.toInt), getX() + 50 + i * 100, getY())
                    }
                }
        }

        if (selectUnit != null) {
            batch.draw(GuiWorld.units(selectUnit.name.toInt), getX() + 100, getY() + 200)
            batch.draw(GuiWorld.units(selectUnit.name.toInt), getX() + 100, getY() + 200)
            level.setPosition(getX + 200, getY + 300)
            hp.setPosition(getX + 200, getY + 280)
            minDam.setPosition(getX + 200, getY + 260)
            maxDam.setPosition(getX + 200, getY + 240)
            power.setPosition(getX + 200, getY + 220)
            level.draw(batch, parentAlpha)
            hp.draw(batch, parentAlpha)
            minDam.draw(batch, parentAlpha)
            maxDam.draw(batch, parentAlpha)
            power.draw(batch, parentAlpha)


            name.setPosition(getX + 180, getY + 330)
            name.setText(selectUnit.name.toString)
            name.draw(batch, parentAlpha)
            levelVal.setText(selectUnit.level.toString)
            hpVal.setText(selectUnit.hp.toString)
            minDamVal.setText(selectUnit.midDam.toString)
            maxDamVal.setText(selectUnit.maxDam.toString)
            powerVal.setText(selectUnit.power.toString)


            levelVal.setPosition(getX + 300, getY + 300)

            hpVal.setPosition(getX + 300, getY + 280)
            minDamVal.setPosition(getX + 300, getY + 260)
            maxDamVal.setPosition(getX + 300, getY + 240)
            powerVal.setPosition(getX + 300, getY + 220)

            levelVal.draw(batch, parentAlpha)
            hpVal.draw(batch, parentAlpha)
            minDamVal.draw(batch, parentAlpha)
            maxDamVal.draw(batch, parentAlpha)
            powerVal.draw(batch, parentAlpha)
        }

    }

    addListener(new InputListener {

        override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = true

        override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {
            if (button == 0) {
                if (y < 100 && y > 0) {
                    if (x > 50 && x < 550) {
                        val i: Int = ((x - 50) / 100).toInt
                        selectUnit = army.array(i)


                    }
                }
            }
        }
    })

}
