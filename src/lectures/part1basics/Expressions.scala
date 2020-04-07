package lectures.part1basics

object Expressions extends App{

  val x = 1+2 //expression

  println(x)
  println(2+3*4)

  //+ - * / & | ^<< >> >>>

  println(1==x)
  // == != > >= < <=
  println(!(1==x))
  // ! && ||

  var aVariable = 2
  aVariable += 3  // also works with -= *= /= .....these are all side effects as they change the variable
  println(aVariable)

  // Instructions (Do) Vs Expressions (VALUE)
  //Instructions are executed and expressions are evaluated
  // side effects are expressions returning units


 // If expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3 // value is returned hence an expression
  println(aConditionValue)
  println(if(aCondition) 5 else 3)

  //everything is scala is an expression!!

  val aWeirdValue = (aVariable = 3) // Unit===void
  println(aWeirdValue)

  //Code blocks

  val aCodeBlock = {
    val y = 2
    val z =y + 1
    if (z>2) "hello" else "goodbye"
  }

  println(aCodeBlock)
}
