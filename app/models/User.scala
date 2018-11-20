package models

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class User(id: Option[Int], username: String, password: String) extends BaseEntity

object User {
  implicit val userReads: Reads[User] = (
    (JsPath \ "id").readNullable[Int] and
    (JsPath \ "username").read[String] and
    (JsPath \ "password").read[String]
  )(User.apply _)

  implicit val userWrites: Writes[User] = (
    (JsPath \ "id").writeNullable[Int] and
    (JsPath \ "username").write[String] and
    (JsPath \ "password").write[String]
  )(unlift(User.unapply))
}