package lectures.part1basics

object DefaultArgs extends App{
  def trFact(n:Int, acc: Int=1): Int = //acc is a default arg
    if (n<=1) acc
    else trFact(n-1,n*acc)

  val fact10 = trFact(10)

  def savePicture(format: String="jpg", width: Int=1920, height:Int=1080): Unit = println("saving picture")
  savePicture("jpg",800,600)//you have to call in with arg in right order or at least provide the leading arguments
}
