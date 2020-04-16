package lectures.part2oop

object AbstractDataTypes extends App{

  //abstract describes classes and members that are undefined to be defined by sub-classes i.e extended

  abstract class Animal{
    val creatureType:String
    val isAlive = false //non-abstract member...abstract cases can have non-abstract member
    def eat: Unit


  }
  class Dog extends Animal{
    override val creatureType: String = "Canine"//override keyword not necessary see below
    def eat: Unit = println("crunch,crunch")
  }

  //traits

  trait Canivore{
    def eat(animal: Animal): Unit
    val preferredMeal = "fresh meat" // traits also have non-abstract members
  }

  trait ColdBlooded{
    val ColdBlooded =true

  }
  class Crocodile extends Animal with Canivore with ColdBlooded {
    override val isAlive: Boolean = true //using override key word as isAlive is non-abstract member
    val creatureType: String="croc"
    def eat: Unit = println("crunch,crunch")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I' eating a ${animal.creatureType}")
  }

  val dog =new Dog
  val croc = new Crocodile
  croc.eat(dog)
  croc.eat

  //Traits vs Abstract classes
  //1- Traits have no constructors
  //2- multiple traits maybe inherited by th same class but not multiple classes ...
  //in scala you achieve multiple inheritance by using traits
  //3- Traits= behaviour,abstract class=type
}
