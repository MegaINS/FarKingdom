package ru.megains.farlands.gameScreen

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.maps.tiled.{TiledMap, TiledMapTileLayer}
import ru.megains.farlands.{MainGame, Warp}
import ru.megains.farlands.gui.Gui
import ru.megains.farlands.network.packet.PacketBuffer
import ru.megains.farlands.old.Levels


class GameScreenTiled(val levelId:Int,val levelName:String) extends GameScreen {



    val unitScale = 1.0F

    var tiledMap: TiledMap = Levels.getLevel(levelId)
    var collisionLayer: TiledMapTileLayer =  tiledMap.getLayers.get(0).asInstanceOf[TiledMapTileLayer]
    var renderer: OrthogonalTiledMapRenderer = _
    var warps:Array[Warp] = _







//    override def resume(): Unit = {
//
//    }

    override def show(): Unit = {
        super.show()
        renderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale)
     //   this.game = Const.game.getGame
      //  this.gui = Const.game.getGui
      //  Const.screen = this
     //   multiplexer.addProcessor(this.gui)

//        if (!this.isTiled) {
//            this.game.getLevel
//            SendPasket.getLocRectangle()
//        }
    }

//    override def pause(): Unit = {
//
//    }

//    override def hide(): Unit = {
//
//    }

    override def resize(width: Int, height: Int): Unit = {
        super.resize(width, height)
        renderer.setView(MainGame.cam)
        MainGame.centerCam()
     //   this.gui.getViewport.update(width, height, true)
      //  this.gui.resize(width, height)
     //   Const.game.getGame.centerCam()
    }

    override def dispose(): Unit = {
      //  this.game.disposeEnemies()
       // this.game.disposeLevel()
    }

    override def render(delta: Float): Unit = {
      super.render(delta)
      //  if (this.isTiled) {
        renderer.setView(MainGame.cam)
        renderer.render()
      //  }

        MainGame.act(delta)
        Gui.act(delta)
      //  this.gui.act(delta)
       // this.move()
       // this.game.setIndexes()
        MainGame.draw()
        Gui.draw()
      //  this.gui.draw()
    }

//    override def getTransit(x: Int, y: Int): String = {
//        if( collisionLayer.getCell(x, y).getTile.getProperties.containsKey("transit")){
//            collisionLayer.getCell(x, y).getTile.getProperties.get("transit") toString
//        }else{
//            ""
//        }
//
//    }
    override def getTransit(x: Int, y: Int): String = {
        warps.find(w => w.x==x&w.y==y).getOrElse(Warp("",0,0)).name
    }
    override def read(buf: PacketBuffer): Unit = {
        warps = new Array(buf.readInt())
        for(i<- warps.indices){
            warps(i) = Warp(buf.readStringFromBuffer(255), buf.readInt(), buf.readInt())
        }
    }

    override def update(par1: Int, par2: Int): Unit = {

    }
}
