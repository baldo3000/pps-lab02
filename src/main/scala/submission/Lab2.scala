package submission

import scala.annotation.tailrec

object Lab2 extends App:
  // Task 2 Es3
  val positiveLambda = (x: Int) => x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  def positiveMethod(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  val negLambda = (predicate: String => Boolean) => (string: String) => !predicate(string)

  def negMethod(predicate: String => Boolean): String => Boolean =
    string => !predicate(string)

  // Task 2 Es4
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int) = x <= y && y == z

  def p4(x: Int, y: Int, z: Int) = x <= y && y == z

  // Task 2 Es5
  def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

  // Task 3 Es6
  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  def powerTailRecursion(base: Double, exponent: Int): Double =
    @tailrec
    def _power(base: Double, exponent: Int, accumulator: Double): Double = exponent match
      case 0 => accumulator
      case _ => _power(base, exponent - 1, accumulator * base)

    _power(base, exponent, 1)

  // Task 3 Es7
  def reverseNumber(n: Int): Int =
    @tailrec
    def _reverse(remaining: Int, accumulator: Int): Int = remaining match
      case 0 => accumulator
      case _ => _reverse(remaining / 10, accumulator * 10 + remaining % 10)

    _reverse(n, 0)

  // Task 4 Es8
  enum Expr:
    case Literal(n: Int)
    case Add(first: Expr, second: Expr)
    case Multiply(first: Expr, second: Expr)

  object Expr:
    def evaluate(expr: Expr): Int = expr match
      case Literal(n) => n
      case Add(first, second) => evaluate(first) + evaluate(second)
      case Multiply(first, second) => evaluate(first) * evaluate(second)

    def show(expr: Expr): String = expr match
      case Literal(n) => n.toString
      case Add(first, second) => s"(${show(first)} + ${show(second)})"
      case Multiply(first, second) => s"(${show(first)} * ${show(second)})"

  // Task 5 Es9
  // type "public" definition, exposing structure
  enum OptionalInt:
    case Just(value: Int)
    case Empty()

  // operations (/algorithms)
  object OptionalInt:

    def isEmpty(opt: OptionalInt): Boolean = opt match
      case Empty() => true
      case _ => false

    def orElse(opt: OptionalInt, orElse: Int): Int = opt match
      case Just(a) => a
      case _ => orElse

    def mapInt(opt: OptionalInt)(mapping: Int => Int): OptionalInt = opt match
      case Just(a) => Just(mapping(a))
      case Empty() => opt

    def filter(opt: OptionalInt)(filterFunction: Int => Boolean): OptionalInt = opt match
      case Just(a) if filterFunction(a) => opt
      case _ => Empty()