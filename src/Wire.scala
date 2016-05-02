
import collection.mutable

class Wire (val numBits : Int, private var _bits : Int) {
  val destinations = mutable.Buffer[Component]()
  def forward() = {
    destinations.foreach(x => x.wireChanged(this))
  }
  def bits = _bits
  def bits_=(newbits : Int) {
    _bits = newbits
    forward()
  }
}