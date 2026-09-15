package edu.luc.cs.laufer.cs371.shapes

object scale:
  def apply(s: Shape, factor: Int): Shape = s match
    case Rectangle(w, h) => Rectangle(w * factor, h * factor)
    case Ellipse(w, h) => Ellipse(w * factor, h * factor)
    case Location(x, y, shape) => Location(x * factor, y * factor, apply(shape, factor))
    case Group(shapes*) => Group(shapes.map(apply(_, factor))*)

end scale