object ShapelessTurtleLenses {

  import Turtles._

  import shapeless._
  import Lens._
  import Nat._

  implicit val pointIso =
    HListIso(Point.apply _, Point.unapply _)
  implicit val colorIso =
    HListIso(Color.apply _, Color.unapply _)
  implicit val turtleIso =
    HListIso(Turtle.apply _, Turtle.unapply _)

  val TurtleX = Lens[Turtle] >> _0 >> _0
  val TurtleY = Lens[Turtle] >> _0 >> _1
  val TurtleHeading = Lens[Turtle] >> _2

  def forward(t: Turtle, dist: Double) =
    TurtleY.modify(
      TurtleX.modify(t)(
        _ + dist * math.cos(t.heading)))(
          _ + dist * math.sin(t.heading))

  def right(t: Turtle, delta: Double) =
    TurtleHeading.modify(t)(_ + delta)

}
