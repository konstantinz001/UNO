package UNO.controller.controllerComponent.controllerBaseImp

import UNO.controller.controllerComponent.controllerInterface
import UNO.model.cardComponent.cardBaseImp.Card
import UNO.util.Command


class RemoveCommand(handindex: Int, controller: controllerInterface) extends Command {
  override def doStep: Unit = {

    controller.playStack2 = controller.playerList(0).playerCards(handindex) :: controller.playStack2
    cardDiff
  }


//TODO Cleaning: If -> Match-Case and take to Strategy
  override def undoStep: Unit = {
    if (controller.playStack2(1).color == "black") {
      controller.playerList = List(controller.playerList(1).setPlayerCards(controller.playStack2(1)), controller.playerList(0))
      controller.playStack2 = controller.playStack2.tail.tail
      if (controller.playerList(0).playerCards(0).value == "4+ ColorSwitch") {
        (1 to 4).foreach((i) => {
          controller.stackCard = controller.stackCard.reversePullCards(List(controller.playerList(1).playerCards(0)))
          controller.playerList = List(controller.playerList(0), controller.playerList(1).removePlayerCards(0))
        })
      }
    }
    else {
      controller.playerList = List(controller.playerList(1).setPlayerCards(controller.playStack2(0)), controller.playerList(0))
      controller.playStack2 = controller.playStack2.tail
      if (controller.playerList(0).playerCards(0).value == "+2") {
        (1 to 2).foreach(_ => {
          controller.stackCard = controller.stackCard.reversePullCards(List(controller.playerList(1).playerCards(0)))
          controller.playerList = List(controller.playerList(0), controller.playerList(1).removePlayerCards(0))
        })
      }
      if (controller.playerList(0).playerCards(handindex).value == "<-->") {
        controller.playerList = controller.playerList.reverse
      }
      if (controller.playerList(0).playerCards(handindex).value == "Ø") {
        controller.playerList = List(controller.playerList(1), controller.playerList(0))
      }
    }
  }

  override def redoStep: Unit = {
    controller.playStack2 = controller.playerList(0).playerCards(handindex) :: controller.playStack2
    cardDiff
  }


  def cardDiff: Unit = {
    if (controller.playerList(0).playerCards(handindex).color == "black") {
      val getColor = controller.colorSet

      controller.playStack2 = Card("", getColor) :: controller.playStack2
    }

    if (controller.playerList(0).playerCards(handindex).value == "+2") {
      (1 to 2).foreach((i)=> {
        controller.playerList = List( controller.playerList(0),controller.playerList(1).setPlayerCards(controller.stackCard.getCardFromStack()))
        controller.stackCard = controller.stackCard.removeCard()
        println(controller.playerList(1).playerCards)
      })
      controller.playerList = List(controller.playerList(1), controller.playerList(0).removePlayerCards(handindex))
    }
    else if (controller.playerList(0).playerCards(handindex).value == "4+ ColorSwitch") {
      (1 to 4).foreach((i)=> {
        controller.playerList = List( controller.playerList(0),controller.playerList(1).setPlayerCards(controller.stackCard.getCardFromStack()))
        controller.stackCard = controller.stackCard.removeCard()
      })
      controller.playerList = List(controller.playerList(1), controller.playerList(0).removePlayerCards(handindex))
    }
    else if (controller.playerList(0).playerCards(handindex).value == "<-->") {
      controller.playerList = List(controller.playerList(1), controller.playerList(0).removePlayerCards(handindex))
      controller.playerList = controller.playerList.reverse
    }
    else if (controller.playerList(0).playerCards(handindex).value == "Ø") {
      controller.playerList = List(controller.playerList(1), controller.playerList(0).removePlayerCards(handindex))
      controller.playerList = controller.playerList.tail ::: List(controller.playerList.head) ::: Nil
    }
    else {
      controller.playerList = List(controller.playerList(1), controller.playerList(0).removePlayerCards(handindex))
    }
  }
}

