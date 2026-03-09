package it.unibo.pps.u02

import scala.annotation.tailrec

@main
def es8(): Unit =
  def reverseNumber(n: Int): Int =
    @tailrec
    def _reverse(remaining: Int, accumulator: Int): Int = remaining match
      case 0 => accumulator
      case _ => _reverse(remaining / 10, accumulator * 10 + remaining % 10)

    _reverse(n, 0)

  println(reverseNumber(12345)) // 54321
