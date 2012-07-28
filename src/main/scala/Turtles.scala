import shapeless._
import Lens._
import Nat._

object Turtles {

  case class Point(
    x: Double = 0.0,
    y: Double = 0.0
  )

  case class Color(
    r: Int = 0,
    g: Int = 0,
    b: Int = 0
  )

  case class Turtle(
    position: Point = Point(),
    color: Color = Color(),
    heading: Double = 0.0,
    penDown: Boolean = false
  )

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

}
