import scala.io.Source

object Main extends App {

  val artists: List[List[String]] = Source.fromFile("./Artist_lists_small.txt").getLines.toList.map(_.split(",").toList)

  val result00 = naive.repeatedPairs(artists)
  prepareOutput(result00.toList).foreach(println)

  def prepareOutput(pairs: List[(String, String)]): List[String] =
    pairs.sorted.map {
      case(l, r) => s"$l,$r"
    }
}
