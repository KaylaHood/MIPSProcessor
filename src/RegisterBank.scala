
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import java.io.DataOutputStream 
import collection.mutable

class RegisterBank(val regsArray : mutable.Buffer[Int]) extends Component{
  //only forward for reads
  def wireChanged(wire : Wire) = {
    
  }
  def finalizeMemory(fname : String, fname2 : String, memory : Array[Int], regs : Array[Int]) = {
    fname.dropRight(3)
    fname++".out"
    fname2.dropRight(3)
    fname2++".out"
    val dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fname)))
    for (i <- memory) dos.writeInt(i)
    dos.close()
    val dos2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fname2)))
    for (i <- regs) dos2.writeInt(i)
    dos2.close()
  }
  def initRegisters(regVals : mutable.Buffer[Int]) {
    regVals.foreach(x => regsArray += x)
  }
}