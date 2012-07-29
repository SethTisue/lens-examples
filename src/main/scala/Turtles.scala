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

}
