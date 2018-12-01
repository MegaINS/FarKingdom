
name := "FarKingdom"

version := "0.1"

scalaVersion := "2.12.7"

val libgdxVersion = "1.9.8"

libraryDependencies ++= Seq(
    //  "com.badlogicgames.gdx" % "gdx" % libgdxVersion,
    // "net.sf.proguard" % "proguard-base" % "4.11" % "provided",


    "com.badlogicgames.gdx" % "gdx-controllers-lwjgl3" % libgdxVersion,
    "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % libgdxVersion,
    // "com.badlogicgames.gdx" % "gdx-freetype" % libgdxVersion,
    //  "com.badlogicgames.gdx" % "gdx-tools" % libgdxVersion,

    //  "com.badlogicgames.gdx" % "gdx-freetype-platform" % libgdxVersion  classifier "natives-desktop",
    "com.badlogicgames.gdx" % "gdx-platform" % libgdxVersion classifier "natives-desktop",

    "io.netty" % "netty-all" % "5.0.0.Alpha2",
    "org.apache.logging.log4j" % "log4j-core" % "2.8.2",
    "org.apache.logging.log4j" % "log4j-api" % "2.8.2"
)