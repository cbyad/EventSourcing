package utils

import play.api.libs.json._
import play.api.libs.functional.syntax._

/**
 *
 * @param page  : Current page
 * @param size  : Number of items in a page
 * @param total : Total items
 * @param rows  Rows of E to display in this page
 * @tparam E generic type
 */
case class Page[E](page: Int, size: Int, total: Int, rows: Seq[E])

object Page {
  implicit def jsonWrites[E](implicit entriesWrites: Writes[E]): Writes[Page[E]] = (
    (JsPath \ "page").write[Int] and
    (JsPath \ "size").write[Int] and
    (JsPath \ "total").write[Int] and
    (JsPath \ "rows").write[Seq[E]]
  )(unlift(Page.unapply[E]))

  def empty[E]: Page[E] = Page[E](0, 0, 0, Seq.empty[E])

}