import org.scalatest.FunSuite
import Turtles._
import TurtleLenses1._

class StandaloneTests extends FunSuite {

  val defaultTurtle = Turtle()

  test("default") {
    expect(Turtle(Point(0.0,0.0),Color(0,0,0),0.0,false)) {
      defaultTurtle
    }
  }

  test("forward 1") {
    expect(Turtle(Point(1.0,0.0),Color(0,0,0),0.0,false)) {
      forward(defaultTurtle, 1)
    }
  }

  test("fd 1 lt 90 fd 2") {
    val expected =
      Turtle(Point(1.0000000000000002, 2.0),
             Color(0,0,0),
             1.5707963267948966, false)
    expect(expected) {
      val t0 = forward(defaultTurtle, 1)
      val t1 = right(t0, math.toRadians(90))
      val t2 = forward(t1, 2)
      t2
    }
  }

}
