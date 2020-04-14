package lectures.part2oop
import scala.language.postfixOps //explicit import as now deprecated

object MethodNotations extends App{
  class Person(val name: String, favoriteMovie: String, val age:Int=0){
    def likes(movie:String):Boolean =movie==favoriteMovie
    def hangOutWith(person:Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person:Person): String = s"${this.name} is hanging out with ${person.name}" //permissive method naming in scala
    def +(nickname:String): Person = new Person(s"$name ($nickname)", favoriteMovie)//operator overloading
    def unary_! :String=s"$name,WTF!" //note space between unary function name and colon is very important
    def unary_+ :Person = new Person(name, favoriteMovie,age+1)
    def isAlive: Boolean =true
    def apply(): String = s"Hi my name is $name and i like $favoriteMovie"
    def apply(n:Int):String=s"$name watched $favoriteMovie $n times"

    def learns(thing:String) = s"$name is learning $thing"
    def learnsScala =this learns "Scala" //infix :)
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
  println((+mary).age)

  //we also have postfix notations too but there are not popular...can only be used with methods that do not take any arguments
  println(mary isAlive)//postfix notation...now deprecated
  println(mary.isAlive)// we just use the dot notation vs the post fix
  println(mary learnsScala)

  //apply
  println(mary())//apply notation
  println(mary.apply())
  println((mary + "the rockstar")())
  println(mary(10))

}
