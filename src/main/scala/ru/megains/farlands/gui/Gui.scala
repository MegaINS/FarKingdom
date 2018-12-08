package ru.megains.farlands.gui

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable
import ru.megains.farlands.old.{BtnEnter, GuiAtlasLoader, MyActor}
import ru.megains.farlands.{Farlands, MainGame}


object Gui extends Stage{

    var disEnter:MyActor = _

    var btnEnter:BtnEnter = _

    //val cam = new OrthographicCamera((Gdx.graphics.getWidth * 2).toFloat, (Gdx.graphics.getHeight * 2).toFloat)
   // val view = new ScreenViewport(this.cam)
   // this.setViewport(this.view)

    disEnter = new MyActor(GuiAtlasLoader.disEnter)
    disEnter.setPosition(8.0F, 14.0F)

    addActor(disEnter)
    btnEnter = new BtnEnter(new SpriteDrawable(GuiAtlasLoader.btnEnter), new SpriteDrawable(GuiAtlasLoader.overEnter))
    btnEnter.setPosition(8.0F, 14.0F)
    btnEnter.disable()
    addActor(btnEnter)

    def update(): Unit ={
        if(Farlands.gameScreen ne null){
            val transit = Farlands.gameScreen.getTransit(MainGame.player.getPlayerX,MainGame.player.getPlayerY)
            if(transit eq "" ){
                btnEnter.disable()
            }else{
                btnEnter.enable(transit)
            }
        }
    }


}
