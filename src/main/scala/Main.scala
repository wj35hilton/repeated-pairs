import scala.io.Source

object Main extends App {
  val artists: List[List[String]] = Source.fromFile("./Artist_lists_small.txt").getLines.toList.map(_.split(",").toList)

  naive.repeatedPairs(artists).foreach(println)
}
