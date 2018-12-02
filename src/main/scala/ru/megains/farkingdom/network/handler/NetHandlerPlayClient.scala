package ru.megains.farkingdom.network.handler

import ru.megains.farkingdom.{FarKingdom, Logger}
import ru.megains.farkingdom.network.packet.play.SPacketWorldLoad
import ru.megains.farkingdom.screen.WorldMapScreen

class NetHandlerPlayClient extends INetHandler with Logger[NetHandlerPlayClient] {


    def processWorldLoad(load: SPacketWorldLoad): Unit = {


        val world:WorldMapScreen = new WorldMapScreen
        world.x = load.x
        world.y = load.y
        world.map = load.map
        FarKingdom.setScreen(world)
    }


    //    def packetPlayerInfo(info: SPacketPlayerInfo): Unit = {
//        MainGame.player.init("",info.id)
//    }


//    def playerMove(move: CPlayerMove): Unit = {
//        MainGame.player.setPosition(move.posX,move.posY)
//    }


//    def packetLocInfo(info: SPacketLocInfo): Unit = {
//        Gdx.app.postRunnable(new Runnable() {
//            override def run(): Unit = {
//                if(Farlands.gameScreen !=null)Farlands.gameScreen.dispose()
//                MainGame.players.values.foreach( MainGame.getRoot.removeActor)
//                MainGame.players.clear()
//                Farlands.gameScreen = info.location
//                Farlands.setScreen(Farlands.gameScreen)
//                MainGame.player.setPosition(info.posX, info.posY)
//                MainGame.player.loadAnimations()
//                MainGame.centerCam()
//            }
//        })
//    }
//    def locUpdate(update: SLocUpdate): Unit = {
//        Farlands.gameScreen.update(update.par1,update.par2)
//    }
//    def locationPlayer(in: SLocationPlayer): Unit = {
//        in.locAction match {
//            case LocAction.ENTER =>
//                in.players.foreach{
//                    case (id,posX,posY)=>
//                        val player = new Player()
//                        player.init("",id)
//                        player.setWidth(100.0F)
//                        player.setHeight(100.0F)
//                        MainGame.addActor(player)
//                        player.toFront()
//                        player.setPosition(posX, posY)
//                       // player.loadPlayerAtlas(false)
//                        player.loadAnimations()
//                        MainGame.players += id -> player
//
//
//                }
//
//
//            case LocAction.MOVE =>
//                in.players.foreach{
//                   case (id,posX,posY)=>
//                        if(id == MainGame.player.getId){
//                            MainGame.player.setPosition(posX,posY)
//                        }else{
//                            MainGame.players(id).setPosition(posX,posY)
//                        }
//                }
//            case LocAction.EXIT =>
//                in.players.foreach{
//                    case (id,posX,posY)=>
//                        MainGame.getRoot.removeActor( MainGame.players(id))
//                        MainGame.players -= id
//
//                }
//        }
//    }



    // var clientWorldController: WorldClient = _


//
//    def handleHeldItemChange(packetIn: SPacketHeldItemChange): Unit = {
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, gameController)
//        if (InventoryPlayer.isHotBar(packetIn.heldItemHotbarIndex)) this.gameController.player.inventory.stackSelect = packetIn.heldItemHotbarIndex
//    }
//
//    override def onDisconnect(msg: String): Unit = {
//
//    }
//
//    def sendPacket(packetIn: Packet[_ <: INetHandler]) {
//        netManager.sendPacket(packetIn)
//    }
//
//    override def handleJoinGame(packetIn: SPacketJoinGame): Unit = {
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, gameController)
//
//        gameController.playerController = new PlayerControllerMP(gameController, this)
//        clientWorldController = new WorldClient(this)
//        gameController.loadWorld(clientWorldController)
//        gameController.guiManager.setGuiScreen(new GuiDownloadTerrain(this))
//        // gameController.player.setEntityId(packetIn.getPlayerId)
//        //  currentServerMaxPlayers = packetIn.getMaxPlayers
//        // gameController.player.setReducedDebug(packetIn.isReducedDebugInfo)
//
//        //  gameController.gameSettings.sendSettingsToServer()
//        //  netManager.sendPacket(new CPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer).writeString(ClientBrandRetriever.getClientModName)))
//    }
//
//    override def handlePlayerPosLook(packetIn: SPacketPlayerPosLook): Unit = {
//
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, gameController)
//        val entityplayer: EntityPlayer = gameController.player
//        var d0: Double = packetIn.x
//        var d1: Double = packetIn.y
//        var d2: Double = packetIn.z
//        var f: Float = packetIn.yaw
//        var f1: Float = packetIn.pitch
//        if (packetIn.flags.contains(SPacketPlayerPosLook.EnumFlags.X)) d0 += entityplayer.posX
//        else entityplayer.motionX = 0.0D
//        if (packetIn.flags.contains(SPacketPlayerPosLook.EnumFlags.Y)) d1 += entityplayer.posY
//        else entityplayer.motionY = 0.0D
//        if (packetIn.flags.contains(SPacketPlayerPosLook.EnumFlags.Z)) d2 += entityplayer.posZ
//        else entityplayer.motionZ = 0.0D
//        if (packetIn.flags.contains(SPacketPlayerPosLook.EnumFlags.X_ROT)) f1 += entityplayer.rotationPitch
//        if (packetIn.flags.contains(SPacketPlayerPosLook.EnumFlags.Y_ROT)) f += entityplayer.rotationYaw
//        entityplayer.setPositionAndRotation(d0, d1, d2, f, f1)
//        // netManager.sendPacket(new CPacketConfirmTeleport(packetIn.getTeleportId))
//
//        netManager.sendPacket(new CPacketPlayer.PositionRotation(entityplayer.posX, entityplayer.body.minY, entityplayer.posZ, entityplayer.rotationYaw, entityplayer.rotationPitch, false))
//        if (!doneLoadingTerrain) {
//            gameController.player.prevPosX = gameController.player.posX
//            gameController.player.prevPosY = gameController.player.posY
//            gameController.player.prevPosZ = gameController.player.posZ
//            doneLoadingTerrain = true
//            gameController.guiManager.setGuiScreen(null)
//        }
//    }
//
//    def handleChunkData(packetIn: SPacketChunkData): Unit = {
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, gameController)
//
//
//        val pos = new ChunkPosition(packetIn.chunkX, packetIn.chunkY, packetIn.chunkZ)
//
//        clientWorldController.doPreChunk(pos, loadChunk = true)
//        val chunk = clientWorldController.getChunk(pos)
//        chunk.blockStorage = packetIn.blockStorage
//        gameController.worldRenderer.reRender(chunk.position)
//
//    }
//
//
//    def handleBlockChange(packetIn: SPacketBlockChange) {
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, gameController)
//        clientWorldController.invalidateRegionAndSetBlock(packetIn.blockPosition, packetIn.block,packetIn.meta)
//
//    }
//
//    def handleMultiBlockChange(packetIn: SPacketMultiBlockChange) {
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, gameController)
//        for (blockData <- packetIn.changedBlocks) {
//            clientWorldController.invalidateRegionAndSetBlock(blockData.blockPosition, blockData.block,blockData.meta)
//        }
//    }
//
//    override def handleSetSlot(packetIn: SPacketSetSlot): Unit = {
//        if (packetIn.slot == -1) {
//            gameController.player.inventory.itemStack = packetIn.item
//        } else {
//            gameController.player.openContainer.putStackInSlot(packetIn.slot, packetIn.item)
//        }
//
//    }
//
//    override def handleWindowItems(packetIn: SPacketWindowItems): Unit = {
//        val openContainer = gameController.player.openContainer
//
//        for (i <- packetIn.itemStacks.indices) {
//            openContainer.putStackInSlot(i, packetIn.itemStacks(i))
//        }
//    }
//
//    override def handlePlayerListItem(packetIn: SPacketPlayerListItem): Unit = {
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, gameController)
//
//    }
//
//    override def handleChangeGameState(packetIn: SPacketChangeGameState): Unit = {
//        packetIn.state match {
//            case 3 => gameController.playerController.setGameType(GameType(packetIn.value))
//            case _ =>
//        }
//    }
    override def onDisconnect(msg: String): Unit = ???

    override def disconnect(msg: String): Unit = ???
}


