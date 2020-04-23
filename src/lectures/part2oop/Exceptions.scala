package lectures.part2oop

object Exceptions extends App {

  // val x: String = null
  //println(x.length)

  //1. throwing

  //val aWeirdValue = throw new NullPointerException

  //throwable classes extend the Throwable class
  //Exeptions and Error are the major Throwable types ...exceptions = program.....errors=system eg stack overflow


  //2. and catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("no int here")
    else 42

  val potentialFail = try {
    //code that might throw
    getInt(true)

  } catch {
    case e: RuntimeException => 43
  } finally { //will run regardless
    //optional...it does not influence the return type of exception...only used for side effects eg...logging
    println("finally")
  }
  println(potentialFail)

  //3. defining your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //throw exception

  // val array = Array.ofDim(Int.MaxValue)// out of memory error(OOM)

  //def infinite: Int = 1 + infinite
  //val noLimit = infinite //stack overflow error

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by zero")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      result //we can't jut compare result to int maxvalue as we can never reach Int max value "in the real sense"
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    }

    def divide(x: Int, y: Int)={
      if (y==0) throw new MathCalculationException
      else x/y
    }




  }
 // println(PocketCalculator.add(Int.MaxValue, 10)) // negative value returned means you have surpassed int.maxvalue
  println(PocketCalculator.divide(2,0))
}