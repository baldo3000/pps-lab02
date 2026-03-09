package task2

val positiveLambda = (x: Int) => x match
  case n if n >= 0 => "positive"
  case _ => "negative"

def positiveMethod(x: Int): String = x match
  case n if n >= 0 => "positive"
  case _ => "negative"

val negLambda = (predicate: String => Boolean) => (string: String) => !predicate(string)

def negMethod(predicate: String => Boolean): String => Boolean =
  string => !predicate(string)

@main
def mainEs3(): Unit =
  println(positiveLambda(1))
  println(positiveMethod(-1))

  val empty: String => Boolean = _ == ""
  val notEmpty = negLambda(empty)
  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))
