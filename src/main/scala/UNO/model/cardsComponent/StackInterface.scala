package UNO.model.cardsComponent.StackBaseImpl

import UNO.model.Card

trait StackInterface {
  def initStack(): Stack
  def shuffleCards(): Stack
  def removeCard(): Stack
  def pullCards(playerStack: List[Card]): Stack
  def reversePullCards(playerStack: List[Card]): Stack
  def getCardFromStack(): Card
}
