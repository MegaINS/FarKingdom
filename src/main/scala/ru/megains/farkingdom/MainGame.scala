package ru.megains.farkingdom

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ru.megains.farkingdom.screen.WorldMapScreen
import ru.megains.farkingdom.world.GameCell


class MainGame(val worldMapScreen: WorldMapScreen) extends Stage {


    val cam = new OrthographicCamera
    cam.setToOrtho(false, Gdx.graphics.getWidth.toFloat, Gdx.graphics.getHeight.toFloat)
    var view:ExtendViewport = new ExtendViewport(Gdx.graphics.getWidth.toFloat, Gdx.graphics.getHeight.toFloat, cam)
    setViewport(view)
   // val player = new Player
   // player.setWidth(100.0F)
  //  player.setHeight(100.0F)
  //  addActor(this.player)
   // player.toFront()
    var move = false

   // val players:mutable.HashMap[Int,Player] = new mutable.HashMap[Int,Player]()
    override def touchDragged(x: Int, y: Int, pointer: Int): Boolean = {
        super.touchDragged(x, y, pointer)
        if (Gdx.input.isButtonPressed(1)) {
            view.getCamera.translate((-Gdx.input.getDeltaX).toFloat, Gdx.input.getDeltaY.toFloat, 0.0F)
            view.getCamera.update()
        }
        move = true
        true
    }

    override def touchUp(x: Int, y: Int, pointer: Int, button: Int): Boolean = {
        super.touchUp(x, y, pointer, button)
        if(button == 0) {
           val vec = cam.unproject(new Vector3().set(x.toFloat, y.toFloat, 0.0F))
           hit(vec.x, vec.y,false) match {
               case gameCell:GameCell=>
                  if( gameCell.army!= null){
                      worldMapScreen.selectArmy = gameCell.army
                  }
                   println(vec.x, vec.y,gameCell.xCell,gameCell.yCell)
                 //  NetworkManager.sendPacket(new SPlayerAction(PlayerAction.MOVE,gameCell.xCell,gameCell.yCell))
                  // FarKingdom.gameScreen.touchUp(x,y, pointer, button)

               case value =>
                   println(value)
                  // Farlands.gameScreen.touchUp(x,y, pointer, button)
           }
//
//
//
//        }
//        if (button == 0 && this.isDown && this.downX == x && this.downY == y) {
//            this.transformation.set(x.toFloat, y.toFloat, 0.0F)
//            this.cam.unproject(this.transformation)
//            this.cancelTouchFocus(this.tuman)
//            val hitActor = this.hit(this.transformation.x, this.transformation.y, false)
//            if (hitActor.isInstanceOf[GameCell]) hitActor.asInstanceOf[GameCell].hitAction()
//            else if (hitActor.isInstanceOf[ResCell]) hitActor.asInstanceOf[ResCell].hitAction()
//            else if (hitActor.isInstanceOf[Mob]) hitActor.asInstanceOf[Mob].hitAction()
//            else if (hitActor.isInstanceOf[Trap]) hitActor.asInstanceOf[Trap].hitAction()
//            Const.screen.click2path(x, y)
       }
        true
    }
    override def touchDown(x: Int, y: Int, pointer: Int, button: Int): Boolean = {
        super.touchUp(x, y, pointer, button)
        move  = false
        true

    }

    def centerCam(): Unit ={

      //  view.getCamera.position.x = player.getX+50
     //   view.getCamera.position.y = player.getY+50
        System.out.println("center cam")

    }
}
