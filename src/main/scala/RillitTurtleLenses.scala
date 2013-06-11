object RillitTurtleLenses {

  import Turtles._
  import rillit.Lenser, shapeless.Lens

  def forward(t: Turtle, dist: Double) =
    Lenser[Turtle].position.y.modify(
      Lenser[Turtle].position.x.modify(t)(
        _ + dist * math.cos(t.heading)))(
          _ + dist * math.sin(t.heading))

  def right(t: Turtle, delta: Double) =
    Lenser[Turtle].heading.modify(t)(_ + delta)

  def increment[T](t: T, lens: Lens[T, Double]) =
    lens.modify(t)(_ + 1)

}

/*
Or if you like, instead of using Lenser inline:
  val TurtleX:       Lens[Turtle, Double] = Lenser[Turtle].position.x
  val TurtleY:       Lens[Turtle, Double] = Lenser[Turtle].position.y
  val TurtleHeading: Lens[Turtle, Double] = Lenser[Turtle].heading
then e.g.:
  increment(t, TurtleX)
*/
