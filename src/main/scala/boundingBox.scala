package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

// import Shape.*

import com.typesafe.scalalogging.Logger

object boundingBox:
  val logger = Logger("boundingBox")

  def apply(s: Shape): Location =
    logger.debug(s"computing boundingBox for $s")
    val result = s match
      case Rectangle(w, h) =>
        Location(0, 0, Rectangle(w, h))

      case Ellipse(rx, ry) =>
        Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))

      case Location(x, y, shape) =>
        val Location(u, v, rect) = apply(shape): @unchecked
        Location(x + u, y + v, rect)

      case Group(shapes*) =>
        val corners = shapes.map { sh =>
          val Location(x, y, Rectangle(w, h)) = apply(sh): @unchecked
          (x, y, x + w, y + h)
        }
        val minX = corners.map(_._1).min
        val minY = corners.map(_._2).min
        val maxX = corners.map(_._3).max
        val maxY = corners.map(_._4).max
        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
    logger.debug(s"result: $result")
    result

end boundingBox