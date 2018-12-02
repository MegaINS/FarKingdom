package ru.megains.farkingdom.screen

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Sprite, SpriteBatch, TextureAtlas}
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.{Gdx, InputMultiplexer, Screen}
import org.lwjgl.opengl.GL11
import ru.megains.farkingdom.MainGame
import ru.megains.farkingdom.world.GameCell

import scala.collection.mutable

class WorldMapScreen extends Screen{
    var x:Int = _

    var y:Int = _
    var map: mutable.Map[Int, Int]  = _
    var stage: MainGame = _
    var renderer: OrthogonalTiledMapRenderer = _
    var spriteBatch:SpriteBatch = _
    var texture:Texture =_
    val multiplexer = new InputMultiplexer
    var grass:TextureAtlas =_
    var send:Texture =_
    var grassSprite:Sprite = _
    var sendSprite:Sprite = _
    val group:Group = new Group

    var player:Sprite = _


    override def show(): Unit = {
        stage = new MainGame
        spriteBatch = new SpriteBatch()
        grass = new TextureAtlas("map/grass.atlas")
        grassSprite = grass.createSprite("grass1")
        send = new Texture("map/11697[875x355x8BPP].png")
        sendSprite = new Sprite(send,0,0,174,88)


        player  = new Sprite(new Texture("unit/11952[94x101x8BPP].png"))


        val scale = 1
        for( x <- -x to x;
             y <- -y to y){
            val sprite:Sprite = if(map(getIndex(x,y)) == 0 ) grassSprite else sendSprite
            val gameCell = new GameCell(sprite)
            gameCell.setPosition(
                scale*(x*88-y*88),
                scale*(y*44+x*44)
            )
            gameCell.setScale(scale)
        }




        multiplexer.addProcessor(stage)
        Gdx.input.setInputProcessor(multiplexer)

    }

    override def render(delta: Float): Unit = {
        Gdx.gl.glClearColor(1,0,0,0)
        Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT)
        // stage.act()

        //stage.draw()

        spriteBatch.setProjectionMatrix(stage.cam.combined)
        spriteBatch.begin()
        //  spriteBatch.draw(texture,0,0)


//        val scale = 1
//        for( x <- -x to x;
//             y <- -y to y){
//            val sprite:Sprite = if(map(getIndex(x,y)) == 0 ) grassSprite else sendSprite
//            sprite.setPosition(
//                scale*(x*88-y*88),
//                scale*(y*44+x*44)
//            )
//            sprite.setScale(scale)
//            sprite.draw(spriteBatch)
//            // spriteBatch.draw(sprite,x*90-y*88,y*44+x*44)
//        }
        group.draw(spriteBatch,0)
        player.draw(spriteBatch)
        // spriteBatch.draw(grass,0,0)
        spriteBatch.end()
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

    def getIndex(x:Int,y:Int): Int ={
        (x & 65535) << 16 | (y & 65535)
    }
}
