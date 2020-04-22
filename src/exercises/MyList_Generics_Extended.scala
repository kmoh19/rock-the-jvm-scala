package exercises

abstract class MyList_Generics_Extended[+A] {

  def head: A
  def tail: MyList_Generics_Extended[A]
  def isEmpty:Boolean
  def add[B>:A](element:B): MyList_Generics_Extended[B]
  def printElements: String
  //polymorphic call
  override def toString: String ="[" + printElements + "]"

  def map[B](transformer: MyTransformer[A,B]) :MyList_Generics_Extended[B]
  def flatMap[B](transformer: MyTransformer[A,MyList_Generics_Extended[B]]) :MyList_Generics_Extended[B]
  def filter(predicate: MyPredicate[A]): MyList_Generics_Extended[A]
  //concatenation
  def ++[B>:A](list:MyList_Generics_Extended[B]):MyList_Generics_Extended[B]

}

object Empty2 extends MyList_Generics_Extended[Nothing]{

  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing =throw new NoSuchElementException
  def isEmpty:Boolean=true
  def add[B>: Nothing](element:B): MyList_Generics_Extended[B]=new Cons2(element,Empty2)
  def printElements: String = ""
  /* Map
  [1,2,3].map(n*2)
  =new Cons2(2,[2,3].map(n*2))
  =new Cons2(2, new Cons(4, [3].map(n*2)))
  =new Cons2(2, new Cons(4, new Cons2(6, Empty2.map(n*2))))
  =new Cons2(2, new Cons(4, new Cons2(6, Empty2))))
 */
  def map[B](transformer: MyTransformer[Nothing,B]) :MyList_Generics_Extended[B] = Empty2
  def flatMap[B](transformer: MyTransformer[Nothing,MyList_Generics_Extended[B]]) :MyList_Generics_Extended[B] = Empty2

  /* filter
  [1,2,3].filter(n % 2 ==0)=
  [2,3].filter(n % 2 ==0) =
  new Cons2(2, [3].filter(n%2 ==0))
  new Cons2(2, Empty.filter(n%2 ==0))
  =new Cons2(2,Empty)

   */

  def filter(predicate: MyPredicate[Nothing]): MyList_Generics_Extended[Nothing] = Empty2
  def ++[B>:Nothing](list:MyList_Generics_Extended[B]):MyList_Generics_Extended[B]= list
}

trait MyPredicate[-T]{
  def test(elem:T): Boolean
}

trait MyTransformer[-A,B]{
  def transform(elem: A) :B
}

class Cons2[+A](h: A, t: MyList_Generics_Extended[A]) extends MyList_Generics_Extended[A]{
  def head: A = h
  def tail: MyList_Generics_Extended[A] = t
  def isEmpty:Boolean=false
  def add[B>:A](element:B): MyList_Generics_Extended[B]=new Cons2(element,this)
  def printElements: String = {
    if(t.isEmpty)"" + h
    else h + ", " + t.printElements
  }
  def filter(predicate: MyPredicate[A]): MyList_Generics_Extended[A] =
    if (predicate.test(h)) new Cons2(h,t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: MyTransformer[A,B]) :MyList_Generics_Extended[B] =
    new Cons2(transformer.transform(h),t.map(transformer))

  /* ++
  [1,2] ++ [3,4,5]
  = new Cons2(1, [2] ++ [3,4,5])
  = new Cons2(1, new Cons2(2, Empty2 ++ [3,4,5]))
  =new Cons2(1, new Cons2(2, new Cons2(3, new Cons2(4, new Cons2(5)))))
   */
  def ++[B>:A](list:MyList_Generics_Extended[B]):MyList_Generics_Extended[B]= new Cons2(h, t ++ list)
  /*
   [1,2].flatMap(n=>[n, n+1])
   =[1,2] ++ [2].flatMap(n=>[n, n+1])
  =[1,2] ++ [2,3] ++ Empty2.flatMap(n=>[n,n+1])
  =[1,2] ++ [2,3] ++ Empty2
  =[1,2,2,3]

   */

  def flatMap[B](transformer: MyTransformer[A,MyList_Generics_Extended[B]]) :MyList_Generics_Extended[B] =
    transformer.transform(h) ++ t. flatMap(transformer)
}


object ListTest2 extends App{
  val listOfIntegers: MyList_Generics_Extended[Int] = new Cons2(1, new Cons2(2, new Cons2(3,Empty2)))
  val anotherlistOfIntegers: MyList_Generics_Extended[Int] = new Cons2(4, new Cons2(5, new Cons2(6,Empty2)))
  val listOfStrings: MyList_Generics_Extended[String] = new Cons2("Hello",new Cons2("Scala", Empty2))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int,Int] {
    override def transform(elem: Int): Int = elem*2
  }).toString)

  println(listOfIntegers.filter(new MyPredicate[Int]{
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println((listOfIntegers ++ anotherlistOfIntegers).toString)

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList_Generics_Extended[Int]] {
    override def transform(elem: Int): MyList_Generics_Extended[Int] = new Cons2(elem, new Cons2(elem+1, Empty2))
  }).toString)

}