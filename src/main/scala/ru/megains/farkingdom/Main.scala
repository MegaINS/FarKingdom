package ru.megains.farkingdom


import com.badlogic.gdx.backends.lwjgl3.{Lwjgl3Application, Lwjgl3ApplicationConfiguration}

object Main extends App {
    val cfg = new Lwjgl3ApplicationConfiguration{
        setTitle("FarKingdom")
        setWindowedMode(1200,800)
    }
    new Lwjgl3Application(FarKingdom, cfg)
}
