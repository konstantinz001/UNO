package UNO
import org.scalatest._
import UNO.model.Card

class CardSpec extends WordSpec with Matchers {
  "A Card" when {
    "new" should {
      val card = Card(3, "red")
      "have a number" in {
        card.number should be(3)
      }
      "have a color" in {
        card.color should be("red")
      }
      "have a nice String representation" in {
        card.toString should be("Card = 3 || red")
      }
    }
  }
}