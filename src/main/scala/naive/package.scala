package object naive {

  // a more or less direct translation of reqs
  def repeatedPairs(ls: List[List[String]]) =
    ls.flatMap(pairs).groupBy(identity).filter{
      case (_, v) => v.size > 1
    }.keys

  def pairs(l: List[String]): List[(String, String)] = (for {
    x <- l
    y <- l if (x < y)
  } yield (x,y)).distinct
}
