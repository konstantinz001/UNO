package UNO.aview

import UNO.UnoGame.controller
import UNO.aview.TUI
import UNO.controller.controller
import UNO.model.{Card, Player}
import UNO.util.{State, callFirstUnoEvent, removePlayerCardEvent, toManyCardsEvent}
import org.scalatest._

class TuiSpec extends WordSpec with Matchers {
  "A TUI" should {
    val controller = new controller()
    val tui = new TUI(controller)
    controller.notifyObservers()

    //def playGame(pL:List[Player], stackCard: List[Card], playStack:Card, idx:Int): Unit = {
    "PlayGame input 'r'" in {
      tui.processInputLine("r 0")
      ((controller.playerList(0).playerCards(0).color == controller.playStack.color) ||
        controller.playerList(0).playerCards(0).number == controller.playStack.number) should be (true)
      State.handle(removePlayerCardEvent(0),0) should be
      (println("\n--Handcards:\t" + controller.playerList(0).removePlayerCards(0).playerCards))
    }
    "PlayGame input 's'" in {
      tui.processInputLine("s")
      State.handle(removePlayerCardEvent(0),0) should be
      (println("\n--Handcards:\t" + controller.playerList(0).setPlayerCards(controller.stackCard(0)).playerCards))
    }
    /*"PlayGame input 'u' many Cards" in {
      tui.processInputLine("u 0")
      State.handle(toManyCardsEvent()) should be
      (println("To many Cards") + "\n\n--Handcards:\t" + controller.playerList(0).setPlayerCards(controller.stackCard(0)).playerCards)
    }*/
/*    "PlayGame input 'u' 1st " in {
      tui.processInputLine("u 0")
      State.handle(callFirstUnoEvent(0)) should be
      (println("UNO" + "\n\n--Handcards:\t" + controller.playerList(0).removePlayerCards(0).playerCards))
    }
    /*"PlayGame input 'u' Player1 wins" in {
      tui.processInputLine("u 0") should be
      (println("To many Cards"))
    }*/
    /*"PlayGame input 'q' Player1" in {
      tui.processInputLine("q") should be (println("Game exit"))
    }*/
  }
  "A 2nd TUI" should {
    val controller = new controller()
    val tui = new TUI(controller)
    controller.notifyObservers()

    "Input 's' Player1" in {
      tui.processInputLine("s")
      controller.playerList(1).playerCards.size should be(4)
      controller.playerList(0).playerCards.size should be(3)
    }
    "Input 's' Player2" in {
      tui.processInputLine("s")
      controller.playerList(1).playerCards.size should be(4)
      controller.playerList(0).playerCards.size should be(4)
    }
    "Input 'r 0' Player1 Wrong Card" in {
      tui.processInputLine("r 0")
      controller.playerList(1).playerCards.size should be(4)
      controller.playerList(0).playerCards.size should be(4)
    }
    "Input 'q' Player2" in {
      tui.processInputLine("q") should be (println("Game exit"))
    }*/

  }
}
