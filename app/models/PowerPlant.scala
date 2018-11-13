package models

sealed class Type

case class Nuclear() extends Type
case class Coal() extends Type
case class GeoThermal() extends Type
case class HydroElectric() extends Type

case class PowerPlant(typ: Type, currentEnergy: Float, maxEnergy: Float)
