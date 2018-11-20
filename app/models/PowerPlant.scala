package models

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

sealed trait Type {
  def getType = this match {
    case Nuclear => "Nuclear"
    case Coal => "Coal"
    case GeoThermal => "GeoThermal"
    case HydroElectric => "HydroElectric"
  }

}

case object Nuclear extends Type
case object Coal extends Type
case object GeoThermal extends Type
case object HydroElectric extends Type

case class PowerPlant(id: Option[Int], typ: Type, currentEnergy: Float, maxEnergy: Float) extends BaseEntity

//
//object PowerPlant {
//
//  implicit val ppReads: Reads[PowerPlant] = (
//    (JsPath \ "id").readNullable[Int] and
//    (JsPath \ "type").read[String] and
//    (JsPath \ "current_energy").read[Float] and
//    (JsPath \ "max_energy").read[Float]
//  )(PowerPlant.apply _)
//
//  implicit val ppWrites: Writes[PowerPlant] = (
//    (JsPath \ "id").write[Int] and
//    (JsPath \ "type").write[String] and
//    (JsPath \ "current_energy").write[Float] and
//    (JsPath \ "max_energy").write[Float]
//  )(PowerPlant.apply _)
//
//}