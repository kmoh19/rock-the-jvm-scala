package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  //@tailrec //throws error recursive call not in tail position
  def aFactorial(aNumber: Int): Long =
    if (aNumber <=1) 1
    else {
      println("computing factorial of "+ aNumber + " - I first need factorial of "+ (aNumber-1))
      val result=aNumber * aFactorial(aNumber-1)
      println("computed factorial of "+ aNumber)

      result
    }
  println(aFactorial(10))
  //println(aFactorial(5000))//leads to stack overflow

  def anotherFactorial(n:Int): BigInt ={
    @tailrec
    def factHelper(x:Int, accumulator: BigInt): BigInt =
      if (x<=1)accumulator
      else factHelper(x-1,x*accumulator)//will work with big number as it is the last expression of its code path thus ensuring the preservation of its stackframe for recursive calls this is called TAIL Recursion
    //it has nothing to do with being written as an auxillary function

    factHelper(n,1)
  }

  println(anotherFactorial(5000))
  /* anotherFactorial(10) = factHelper(10,1)
   */
  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n<=0) accumulator
    else concatenateTailrec(aString,n-1,aString+accumulator)
  println(concatenateTailrec("hello",3,""))


  def isPrime(n:Int):Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t<=1) true
      else isPrimeTailrec(t-1,n % t !=0 && isStillPrime)
    isPrimeTailrec(n/2,true)

  }
  println(isPrime(2003))
  println(isPrime(629))
}
