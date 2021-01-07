package UNO.model.cardsComponent

case class Card(value: String, color: String) {
  override def toString: String = {
    "Card = %s || %s".format(value, color)
  }
}
