package cafex

import org.specs2.mutable.Specification

/**
  * CTest the Cafe bill calculation functions
  */
class CafeXTest extends Specification {
  val cafe = new CafeX
  "calculateBill should" >> {
    "Rerurn 0 if passed an empty list" >> {
        cafe.calculateBill(List.empty) must_== 0
    }

    "Correctly add up items in a bill" >> {
      cafe.calculateBill(List("Cola", "Cheese Sandwich")) must_== 2.5
    }

    "Correctly add a list with duplicates" >> {
      cafe.calculateBill(List("Cola", "Cola", "Cheese Sandwich")) must_== 3
    }

    "Ignore items not on the menu!" >> {
      cafe.calculateBill(List("Cola", "Steak Sandwich", "Rabbit stew", "Cheese Sandwich")) must_== 7
    }
  }
}
