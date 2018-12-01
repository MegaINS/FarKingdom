package ru.megains.farkingdom

import com.badlogic.gdx.Game
import ru.megains.farkingdom.screen.MainMenu

import scala.collection.mutable



object FarKingdom extends Game{

    val futureTaskQueue: mutable.Queue[()=>Unit] = new mutable.Queue[()=>Unit]


    override def create(): Unit = {

        setScreen(new MainMenu)




      //  setScreen(new WorldMapScreen)
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
