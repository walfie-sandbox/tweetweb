package com.github.walfie.tweetweb.models

import play.api.db.slick.Profile
import play.api.libs.json.{Json, Format}

case class Interaction (
    fromId: String = "",
    toId: String = "",
    count: Int = 0)

object Interaction {
  implicit val interactionFormat: Format[Interaction] = Json.format[Interaction]
}

trait InteractionComponent {
  this: Profile =>

  import profile.simple._

  val interactions = TableQuery[InteractionsTable]

  class InteractionsTable(tag: Tag) extends Table[Interaction](tag, "interactions") {
    def fromId = column[String]("fromId")
    def toId = column[String]("toId")
    def count = column[Int]("count")

    def * = (fromId, toId, count) <> ((Interaction.apply _).tupled, Interaction.unapply _)

    def pk = primaryKey("pk_interactions", (fromId, toId))
  }
}


