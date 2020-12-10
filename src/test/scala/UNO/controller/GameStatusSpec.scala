package UNO.controller

import UNO.controller.GameStatus.{GameStatus, _}
import UNO.util.Observer
import org.scalatest.{Matchers, WordSpec, color}

class GameStatusSpec extends WordSpec with Matchers {
  "A GameStatus" when {
    "new" should {
      var gameStatus = IDLE
    }
    "IDLE" in {
      GameStatus.message(IDLE) should be ("")
    }
    "WON" in {
      GameStatus.message(WON) should be ("You won")
    }
    "LOST" in {
      GameStatus.message(LOST) should be ("You lost")
    }
  }
}