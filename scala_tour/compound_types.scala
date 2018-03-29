/**
 * compound types: type of an object is a subtype of several other types.
 * intersections of object types
 */
trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}
trait Resetable {
  def reset: Unit
}
def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {

}

object CompoundTypes extends App {
}
