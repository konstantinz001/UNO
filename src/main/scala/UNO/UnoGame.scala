package UNO

import scala.io.StdIn.readLine
import aview.TUI
import UNO.controller.controller
import UNO.util.{Factory, State, gameStartEvent, gameStatsEvent, instructionEvent}

object UnoGame {
  val controller = new controller()
  val tui = new TUI(controller)

  def main(args: Array[String]): Unit = {
    State.handle(instructionEvent())

    controller.notifyObservers()


    Factory.factoryFunction(args)
  }
}