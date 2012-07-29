object StandaloneTurtleLenses {

  import Turtles._
  import Lenses._

  val TurtlePosition =
    Lens[Turtle, Point](
      _.position,
      (t, p) => t.copy(position = p))
  val TurtleHeading =
    Lens[Turtle, Double](
      _.heading,
      (t, h) => t.copy(heading = h))

  val PointX =
    Lens[Point, Double](
      _.x,
     (p, x) => p.copy(x = x))
  val PointY =
    Lens[Point, Double](
      _.y,
     (p, y) => p.copy(y = y))

  val TurtleX =
    compose(TurtlePosition, PointX)
  val TurtleY =
    compose(TurtlePosition, PointY)

  def forward(t: Turtle, dist: Double) =
    modify(TurtleY,
      modify(TurtleX, t)(
        _ + dist * math.cos(t.heading)))(
          _ + dist * math.sin(t.heading))

  def right(t: Turtle, delta: Double) =
    modify(TurtleHeading, t)(_ + delta)

  def increment(t: Turtle, lens: Lens[Turtle, Double]) =
    modify(lens, t)(_ + 1)

}
