
import java.io.FileInputStream
import java.io.BufferedInputStream
import java.io.DataInputStream 
import collection.mutable

/**
 * @author khood
 */

case class InputException(message : String) extends Exception(message)

object Main {
  
  val pcIn = new Wire(32,0)
  val pcOut = new Wire(32,0)
  
  val pc = new PC(0,pcIn,pcOut)
  val regBank = new RegisterBank(mutable.Buffer[Int]())
  
  def main(args:Array[String]) ={
    if(!(args(0).endsWith(".in")) || !(args(1).endsWith(".in"))) {
      throw InputException("Oops! One or both input filenames did not end with \".in\"")
    }
    val dis = new DataInputStream(new BufferedInputStream(new FileInputStream(args(0))))
    val mem1 = mutable.Buffer.fill(0x1000)(dis.readInt)
    val mem2 = mutable.Buffer.fill((1 << 14) - 0x1000)(dis.readInt)
    dis.close
    val dis2 = new DataInputStream(new BufferedInputStream(new FileInputStream(args(1))))
    val regs = mutable.Buffer.fill(32)(dis2.readInt)
    dis2.close
    
    val InstructionMem = new Memory(mem1)
    val DataMem = new Memory(mem2)
    regBank.initRegisters(regs)
    
    while(pc.bits < 0x4000) {
      pc.startStep()
    }
    
  }
}