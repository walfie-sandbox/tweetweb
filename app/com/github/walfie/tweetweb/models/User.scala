package com.github.walfie.tweetweb.models

import org.joda.time.DateTime

import play.api.libs.json.{Json, Format}

case class User (
    id: String = "",
    name: String = "",
    iconUrl: String = "",
    updatedAt: DateTime = new DateTime(0))

object User {
  implicit val userFormat: Format[User] = Json.format[User]
}

