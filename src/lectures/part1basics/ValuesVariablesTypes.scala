package lectures.part1basics

object ValuesVariablesTypes extends App{
  //val x: Int = 42
  val x = 42
  println(x)

  //Vals are immutable
  // compiler can infer types

  val aString: String = "Hello"
  val anotherString: String = "goodbye"
  val aBoolean: Boolean = false
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 53443423211L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables

  var aVariable = 5 // vars are side effects..programs without side effects are easier to read thus functional programming tries to a void them
}
