package edu.luc.cs.laufer.cs371.shapes

sealed trait Shape derives CanEqual

case class Rectangle(width: Int, height: Int) extends Shape:
  require(width > 0 && height > 0, "Rectangle requires positive width and height")

case class Ellipse(width: Int, height: Int) extends Shape:
  require(width > 0 && height > 0, "Ellipse requires positive width and height")

case class Location(x: Int, y: Int, shape: Shape) extends Shape

case class Group(shapes: Shape*) extends Shape:
  require(shapes.nonEmpty, "Group requires at least one shape")