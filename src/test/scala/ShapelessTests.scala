import org.scalatest.FunSuite
import Turtles._
import ShapelessTurtleLenses._

class ShapelessTests extends FunSuite {

  val defaultTurtle = Turtle()

  test("default") {
    assertResult(Turtle(Point(0.0,0.0),Color(0,0,0),0.0,false)) {
      defaultTurtle
    }
  }

  test("fd 1") {
    assertResult(Turtle(Point(1.0,0.0),Color(0,0,0),0.0,false)) {
      forward(defaultTurtle, 1)
    }
  }

  test("fd 1 lt 90 fd 2") {
    val expected =
      Turtle(Point(1.0000000000000002, 2.0),
             Color(0,0,0),
             1.5707963267948966, false)
    assertResult(expected) {
      val t0 = forward(defaultTurtle, 1)
      val t1 = right(t0, math.toRadians(90))
      val t2 = forward(t1, 2)
      t2
    }
  }

  test("increment") {
    val expected =
      Turtle(Point(2.0, 1.0),
             Color(0,0,0),
             0.0, false)
    assertResult(expected) {
      val t0 = increment(defaultTurtle, TurtleX)
      val t1 = increment(t0, TurtleY)
      val t2 = increment(t1, TurtleX)
      t2
    }
  }

}
