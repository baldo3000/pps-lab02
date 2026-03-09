package it.unibo.pps.u02.task3

import scala.annotation.tailrec

@main
def es6(): Unit =
  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  println(power(2, 3)) // 8.0
  println(power(5, 2)) // 25.0

  def powerTail(base: Double, exponent: Int): Double =
    @tailrec
    def _power(base: Double, exponent: Int, accumulator: Double): Double = exponent match
      case 0 => accumulator
      case _ => _power(base, exponent - 1, accumulator * base)

    _power(base, exponent, 1)

  println(powerTail(2, 3)) // 8.0
  println(powerTail(5, 2)) // 25.0