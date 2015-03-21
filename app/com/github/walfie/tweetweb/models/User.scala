package com.github.walfie.tweetweb.models

import play.api.libs.json.{Json, Format}

case class User (
    id: String = "",
    name: String = "",
    iconUrl: String = "")

object User {
  implicit val userFormat: Format[User] = Json.format[User]
}

