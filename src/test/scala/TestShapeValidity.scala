package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows

class TestShapeValidity:

  @Test
  def testRectangleRejectsNonPositiveWidth(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Rectangle(0, 10))

  @Test
  def testRectangleRejectsNonPositiveHeight(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Rectangle(10, -5))

  @Test
  def testEllipseRejectsNonPositiveWidth(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Ellipse(0, 10))

  @Test
  def testEllipseRejectsNonPositiveHeight(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Ellipse(10, -5))

  @Test
  def testGroupRejectsEmpty(): Unit =
    assertThrows(classOf[IllegalArgumentException], () => Group())

end TestShapeValidity