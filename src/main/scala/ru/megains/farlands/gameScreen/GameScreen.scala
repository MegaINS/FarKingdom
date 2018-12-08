package ru.megains.farlands.gameScreen

import com.badlogic.gdx.{Gdx, InputMultiplexer, Screen}
import ru.megains.farlands.MainGame
import ru.megains.farlands.gui.Gui
import ru.megains.farlands.network.NetworkManager
import ru.megains.farlands.network.packet.PacketBuffer
import ru.megains.farlands.network.packet.play.SPlayerAction
import ru.megains.farlands.player.PlayerAction

abstract class GameScreen extends Screen{
    def update(par1: Int, par2: Int): Unit



    def read(buf: PacketBuffer): Unit



    val multiplexer = new InputMultiplexer




    def touchUp(x: Int, y: Int, pointer: Int, button: Int): Unit ={
        val newX:Int = x - (Gdx.graphics.getWidth/2 -MainGame.getCamera.position.x ) toInt
        val newY = ((Gdx.graphics.getHeight/2 +MainGame.getCamera.position.y) -y ) toInt


        println(s"x = $x, y = $y")
        println(s"x = ${newX}, y = ${  newY}")
        println(s"x = ${newX /100}, y = ${  newY/100}")
        NetworkManager.sendPacket(new SPlayerAction(PlayerAction.MOVE,newX /100,newY/100))



    }
    def mine(x: Int, y: Int, pointer: Int, button: Int): Unit ={
        val newX:Int = x - (Gdx.graphics.getWidth/2 -MainGame.getCamera.position.x ) toInt
        val newY = ((Gdx.graphics.getHeight/2 +MainGame.getCamera.position.y) -y ) toInt


        println(s"x = $x, y = $y")
        println(s"x = ${newX}, y = ${  newY}")
        println(s"x = ${newX /100}, y = ${  newY/100}")
        NetworkManager.sendPacket(new SPlayerAction(PlayerAction.MINE,newX /100,newY/100))
    }



    override def resume(): Unit = {

    }

    override def show(): Unit = {
        multiplexer.addProcessor(Gui)
        multiplexer.addProcessor(MainGame)
        Gdx.input.setInputProcessor(multiplexer)
    }

    override def pause(): Unit = {

    }

    override def hide(): Unit = {

    }

    override def resize(width: Int, height: Int): Unit = {
        MainGame.getViewport.update(width, height, true)
        MainGame.getCamera.viewportWidth = width.toFloat
        MainGame.getCamera.viewportHeight = height.toFloat
    }

    override def dispose(): Unit = {

    }

    override def render(delta: Float): Unit = {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F)
        Gdx.gl.glClear(16384)

    }

    def getTransit(x:Int, y:Int): String


}
