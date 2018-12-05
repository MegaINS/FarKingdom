package ru.megains.farkingdom.screen

import java.net.InetAddress

import com.badlogic.gdx.scenes.scene2d.ui._
import com.badlogic.gdx.scenes.scene2d.{InputEvent, InputListener, Stage}
import com.badlogic.gdx.{Gdx, Screen}
import org.lwjgl.opengl.GL11
import ru.megains.farkingdom.network.handler.NetHandlerLoginClient
import ru.megains.farkingdom.network.packet.CHandshake
import ru.megains.farkingdom.network.packet.login.PacketLogin
import ru.megains.farkingdom.network.{ConnectionState, NetworkManager}


class MainMenu extends Screen {

    var stage: Stage = _
    var name = ""
    var pass = "1111"

    override def show(): Unit = {


        //  val cam = new OrthographicCamera
        // cam.setToOrtho(false, Gdx.graphics.getWidth.toFloat, Gdx.graphics.getHeight.toFloat)
        // var view:ExtendViewport = new ExtendViewport(Gdx.graphics.getWidth.toFloat, Gdx.graphics.getHeight.toFloat, cam)
        stage = new Stage(/* view*/)
        Gdx.input.setInputProcessor(stage)

        val skin: Skin = new Skin(Gdx.files.classpath("uiskin.json"))


        val lLogin = new Label("LOGIN", skin) {
            setPosition(460, 500)
        }
        val txLogin = new TextField("", skin) {
            setPosition(550, 500)
            setSize(150, 25)
        }


        val lPass = new Label("PASSWORD", skin) {
            setPosition(460, 460)
        }
        val txPass = new TextField("1111", skin) {
            setPosition(550, 460)
            setSize(150, 25)
        }


        val button = new TextButton("Enter", skin) {
            setPosition(600, 420)
            addListener(new InputListener() {
                override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {
                    println("touchUp")
                    val inetaddress = InetAddress.getByName("localhost")
                    NetworkManager.createNetworkManagerAndConnect(inetaddress, 8080)
                    NetworkManager.setNetHandler(new NetHandlerLoginClient())
                    NetworkManager.sendPacket(new CHandshake(210, "", 0, ConnectionState.LOGIN))
                    NetworkManager.sendPacket(new PacketLogin(name,pass))
                }

                override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = {
                    println("touchDown")
                    true
                }
            })
        }

        val button1 = new TextButton("Test_1", skin) {
            setPosition(600, 620)
            addListener(new InputListener() {
                override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {
                    println("touchUp")
                    name = "Test_1"
                    txLogin.setText(name)

                }

                override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = {
                    println("touchDown")
                    true
                }
            })
        }
        val button2 = new TextButton("Test_2", skin) {
            setPosition(700, 620)
            addListener(new InputListener() {
                override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {
                    println("touchUp")
                    name = "Test_2"
                    txLogin.setText(name)
                }

                override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = {
                    println("touchDown")
                    true
                }
            })
        }
        stage.addActor(lLogin)
        stage.addActor(txLogin)
        stage.addActor(lPass)
        stage.addActor(txPass)
        stage.addActor(button)
        stage.addActor(button1)
        stage.addActor(button2)



//        val window = new Window("test",skin )
//        stage.addActor(window)
    }

    override def render(delta: Float): Unit = {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 0)
        Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT)
        stage.act()

        stage.draw()
    }

    override def resize(width: Int, height: Int): Unit = {}

    override def pause(): Unit = {}

    override def resume(): Unit = {}

    override def hide(): Unit = {}

    override def dispose(): Unit = {}
}
