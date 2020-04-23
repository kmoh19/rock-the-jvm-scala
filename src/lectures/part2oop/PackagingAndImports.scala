package lectures.part2oop

import playground.{PrinceCharming, ScalaPlayground=>newObj}// import playground._ to import all
import java.util.Date
import java.sql.{Date => sqlDate}
object PackagingAndImports extends App{

// package members are accessible by their simple names
  val writer = new Writer("Daniel","James",2016)
  val myObj= newObj //newObj is alias ..see import statement
  println(myObj.myValue)

  //packages are in heirarchy
  //matches folder structure in the file system

  //package object
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming
  val d = new Date //will refer to the first import of name Date if there are two of them  i.e. util.Date
  val d2 = new java.sql.Date(2018,5,4)// on the other hand you can use fully qualified names
  //or aliases
  val d3 = new sqlDate(2018,5,4)

  //default imports
  //java.lang - String,Object,Exception
  //scala - Int, Nothing, Function
  //scala.Predef- println,???
}
