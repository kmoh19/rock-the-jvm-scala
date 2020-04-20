package exercises

abstract class MyList_with_Generics[+A] {

    def head: A
    def tail: MyList_with_Generics[A]
    def isEmpty:Boolean
    def add[B>:A](element:B): MyList_with_Generics[B]
    def printElements: String
    //polymorphic call
    override def toString: String ="[" + printElements + "]"

  }

  object Empty1 extends MyList_with_Generics[Nothing]{

    def head: Nothing = throw new NoSuchElementException
    def tail: Nothing =throw new NoSuchElementException
    def isEmpty:Boolean=true
    def add[B>: Nothing](element:B): MyList_with_Generics[B]=new Cons1(element,Empty1)
    def printElements: String = ""

  }

  class Cons1[+A](h: A, t: MyList_with_Generics[A]) extends MyList_with_Generics[A]{
    def head: A = h
    def tail: MyList_with_Generics[A] = t
    def isEmpty:Boolean=false
    def add[B>:A](element:B): MyList_with_Generics[B]=new Cons1(element,this)
    def printElements: String = {
      if(t.isEmpty)"" + h
      else h + ", " + t.printElements
    }

  }

  object ListTest1 extends App{
    val listOfIntegers: MyList_with_Generics[Int] = new Cons1(1, new Cons1(2, new Cons1(3,Empty1)))

    val listOfStrings: MyList_with_Generics[String] = new Cons1("Hello",new Cons1("Scala", Empty1))

    println(listOfIntegers.toString)
    println(listOfStrings.toString)
  }


