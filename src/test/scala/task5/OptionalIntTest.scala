package task5

import org.junit.*
import org.junit.Assert.*
import task5.Optionals.*
import task5.Optionals.OptionalInt.*

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

  @Test
  def testFilterShouldReturnEmptyWhenEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(empty, filter(empty)(_ > 2))

  @Test
  def testFilterShouldReturnOptionalWhenConditionIsSatisfiedAndNonEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(5)
    assertEquals(nonEmpty, filter(nonEmpty)(_ > 2))

  @Test
  def testFilterShouldReturnEmptyWhenConditionIsNotSatisfiedAndNonEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(5)
    val expected = OptionalInt.Empty()
    assertEquals(expected, filter(nonEmpty)(_ > 8))