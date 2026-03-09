package task5

import org.junit.*
import org.junit.Assert.*
import task5.Optionals.*
import task5.Optionals.OptionalInt.mapInt

class OptionalIntTest:
  @Test
  def testEmptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test
  def testNonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test
  def testOrElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test
  def testOrElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  @Test
  def testMapIntShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(empty, mapInt(empty)(_ + 1))

  @Test
  def testMapIntShouldReturnMappedOptionalWhenNonEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    val expected = OptionalInt.Just(5)
    assertEquals(expected, mapInt(nonEmpty)(_ + 5))