package ru.megains.farkingdom

import com.badlogic.gdx.Game
import ru.megains.farkingdom.screen.{GameScreen, MainMenu}

import scala.collection.mutable



object FarKingdom extends Game{

    val futureTaskQueue: mutable.Queue[()=>Unit] = new mutable.Queue[()=>Unit]
    var gameScreen:GameScreen = _

    override def create(): Unit = {

        setScreen(new MainMenu)

    }

    def setScreen(screen: GameScreen): Unit = {
        gameScreen = screen
        super.setScreen(screen)
    }

    override def render(): Unit = {

        futureTaskQueue synchronized {
            while (futureTaskQueue.nonEmpty){
                val a = futureTaskQueue.dequeue()
                if(a!= null) a()
            }

        }


        super.render()

    }


}
