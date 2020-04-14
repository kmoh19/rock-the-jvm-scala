package lectures.part2oop

object Objects{//deleted extends App and explicitly define def main(args:Array[String]):

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ie. static in java instead (see javaplayground)

  object Person{// for class level functionality create singleton instance
    val N_EYES = 2
    def canFly: Boolean=false

    //factory method
    def apply(mother:Person, father:Person): Person =new Person("Bobbie")
  }

  class Person(val name: String){
    //for instance-level functionality
  }
// all of the above is called COMPANION and allows for the achievement of full oop ie. class and instance level functionality
def main(args:Array[String]):Unit= {
  println(Person.N_EYES)


  println(Person.canFly)


  val mary = Person
  val john = Person
  println(mary == john) //returns true as they point to the same singleton instance/object of person

  //but
  val person1 = new Person("mary")
  val person2 = new Person("john")
  println(person1 == person2) // returns false as they point to different class instances/objects of person

  //using factory method
  val bobbie = Person(person1, person2)

  //scala applications= scala object with
  //def main(args:Array[String]):Unit achieved by the extends App definition
}

}
