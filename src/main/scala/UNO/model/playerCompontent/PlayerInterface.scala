package UNO.model.playerCompontent

import UNO.model.Card
import UNO.model.playerCompontent.PlayerBaseImpl.Player


trait PlayerInterface {
  def setPlayerCards(setcard:Card):Player
  def removePlayerCards(index: Int): Player
  def tryRemovePlayerCards(index: Int): Option[Player]
}
