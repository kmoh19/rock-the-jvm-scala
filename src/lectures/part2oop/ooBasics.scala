package lectures.part2oop

object ooBasics extends App {

  val person = new Person("John",26)
  println(person.age)//Class parameters are not fields until you add val to the constructor
  println(person.x)//field x
  person.greet("Daniel")

  val author = new Writer("Charles", "Dickens",1812)
  val imposter = new Writer("Charles", "Dickens",1812)
  val novel = new Novel("Great Expectations", 1861,author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))// generates true
  println(novel.isWrittenBy(imposter))// generates false even if parameters are the same...this is an issue of equality in OOP
  val counter = new Counter
  counter.inc.print
  counter.inc2.print
  counter.inc.inc2.print
  counter.inc2(10).print

}
//constructor
class Person(name:String, val age:Int){

  val x=2

  println(1+3)

  def greet(name:String): Unit = println(s"${this.name} says: Hi,$name")

  //overloading
  def greet():Unit = println(s"Hi, I am $name")

  // multiple constructors

  def this(name:String)=this(name, 0)// not particularly popular as you can achieve same by setting default args
  def this() = this("John Doe")

}

/* Novel and Writer*/

class Writer(firstName:String, surname: String,val year:Int){

  def fullName: String = firstName+" "+surname

}

class Novel(name: String, year:Int,author:Writer){

  def authorAge = year - author.year
  def isWrittenBy(author:Writer) = author == this.author
  def copy(newYear:Int): Novel = new Novel(name,newYear,author)
}

class Counter(val count:Int =0){ //vs(n:int) and body/getter below
  //def count = n this is a getter but you can use val instead to create the field as shown earlier

  def inc = new Counter(count+1) //immutability ...returning a new instance of the counter instead
  def dec = new Counter(count-1)

  def inc(n:Int) = new Counter(count+n)
  def dec(n:Int) = new Counter(count-n)

  //but say you want to include logging of the iteration

  def inc2 ={
    println("incrementing")//logging
    new Counter(count+1)

  }

  def dec2 ={
    println("decrementing")//logging
    new Counter(count-1)

  }

  def inc2(n:Int):Counter={
    if (n<=0) this
    else inc2.inc2(n-1)//chain calling?
  }

  def dec2(n:Int):Counter={
    if (n<=0) this
    else dec2.dec2(n-1)//chain calling?
  }

  def print = println(count)

}

