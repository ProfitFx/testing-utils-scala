/**
 * Created by EnoT on 28.07.2017.
 */
object FeedTest {
  println("hw")
  val lst = scala.io.Source.fromFile("feeder.txt").getLines().toList

  println(lst)
  println(lst.size)
  var s = -1
  val mc = lst.size
  def getString: String = {
    s += 1
    val l = s % mc
    lst(l)
  }

  Range(1, 11).foreach(x => println(getString))

}
