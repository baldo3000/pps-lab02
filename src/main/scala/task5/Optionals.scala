package task5

// overall module
object Optionals:

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

@main def tryOptionals(): Unit =
  import Optionals.*
  import OptionalInt.* // to directly access algorithms

  val s1: OptionalInt = Just(1)
  val s2: OptionalInt = Empty()

  println(s1) // Some(1)
  println(isEmpty(s1)) // false
  println(orElse(s1, 0)) // 1
  println(orElse(s2, 0)) // 0
