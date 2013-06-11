// Rillit can make either Shapeless or Scalaz lenses.
// here we are making Shapeless lenses.

import org.scalatest.FunSuite
import Turtles._
import RillitTurtleLenses._
import rillit.Lenser

class RillitTests extends FunSuite {

  val defaultTurtle = Turtle()

  test("default") {
    expectResult(Turtle(Point(0.0,0.0),Color(0,0,0),0.0,false)) {
      defaultTurtle
    }
  }

  test("fd 1") {
    expectResult(Turtle(Point(1.0,0.0),Color(0,0,0),0.0,false)) {
      forward(defaultTurtle, 1)
    }
  }

  test("fd 1 lt 90 fd 2") {
    val expected =
      Turtle(Point(1.0000000000000002, 2.0),
             Color(0,0,0),
             1.5707963267948966, false)
    expectResult(expected) {
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
    expectResult(expected) {
      val t0 = increment(defaultTurtle, Lenser[Turtle].position.x)
      val t1 = increment(t0, Lenser[Turtle].position.y)
      val t2 = increment(t1, Lenser[Turtle].position.x)
      t2
    }
  }

}
