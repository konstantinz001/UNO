package UNO.controller

import UNO.model.cardsComponent.Card
import UNO.model.playerCompontent.PlayerBaseImpl.Player

import scala.swing.Publisher

trait ControllerInterface extends Publisher {
  def initStack() : List[Card]
  def createPlayer(): List[Player]
  def startHand(): List[Card]
  def getCard(): Unit
  def removeCard(handindex: Int)
  def undoGet: Unit
  def redoGet: Unit
  def changeStack(handindex:Int): Unit


}
