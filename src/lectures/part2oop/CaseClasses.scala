package lectures.part2oop

object CaseClasses extends App{
  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age:Int)
  //1. case classes promotes parameters to fields
  val jim = new Person("Jim", 34)

  println(jim.name)

  //2. sensible toString representation

  println(jim.toString) // returns Person(Jim,34)
  println(jim)
//3. equals and hashCode are implemented out of the box

  val jim2 = new Person("Jim",34)
  println(jim==jim2)// returns true as equal is implemented by default

  // 4. case classes have copy method
  val jim3=jim.copy()
  val jim4=jim.copy(age=45)

  //5. case classe have companion objects
  val thePerson = Person
  val mary=Person("Mary",23) //companion objects apply method does the same thing as a constructor

  //6. case classes are serializable ...can be sent over the network
  //Akka

  //7. case classes have extractor patterns = case classes can be used in pattern matching

  case object UnitedKingdom{

    def name: String = "The UK of GB and NI"
  }

}
