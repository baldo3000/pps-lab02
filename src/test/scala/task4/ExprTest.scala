package task4

import org.junit.*
import org.junit.Assert.*
import task4.Expr.*

class ExprTest:
  // NOTE: since we are doing FP, I'm not considering these values as fields, so they are public and their names are in camel-case
  val firstValue = 2
  val secondValue = 3
  val firstLiteral = Literal(firstValue)
  val secondLiteral = Literal(secondValue)

  @Test def testLiteralEvaluation(): Unit =
    firstLiteral match
      case Literal(n) => assertEquals(firstValue, evaluate(firstLiteral))
      case _ => fail()

  @Test def testAddEvaluation(): Unit =
    val expr = Add(firstLiteral, secondLiteral)
    expr match
      case Add(first, second) => assertEquals(firstValue + secondValue, evaluate(expr))
      case _ => fail()

  @Test def testMultiplyEvaluation(): Unit =
    val expr = Multiply(firstLiteral, secondLiteral)
    expr match
      case Multiply(first, second) => assertEquals(firstValue * secondValue, evaluate(expr))
      case _ => fail()