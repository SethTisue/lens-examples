// At Scala eXchange in 2013, Simon Peyton-Jones gave this talk on lenses:
//   https://skillsmatter.com/skillscasts/4556-simon-peyton-jones
//
// He showed an alternate encoding of lenses, due to Twan van Laarhoven,
// where a lens is represented not as a record of two ordinary functions,
// but as a single polymorphic function.
//
// Although it was a Scala conference, all the code in the talk was in Haskell.
// Here is my attempt to port it to Scala.  (Peeking at the Scalaz source code
// a few times helped a lot.)
//
// In this file I follow Peyton-Jones in my choice of names for type parameters.
// ("S" is some structure, "A" is the type of some location in that structure.)
//
// The material in this file isn't covered in my own talk.

import language.higherKinds

object VanLaarhovenLenses {

  trait Functor[F[_]] {
    def fmap[A, B](fa: F[A], f: A => B): F[B]
  }

  case class Identity[A](x: A)
  implicit object IdentityFunctor extends Functor[Identity] {
    def fmap[A, B](fa: Identity[A], f: A => B) =
      Identity(f(fa.x))
  }

  case class Const[A, B](x: A)
  implicit def constFunctor[BB] = new Functor[({type λ[α] = Const[BB, α]})#λ] {
    def fmap[A, B](fa: Const[BB, A], f: A => B) =
      Const(fa.x)
  }

  trait Lens[S, A] {
    def apply[F[_] : Functor](f: A => F[A]): (S => F[S])
    def get(s: S): A =
      apply[({type λ[α] = Const[A, α]})#λ](Const(_)).apply(s).x
    def set(s: S, a: A): S =
      apply(_ => Identity(a)).apply(s).x
  }

  def compose[S1, S2, A](lens1: Lens[S1, S2], lens2: Lens[S2, A]) = new Lens[S1, A] {
    def apply[F[_] : Functor](f: A => F[A]) =
      lens1(lens2(f))
  }

  def modify[S, A](lens: Lens[S, A], obj: S)(fn: A => A) =
    lens.set(obj, fn(lens.get(obj)))

}

object VanLaarhovenTurtleLenses {

  import Turtles._, VanLaarhovenLenses._

  val TurtlePosition = new Lens[Turtle, Point] {
    def apply[F[_] : Functor](f: Point => F[Point]) =
      (turtle: Turtle) =>
        implicitly[Functor[F]].fmap(
          f(turtle.position),
          (position: Point) => turtle.copy(position = position))
  }
  val TurtleHeading = new Lens[Turtle, Double] {
    def apply[F[_] : Functor](f: Double => F[Double]) =
      (turtle: Turtle) =>
        implicitly[Functor[F]].fmap(
          f(turtle.heading),
          (heading: Double) => turtle.copy(heading = heading))
  }

  val PointX = new Lens[Point, Double] {
    def apply[F[_] : Functor](f: Double => F[Double]) =
      (point: Point) =>
        implicitly[Functor[F]].fmap(
          f(point.x),
          (x: Double) => point.copy(x = x))
  }
  val PointY = new Lens[Point, Double] {
    def apply[F[_] : Functor](f: Double => F[Double]) =
      (point: Point) =>
        implicitly[Functor[F]].fmap(
          f(point.y),
          (y: Double) => point.copy(y = y))
  }

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

  def increment[T](t: T, lens: Lens[T, Double]) =
    modify(lens, t)(_ + 1)

}
