package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit={
    println("by value" +x)
    println("by value " +x)
  }

  def calledByName(x: => Long): Unit ={
    println("by name" +x)
    println("by name" +x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int =1+infinite()//intended to crash
  def printFirst(x: Int, y: => Int)= println(x)
  //printFirst(infinite(),34) crashes
  printFirst(34,infinite()) //it does not crash because by name calls do not execute until needed...lazy evaluation


}
