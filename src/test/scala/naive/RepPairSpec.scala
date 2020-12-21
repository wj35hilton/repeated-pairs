package naive
import org.scalacheck._
import org.scalacheck.Prop.forAll

object StringSpecification extends Properties("naive") {

  // no pairs if list contains a constant single value
  property("no pairs") = forAll(Gen.listOf("a")) { l =>
    pairs(l).length == 0
  }

  // any list and its reverse will contain the same pairs
  property("pairs in reversed list") = forAll{ l: List[String] =>
    pairs(l).length == pairs(l.reverse).length
  }

  val unicodeStr: Gen[String] = Arbitrary.arbString.arbitrary
  val uniLists = Gen.listOf(Gen.alphaStr)
  // TODO: find a way to make a list of random length from particular instance of the provided generator
  //       below is invoking the generator for every list item
  // val repeatedLists = Gen.listOf(uniLists)

  property("repeated pairs in reversed list") = forAll(uniLists){ l: List[String] =>
    val x = repeatedPairs(List.fill(10)(l)).toList
    val y = pairs(l)

    repeatedPairs(List(l)).toList.length == 0 && (x.sortBy(x => (x._1, x._2)) == y.sortBy(x => (x._1, x._2)))
  }
}
