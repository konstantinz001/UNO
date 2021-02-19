package model

import UNO.UnoGame.injector
import UNO.controller.controllerComponent.controllerInterface
import UNO.model.GameState
import UNO.model.PlayerComponent.playerBaseImp.Player
import UNO.model.cardComponent.cardBaseImp.Card
import UNO.model.fileIOComponent.fileIOJsonImp.FileIO
import org.scalatest.{Matchers, WordSpec}

class fileIojsonSpec extends WordSpec with Matchers{
  "A FileIO system" should {
    val fileIO = new FileIO
    val controller = injector.getInstance(classOf[controllerInterface])
    val playerList = List(Player("Testy1", List(Card("1", "red"))), Player("Testy2", List(Card("1", "blue"))))
    val playStack2 = List(Card("3", "red"))
    var gameState: GameState = GameState(playerList, playStack2)

    "be able to save/load a game" in {
      fileIO.save(GameState(playerList, playStack2))
      gameState = fileIO.load
      gameState.playerList(0).name should be("Testy1")
      gameState.playStack(0).color should be("red")
    }
  }
}
