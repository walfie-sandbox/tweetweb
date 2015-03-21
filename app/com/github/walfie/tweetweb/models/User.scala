package com.github.walfie.tweetweb.models

import org.joda.time.DateTime
import play.api.db.slick.Profile
import play.api.libs.json.{Json, Format}

import com.github.walfie.tweetweb.util.PortableJodaSupport._

case class User (
    id: String = "",
    name: String = "",
    iconUrl: String = "",
    updatedAt: DateTime = new DateTime(0))

object User {
  implicit val userFormat: Format[User] = Json.format[User]
}

trait UserComponent {
  this: Profile =>

  import profile.simple._

  val users = TableQuery[UsersTable]

  class UsersTable(tag: Tag) extends Table[User](tag, "users") {
    def id = column[String]("id")
    def name = column[String]("name")
    def iconUrl = column[String]("iconUrl")
    def updatedAt = column[DateTime]("updatedAt")

    def * = (id, name, iconUrl, updatedAt) <> ((User.apply _).tupled, User.unapply _)

    def pk = primaryKey("pk_id", id)
  }
}

