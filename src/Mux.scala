

/**
 * @author khood
 */
class Mux(control : Wire, input : Wire, input2 : Wire, output : Wire) extends Component{
  input.destinations += this
  input2.destinations += this
  control.destinations += this
  def wireChanged(wire : Wire) = {
    if(control.bits == 0) {
      output.bits = input.bits
    }
    else {
      output.bits = input2.bits
    }
  }
}