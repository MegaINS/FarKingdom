package ru.megains.farkingdom.screen

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch, TextureAtlas}
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.{Gdx, InputMultiplexer}
import org.lwjgl.opengl.GL11
import ru.megains.farkingdom._
import ru.megains.farkingdom.network.NetworkManager
import ru.megains.farkingdom.network.packet.play.SPlayerAction
import ru.megains.farkingdom.world.GameCell

import scala.collection.mutable

class WorldMapScreen extends GameScreen {


    var x: Int = _

    var y: Int = _
    var map: mutable.Map[Int, GameCell] = _
    var stage: MainGame = _
    var gui: GuiWorld = _
    var renderer: OrthogonalTiledMapRenderer = _
    var spriteBatch: SpriteBatch = _
    var texture: Texture = _
    val multiplexer = new InputMultiplexer
    var grass: TextureAtlas = _
    var send: TextureAtlas = _
    var grassSprite: Sprite = _
    var sendSprite: Sprite = _
    val group: Group = new Group

    var selectArmy:Army = _

    val players: mutable.HashMap[Int, Player] = new mutable.HashMap[Int, Player]()
    val sprites: mutable.HashMap[String, Sprite] = new mutable.HashMap[String, Sprite]()
    var player: Sprite = _
    var entity: Sprite = _

    var units: Array[Sprite] = new Array[Sprite](10)

    override def show(): Unit = {
        stage = new MainGame(this)
        spriteBatch = new SpriteBatch()
        grass = new TextureAtlas("world/tile/grass.atlas")
        send = new TextureAtlas("world/tile/send.atlas")
        sprites += "grass1" -> grass.createSprite("grass1")
        sprites += "send1" -> send.createSprite("send1")

        for (i <- units.indices) {
            units(i) = new Sprite(new Texture(s"world/unit/$i.png"))
        }

        player = new Sprite(new Texture("world/unit/10.png"))
        entity = new Sprite(new Texture("world/unit/11.png"))
        for (x1 <- -x to x;
             y1 <- -y to y) {
            val x = x1 * -1
            val y = y1 * -1

            val gameCell = map(getIndex(x, y))
            gameCell.sprite = sprites(gameCell.name)


            if ( gameCell.army!= null) {
                gameCell.army.sprite = units(gameCell.army.name toInt)
            }
            group.addActor(gameCell)


        }

        stage.addActor(group)

        gui = new GuiWorld(this)

        multiplexer.addProcessor(stage)
        Gdx.input.setInputProcessor(multiplexer)

    }

    def addPlayer(id: Int, i: Boolean, posX: Int, posY: Int): Unit = {

        if (i) {
            players += id -> new Player(player)

        } else {
            players += id -> new Player(entity)
        }
        players(id).setPos(posX, posY)
        stage.addActor(players(id))
    }

    override def render(delta: Float): Unit = {
        Gdx.gl.glClearColor(1, 0, 0, 0)
        Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT)


        stage.act()

        stage.draw()


        gui.act()
        gui.draw()
//        spriteBatch.setProjectionMatrix(stage.cam.combined)
//        spriteBatch.begin()
//
//
//        spriteBatch.end()
    }

    override def resize(width: Int, height: Int): Unit = {

    }

    override def pause(): Unit = {

    }

    override def resume(): Unit = {

    }

    override def hide(): Unit = {

    }

    override def dispose(): Unit = {

    }

    def getIndex(x: Int, y: Int): Int = {
        (x & 65535) << 16 | (y & 65535)
    }

    override def touchUp(x: Int, y: Int, pointer: Int, button: Int): Unit = {
        val newX: Int = x - (Gdx.graphics.getWidth / 2 - stage.getCamera.position.x) toInt
        val newY = ((Gdx.graphics.getHeight / 2 + stage.getCamera.position.y) - y) toInt


        println(s"x = $x, y = $y")
        println(s"x = ${newX}, y = ${newY}")
        println(s"x = ${newX / 174}, y = ${newY / 88}")
        NetworkManager.sendPacket(new SPlayerAction(PlayerAction.MOVE, newX / 174, newY / 88))


    }
}
