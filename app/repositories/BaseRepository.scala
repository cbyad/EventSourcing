package repositories

import models.BaseEntity
import utils.Page

import play.api.db.slick.{ DatabaseConfigProvider, HasDatabaseConfigProvider }
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait BaseRepositoryComponent[E <: BaseEntity, T <: BaseTable[E]] {
  def getAll(page: Int, size: Int): Future[Page[E]]
  def save(row: E): Future[Unit]
}

abstract class BaseRepository[E <: BaseEntity, T <: BaseTable[E]](val dbConfigProvider: DatabaseConfigProvider, val query: TableQuery[T])
  extends HasDatabaseConfigProvider[JdbcProfile] with BaseRepositoryComponent[E, T] {

  def getAll(page: Int, size: Int): Future[Page[E]] = {
    db.run(
      for {
        total <- query.length.result
        res <- query.sortBy(_.id).drop(page).take(size).result
      } yield Page(page, size, total, res)
    )
  }

  def save(row: E): Future[Unit] = {
    db.run(query += row).map(_ => ())
  }

}