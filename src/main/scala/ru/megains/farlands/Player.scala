package ru.megains.farlands


//
//class Player(val position: Vector2) extends Actor{
//
//    object State extends Enumeration {
//        type State = Value
//        val NONE, WALKING, DEAD = Value
//    }
//
//    object Direction extends Enumeration {
//        type Direction = Value
//        val LEFT, RIGHT, UP, DOWN, NONE = Value
//    }
//
//    val facingLeft = true
////    val bounds = new Rectangle()
////    bounds.width = Player.SIZE
////    bounds.height = Player.SIZE
//
//    //скорость движения
//    //используется для вычисления движения
//    val velocity = new Vector2
//    //прямоугольник, в который вписан игрок
//    //будет использоваться в будущем для нахождения коллизий (столкновение со стенкой и т.д.
//
//    //текущее состояние
//    val state: State.Value = State.NONE
//
//
//
//   // setHeight(Player.SIZE * world.ppuY)
//   // setWidth(Player.SIZE * world.ppuX)
//  //  setX(position.x * world.ppuX)
//   // setY(position.y * world.ppuY)
//    addListener(new InputListener() {
//      //  override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = { true}
//        override def touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Unit = {}
//    })
//
//
//    def update(delta: Float): Unit = {
//        position.add(velocity.cpy.scl(delta))
//      //  setX(position.x * world.ppuX)
//       // setY(position.y * world.ppuY)
//    }
//
//
//
//   override def draw(batch: Batch, parentAlfa: Float): Unit = {
//      //  if (this == world.selectedActor) batch.setColor(0.5f, 0.5f, 0.5f, 0.5f)
//      //  batch.draw(world.textureRegions.get("player"), getX, getY, getWidth, getHeight)
//        batch.setColor(1, 1, 1, 1)
//    }
//
//    override def hit(x: Float, y: Float, touchable: Boolean): Actor = {
//        if (x > 0 && x < getWidth && y > 0 && y < getHeight) this
//        else null
//    }
//
//    def ChangeNavigation(x: Float, y: Float): Unit = {
//        resetWay()
//        if (y > getY) upPressed()
//        if (y < getY) downPressed()
//        if (x < getX) leftPressed()
//      //  if (x > (position.x + Player.SIZE) * world.ppuX) rightPressed()
//        processInput()
//    }
//
//    def resetWay(): Unit = {
//        rightReleased()
//        leftReleased()
//        downReleased()
//        upReleased()
//        velocity.x = 0
//        velocity.y = 0
//    }
//
//    private def processInput(): Unit = {
//        if (direction.get(Keys.LEFT)) velocity.x = -Player.SPEED
//        if (direction.get(Keys.RIGHT)) velocity.x = Player.SPEED
//        if (direction.get(Keys.UP)) velocity.y = Player.SPEED
//        if (direction.get(Keys.DOWN)) velocity.y = -Player.SPEED
//        if ((direction.get(Keys.LEFT) && direction.get(Keys.RIGHT)) || (!direction.get(Keys.LEFT) && (!direction.get(Keys.RIGHT)))) velocity.x = 0
//        if ((direction.get(Keys.UP) && direction.get(Keys.DOWN)) || (!direction.get(Keys.UP) && (!direction.get(Keys.DOWN)))) velocity.y = 0
//    }
//
//    object Keys extends Enumeration {
//        type Keys = Value
//        val LEFT, RIGHT, UP, DOWN = Value
//    }
//
//   val direction: util.Map[Keys.Value, Boolean] = new util.HashMap[Keys.Value, Boolean]
//
//        direction.put(Keys.LEFT, false)
//        direction.put(Keys.RIGHT, false)
//        direction.put(Keys.UP, false)
//        direction.put(Keys.DOWN, false)
//
//
//    def leftPressed(): Unit = {
//        direction.get(direction.put(Keys.LEFT, true))
//    }
//
//    def rightPressed(): Unit = {
//        direction.get(direction.put(Keys.RIGHT, true))
//    }
//
//    def upPressed(): Unit = {
//        direction.get(direction.put(Keys.UP, true))
//    }
//
//    def downPressed(): Unit = {
//        direction.get(direction.put(Keys.DOWN, true))
//    }
//
//    def leftReleased(): Unit = {
//        direction.get(direction.put(Keys.LEFT, false))
//    }
//
//    def rightReleased(): Unit = {
//        direction.get(direction.put(Keys.RIGHT, false))
//    }
//
//    def upReleased(): Unit = {
//        direction.get(direction.put(Keys.UP, false))
//    }
//
//    def downReleased(): Unit = {
//        direction.get(direction.put(Keys.DOWN, false))
//    }
//}
//object Player{
//    val SPEED = 2f
//    //размер
//    val SIZE = 0.7f
//}