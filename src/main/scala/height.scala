package edu.luc.cs.laufer.cs371.shapes

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, shape) => 1 + apply(shape)
    case Group(shapes*) => 1 + shapes.map(apply).max

end height