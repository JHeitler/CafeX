package cafex

import scala.math.BigDecimal.RoundingMode

/**
  * Calculates totals for customer bills
  */
class CafeX {
  /*
       Cafe X menu consists of the following items:
       ● Cola - Cold - 50p
       ● Coffee - Hot - £1.00
       ● Cheese Sandwich - Cold - £2.00
       ● Steak Sandwich - Hot - £4.50
   */

  // Maps menu items to (price, service charge)
  // Note the largest service charge encountered will be aplied to the bill
  val menu = Map(
    ("Cola" -> (BigDecimal(0.50), BigDecimal(0.0))),
    ("Coffee" -> (BigDecimal(1.0), BigDecimal(0.0))),
    ("Cheese Sandwich" -> (BigDecimal(2.0), BigDecimal(0.1))),
    ("Steak Sandwich" -> (BigDecimal(4.5), BigDecimal(0.2))),
    ("Surprise of the day" -> (BigDecimal(13.75), BigDecimal(0.1)))
  )

  def calculateBill(items: List[String]) = {
    items.flatMap(menu.get).foldLeft(BigDecimal(0.0))((soFar, current) => soFar + current._1)
  }

  def calculateBillWithServiceCharge(items: List[String]) = {
    // Get the item cost
    val itemTotal = calculateBill(items)
    // find the tip to apply
    val tipMultiplier = items.flatMap(menu.get).foldLeft(BigDecimal(0.0))((highest, current) => highest.max(current._2))
    // calculate the tip to 2dp
    val tip = BigDecimal(20.0).min(itemTotal * tipMultiplier)
    // And return
    (itemTotal + tip).setScale(2, RoundingMode.HALF_UP)
  }
}
