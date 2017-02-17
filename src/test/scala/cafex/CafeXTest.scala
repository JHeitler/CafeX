package cafex

import org.specs2.mutable.Specification

/**
  * CTest the Cafe bill calculation functions
  */
class CafeXTest extends Specification {
  val cafe = new CafeX
  "calculateBill should" >> {
    "Rerurn 0 if passed an empty list" >> {
        cafe.calculateBill(List.empty) must_== BigDecimal(0.00)
    }

    "Correctly add up items in a bill" >> {
      cafe.calculateBill(List("Cola", "Cheese Sandwich")) must_== BigDecimal(2.50)
    }

    "Correctly add a list with duplicates" >> {
      cafe.calculateBill(List("Cola", "Cola", "Cheese Sandwich")) must_== BigDecimal(3.00)
    }

    "Ignore items not on the menu!" >> {
      cafe.calculateBill(List("Cola", "Steak Sandwich", "Rabbit stew", "Cheese Sandwich")) must_== BigDecimal(7.00)
    }
  }

  "CalculteBillWithServiceCharge should" >> {
    "Correctly calculate the bill if only drinks" >> {
      cafe.calculateBillWithServiceChrge(List("Cola", "Cola", "Coffee")) must_== BigDecimal(2.00)
    }

    "Correctly calcuylate the bill with only drinks and cold food" >> {
      cafe.calculateBillWithServiceChrge(List("Cola", "Cola", "Cheese Sandwich", "Coffee", "Cheese Sandwich")) must_== BigDecimal(6.60)
    }

    "Correctly calculate the bill if hot food is included" >> {
      cafe.calculateBillWithServiceChrge(List("Cola", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich")) must_== BigDecimal(10.20)
    }

    "Ensure the tip does not go above £20" >> {
      cafe.calculateBillWithServiceChrge(List("Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich",
        "Cola", "Steak Sandwich", "Cola", "Steak Sandwich", "Coffee", "Cheese Sandwich"
      )) must_== BigDecimal(150.00)
    }

    "Round the tip to 2dp" >> {
      cafe.calculateBillWithServiceChrge(List("Surprise of the day")) must_== BigDecimal(15.13)
    }
  }
}
