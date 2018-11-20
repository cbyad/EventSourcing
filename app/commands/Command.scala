package commands

import models._

sealed trait Command

case class AddPowerPlant(pp: PowerPlant) extends Command {

}

class Produce(pp: PowerPlant, qte: Float)

object Produce extends Command {
  def apply(pp: PowerPlant, qte: Float): Produce = new Produce(pp, qte)
}

class Consume(pp: PowerPlant, qte: Float)

object Consume extends Command {
  def apply(pp: PowerPlant, qte: Float): Consume = new Consume(pp, qte)
}
