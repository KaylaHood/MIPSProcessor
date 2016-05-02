

/**
 * @author khood
 */
class PC(var bits : Int,val input : Wire,val output : Wire) extends Component{
  input.destinations += this
  def startStep() {
    output.bits = bits
  }
  def wireChanged(wire : Wire) {
    bits = input.bits
  }
}