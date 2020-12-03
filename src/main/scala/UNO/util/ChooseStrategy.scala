package UNO.util
object ChooseStrategy{



  var strategy = {}

  def choose(e: Eventt, index: Int) = {
    e match {
      case a: strategyEvent2 => strategy = strategyEvent2(index).strategy2
    }
  }
  def choose(e: Eventt) = {
    e match {
      case a: strategyEvent1 => strategy = strategyEvent1().strategy1
    }
  }
}
