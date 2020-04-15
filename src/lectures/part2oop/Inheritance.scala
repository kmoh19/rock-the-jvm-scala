package lectures.part2oop

object Inheritance extends App{

  sealed class Animal{

    val nature="wild"
    def eat = println("nomnomnom")
    private def reproduce: Unit = println("offspring")//usable only in this class
    protected def isAlive: Boolean = true// usable with subclasses
  }

  class Cat extends Animal{
    def crunch = eat
  }

  val cat = new Cat
  cat.eat
  //cat.reproduce//inaccessible from here


  // constructors in inheritance
  class Person(name:String, age:Int)//default constructor

  class Person1(name:String,age:Int){
    def this(name:String) = this(name,0)//defined constructor
  }

  class Adult(name: String,age:Int,idCard:String) extends Person(name,age)//how to extend/inherit from class with default constructor
  class Adult1(name: String,age:Int,idCard:String) extends Person1(name)//how to extend/inherit from class with defined constructor


  //overriding

  class Dog extends Animal{

    override val nature: String = "domestic"

    super.eat//referencing method of the parent class using super

    override def eat: Unit = println("crunchcrunch")//overriding inherited method eat
  }


  final class Dog1(override val nature: String) extends Animal{//overriding inherited val nature in constructor

    override def eat: Unit = println("crunchcrunch")
  }



  val dog = new Dog//overriding inherited method eat
  val dog1= new Dog1("Canine")//overriding inherited val nature in constructor
  dog.eat
  println(dog.nature)
  println(dog1.nature)


  //type substitution(broad: polymorphism)
  val unknownAnimal: Animal = new Dog1("Canine")

  unknownAnimal.eat//takes on the overridden eat method...it will always take on the most overridden implementation

 //preventing overrides - use final modifier on class or its members
  //you can also seal the class (i.e. use sealed modifier)= extend the class in this file but prevent extension in other files


}
