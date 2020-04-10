package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App{
  class Person(val name: String, favoriteMovie: String){
    def likes(movie:String):Boolean =movie==favoriteMovie
    def hangOutWith(person:Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person:Person): String = s"${this.name} is hanging out with ${person.name}" //permissive method naming in scala
    def unary_! :String=s"$name,WTF!"
    def isAlive: Boolean =true
    def apply(): String = s"Hi my name is $name and i like $favoriteMovie"
  }
  val mary = new Person("mary","inception")
  println(mary.likes("inception"))
  println(mary likes "inception")//infix notation works with methods with just one argument (aka syntactic sugar)

  //"operators" in scala
  val tom=new Person("Tom", "Fight Club")
  println(mary hangOutWith(tom))
  println(mary +(tom))//permisive method being called

  println(1+2)
  println(1.+(2))
  //ALL OPERATORS ARE METHODS
  //Akka actors have !?

  //prefix notation syntactic sugar
  val x = -1 //equivalent to 1.unary_-
  val y = 1.unary_-
  //unary prefix only works with - + ~!

  println(!mary)//see definition of operator above
  println(mary.unary_!)

  //we also have postfix notations too but there are not popular...can only be used with methods that do not take any arguments
  println(mary isAlive)//postfix notation...now deprecated
  println(mary.isAlive)// we just use the dot notation vs the post fix

  //apply
  println(mary())//apply notation
  println(mary.apply())
}
