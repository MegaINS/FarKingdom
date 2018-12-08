package ru.megains.farlands.gameScreen

import com.badlogic.gdx.scenes.scene2d.Group
import ru.megains.farlands.gui.Gui
import ru.megains.farlands.network.packet.PacketBuffer
import ru.megains.farlands.old.{DangePathsAtlasLoader, GameCell}
import ru.megains.farlands.{MainGame, Warp, WarpCell}

import scala.util.Random

class GameScreenMine extends GameScreen {

    var weight = 0
    var height = 0
    var tileGrounds:Array[Int] = _
    var gameCells:Array[GameCell] = _
    var warps:Array[Warp] = _
    val gameSell:Group = new Group

    override def show(): Unit = {
        super.show()
        MainGame.addActor(gameSell)
        gameCells = new Array[GameCell](tileGrounds.length)
        for(x<-0 until weight;
            y<-0 until height){

            val gameCell = new GameCell(x,y,tileGrounds(x+y*height),Random.nextInt(6))
            gameCells(x+y*height) = gameCell
            gameSell.addActor(gameCell)

        }
        warps.foreach{
            warp =>
                val warpCell = new WarpCell(warp.x,warp.y)
                gameSell.addActor(warpCell)
        }

        gameCells.foreach(setCellSprite)



    }

    private def setCellSprite(cell: GameCell): Unit = {
        val xx = cell.getCellX
        val yy = cell.getCellY
        if (cell.isEmpty) {
            var lCell = false
            var rCell = false
            var uCell = false
            var dCell = false
            if (xx - 1 >= 0 && gameCells((xx - 1)+yy*height)  != null) lCell = gameCells((xx - 1)+yy*height).isEmpty
            if (xx + 1 < weight && gameCells((xx + 1)+yy*height)  != null) rCell = gameCells((xx + 1)+yy*height).isEmpty
            if (yy - 1 >= 0 && gameCells(xx +(yy-1)*height)  != null) dCell = gameCells(xx +(yy-1)*height).isEmpty
            if (yy + 1 < height  && gameCells(xx +(yy+1)*height) != null) uCell = gameCells(xx +(yy+1)*height).isEmpty
            if (!lCell && !rCell && !uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path0)
            else if (!lCell && rCell && uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path1)
            else if (lCell && rCell && uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path2)
            else if (lCell && !rCell && uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path3)
            else if (!lCell && rCell && uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path4)
            else if (lCell && rCell && uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path5)
            else if (lCell && !rCell && uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path6)
            else if (!lCell && rCell && !uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path7)
            else if (lCell && rCell && !uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path8)
            else if (lCell && !rCell && !uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path9)
            else if (!lCell && !rCell && uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path10)
            else if (lCell && rCell && !uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path11)
            else if (!lCell && rCell && !uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path12)
            else if (lCell && !rCell && !uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path13)
            else if (!lCell && !rCell && uCell && !dCell) cell.setSprite(DangePathsAtlasLoader.path14)
            else if (!lCell && !rCell && !uCell && dCell) cell.setSprite(DangePathsAtlasLoader.path15)
        }
    }

    override def getTransit(x: Int, y: Int): String = {
        warps.find(w => w.x==x&w.y==y).getOrElse(Warp("",0,0)).name
    }

    override def read(buf: PacketBuffer): Unit = {
        weight = buf.readInt()
        height = buf.readInt()
        tileGrounds  = new Array(weight*height)
        for(i<-tileGrounds.indices){
            tileGrounds(i) = buf.readInt()
        }

        warps = new Array(buf.readInt())
        for(i<- warps.indices){
            warps(i) = Warp(buf.readStringFromBuffer(255), buf.readInt(), buf.readInt())
        }
    }

    override def render(delta: Float): Unit ={
        super.render(delta)
        MainGame.act(delta)
        Gui.act(delta)

        MainGame.draw()
        Gui.draw()
    }

    override def dispose(): Unit = {
        super.dispose()
        gameSell.clearChildren()
    }

    override def update(par1: Int, par2: Int): Unit = {
        var gameCell = gameCells(par1+par2*height)
        gameCell.isEmpty = true
        setCellSprite(gameCell)

        gameCell = gameCells(par1+par2*height+1)
        if(gameCell.isEmpty) setCellSprite(gameCell)

        gameCell = gameCells(par1+par2*height-1)
        if(gameCell.isEmpty) setCellSprite(gameCell)

        gameCell = gameCells(par1+(par2+1)*height)
        if(gameCell.isEmpty) setCellSprite(gameCell)

        gameCell = gameCells(par1+(par2-1)*height)
        if(gameCell.isEmpty) setCellSprite(gameCell)
    }
}
