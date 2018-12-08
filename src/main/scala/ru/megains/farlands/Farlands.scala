package ru.megains.farlands

import java.net.InetAddress

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.scenes.scene2d.Stage
import ru.megains.farlands.gameScreen.{GameScreen, MainMenu}
import ru.megains.farlands.gui.Gui
import ru.megains.farlands.old._


object Farlands extends Game {

    var game: Stage = _

    var font:BitmapFont = _
    var batch:SpriteBatch = _
    var img:Texture = _
    var gameScreen:GameScreen = _
    var gui:Stage = _


    override def create(): Unit = {

        UserInfoAtlasLoader.load()
        MainMenuAtlasLoader.load()
        GuiAtlasLoader.load()
        DangeAtlasLoader.load(3)
        Styles.load()
        Levels.load()
        DangePathsAtlasLoader.load(3)
        PlayersAtlasLoader.load(true)
        game = MainGame
        gui = Gui
        val menu = new MainMenu
        setScreen(menu)

        val inetaddress = InetAddress.getByName("localhost")
      //  NetworkManager.createNetworkManagerAndConnect(inetaddress, 8080)
       // NetworkManager.setNetHandler(new NetHandlerLoginClient())
       // NetworkManager.sendPacket(new CHandshake(210, "", 0, ConnectionState.LOGIN))
       // networkManager.sendPacket(new CPacketLoginStart(oc.playerName))
    }


}
