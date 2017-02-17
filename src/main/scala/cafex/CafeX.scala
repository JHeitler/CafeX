package cafex

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

  val menu = Map(
    ("Cola" -> 0.5),
    ("Coffee" -> 1.0),
    ("Cheese Sandwich" -> 2.0),
    ("Steak Sandwich" -> 4.5)
  )

  def calculateBill(items: List[String]) = {
    items.flatMap(menu.get).sum
  }
}
