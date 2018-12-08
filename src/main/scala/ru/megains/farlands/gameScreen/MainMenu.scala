package ru.megains.farlands.gameScreen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable
import com.badlogic.gdx.scenes.scene2d.{InputEvent, InputListener, Stage}
import ru.megains.farlands.MainGame
import ru.megains.farlands.network.NetworkManager
import ru.megains.farlands.network.packet.PacketBuffer
import ru.megains.farlands.network.packet.login.{PacketLogin, PacketRegister}
import ru.megains.farlands.old.{MainMenuAtlasLoader, MainMenuTextFields, MyActor}


class MainMenu extends GameScreen {

    var stage:Stage = _
    val mmo = new MainMenuTextFields

    val bgLogin = new MyActor(MainMenuAtlasLoader.bgLogin)
    val btnLogin = new ImageButton (new SpriteDrawable(MainMenuAtlasLoader.btnLoginUp), new SpriteDrawable(MainMenuAtlasLoader.btnLoginDown)) {
        this.setPosition(465.0F, 100.0F)
        this.addListener(new InputListener() {
            override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {
               println("btnLogin")
                NetworkManager.sendPacket(new PacketLogin(mmo.getInputLogin.getText,mmo.getInputPassword.getText))
               // true
            }
            override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = {
                true
            }
        })
    }

    val btnRegister = new ImageButton(new SpriteDrawable(MainMenuAtlasLoader.btnregistration), new SpriteDrawable(MainMenuAtlasLoader.selregistration)){
        this.addListener(new InputListener() {
            setPosition(340.0F, 140.0F)
            override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {
                println("btnRegister")
                NetworkManager.sendPacket(new PacketRegister(mmo.getInputLogin.getText,mmo.getInputPassword.getText))
              //  true
            }
        })
    }






    override def resume(): Unit = {

    }

    override def show(): Unit = {
        stage = new Stage(MainGame.view/* view*/)
        Gdx.input.setInputProcessor(stage)
        bgLogin.setPosition(323.0F, 137.0F)
        stage.addActor(bgLogin)
        stage.addActor(mmo.getInputLogin)
        stage.addActor(mmo.getInputPassword)
        stage.addActor(btnLogin)
        stage.addActor(btnRegister)





    }

    override def pause(): Unit = {

    }

    override def hide(): Unit = {
        dispose()
    }



    override def dispose(): Unit = {
        stage.dispose()
    }

    override def render(delta: Float): Unit = {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F)
        Gdx.gl.glClear(16384)
        stage.act(delta)
        stage.draw()
    }

    override def touchUp(x: Int, y: Int, pointer: Int, button: Int): Unit = {

    }

    override def getTransit(x: Int, y: Int): String = {
        ""
    }

    override def read(buf: PacketBuffer): Unit = ???

    override def update(par1: Int, par2: Int): Unit = {

    }
}
