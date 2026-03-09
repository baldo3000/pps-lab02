package task2

@main
def es4(): Unit =
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int) = x <= y && y == z

  def p4(x: Int, y: Int, z: Int) = x <= y && y == z

  println(p1(1)(7)(7))
  println(p2(1, 7, 7))
  println(p1(14)(7)(7))
  println(p2(1, 7, 8))
