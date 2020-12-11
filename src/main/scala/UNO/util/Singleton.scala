package UNO.util

import UNO.UnoGame.tui
import org.graalvm.compiler.graph.Node.Input

import scala.io.StdIn.readLine

object Factory {
  def factoryFunction(argument: Array[String]) = argument.length match {
    case 0 => {
      var input1: String = ""
      do {
        State.handle(gameStatsEvent())
        input1 = readLine("\nInstruction: ")
        tui.processInputLine(input1)
      } while (input1 != "q")
    }
    case default => tui.processInputLine(argument(0))
  }
}
