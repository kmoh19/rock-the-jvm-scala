package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction) // you can call a function without parenthesis

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))
  //WHEN YOU NEED LOOP USE RECURSION

  def aFunctionWithSideeffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int, b: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n - 1)
  }

  def aGreeting(aName: String, Age: Int): String = {
    "Hi my name is " + aName + " and I am " + Age + " years old."
  }
  println(aGreeting("Andy",8))

  def aFactorial(aNumber: Int): Long = {
    if (aNumber <=0) 1 else aNumber * aFactorial(aNumber-1)
  }
  println(aFactorial(5))

  def fibonacci(n:Int): Int=
    if (n<=2) 1
    else fibonacci(n-1)+fibonacci(n-2) //how?

  println(fibonacci(8))

  def isPrime(n:Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(2003))

}
