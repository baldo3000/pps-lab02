package task4

enum Expr:
  case Literal(n: Int)
  case Add(first: Expr, second: Expr)
  case Multiply(first: Expr, second: Expr)

object Expr:
  def evaluate(expr: Expr): Int = expr match
    case Literal(n) => n
    case Add(first, second) => evaluate(first) + evaluate(second)
    case Multiply(first, second) => evaluate(first) * evaluate(second)