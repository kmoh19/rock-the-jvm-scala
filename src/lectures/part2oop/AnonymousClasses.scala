package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal{
    def eat:Unit
  }

  //anonymous class ---they allow you to instantiate classes on the spot
  val funnyAnimal:Animal = new Animal {
    override def eat: Unit = println("hahahahahahahaah") // prints class lectures.part2oop.AnonymousClasses$$anon$1
  }

  println(funnyAnimal.getClass)

  //which is equivalent to
/*
  class AnonymousClasses$$anon$1 extends Animal { //which is what the compiler actually does when you declare an anonymous class
    override def eat: Unit = println("hahahahahahahaah")

  }
  val funnyAnimal:Animal = new AnonymousClasses$$anon$1

 */
  class Person(name: String){

    def sayHi: Unit= println(s"Hi, my name is $name, how can i help")
  }
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can i help")

  }
}
