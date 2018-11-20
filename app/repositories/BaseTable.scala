package repositories

import models.BaseEntity
import slick.jdbc.MySQLProfile.api._

abstract class BaseTable[E <: BaseEntity](tag: Tag, tableName: String) extends Table[E](tag, tableName) {
  val id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
}