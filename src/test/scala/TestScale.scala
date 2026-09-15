package edu.luc.cs.laufer.cs371.shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import TestFixtures.*

class TestScale:

  @Test
  def testSimpleRectangle(): Unit =
    assertEquals(Rectangle(160, 240), scale(simpleRectangle, 2))

  @Test
  def testSimpleEllipse(): Unit =
    assertEquals(Ellipse(150, 90), scale(simpleEllipse, 3))

  @Test
  def testSimpleLocation(): Unit =
    assertEquals(Location(140, 60, Rectangle(160, 240)), scale(simpleLocation, 2))

  @Test
  def testBasicGroup(): Unit =
    assertEquals(Group(Ellipse(100, 60), Rectangle(40, 80)), scale(basicGroup, 2))

  @Test
  def testSimpleGroup(): Unit =
    assertEquals(
      Group(
        Location(400, 200, Ellipse(100, 60)),
        Location(800, 600, Rectangle(200, 100))
      ),
      scale(simpleGroup, 2)
    )

  @Test
  def testComplexGroup(): Unit =
    assertEquals(
      Location(100, 200,
        Group(
          Ellipse(40, 80),
          Location(300, 100,
            Group(
              Rectangle(100, 60),
              Rectangle(600, 120),
              Location(200, 400, Ellipse(100, 60))
            )
          ),
          Rectangle(200, 400)
        )
      ),
      scale(complexGroup, 2)
    )

end TestScale