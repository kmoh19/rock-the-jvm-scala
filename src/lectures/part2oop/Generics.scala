package lectures.part2oop

//generics allows you to generalise your code across multiple data types
object Generics extends App{
//generic class
  class MyList[A]{// square bracket denotes generic type

  }
  class MyMap[Key,Value]//multiple generic type


  val listOfIntegers =new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList{
    def empty[A]: MyList[A]= ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1- yes List[Cat] extends List[Animal] = COVARIANCE

  class CovariantList[+A] // + denotes covariance
  val animal:Animal = new Cat
  val animalList: CovariantList[Animal]= new CovariantList[Cat]

  // animalList.add(new Dog) ?? HARD QUESTION ans=> we return a list of animals instead

  //2 - NO = INVARIANCE

  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]//types must match

  //3 - hell no CONTRAVARIENCE
  class ContravariantList[-A]
  val contravarientList:ContravariantList[Cat] = new ContravariantList[Animal]//does not make sense....

  //but
  class Trainer[-A]
  val trainer:Trainer[Cat] = new Trainer[Animal]//makes sense in this context

  //bounded types ---they solve variance problems
  class Cage[A<:Animal](animal:A) //accept only subclasses of animal i.e. lowerbound upper bound denoted by >
  val cage = new Cage (new Dog)

  class Car
 // val newCage = new Cage(new Car)// throws error

  //e.g

  class MyList2[+A]{
    def add[B>:A](element:B):MyList[B]= ???

    /*
    A= cat
    B= Animal
     */

  }
}
