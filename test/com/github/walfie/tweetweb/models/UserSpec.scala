package com.github.walfie.tweetweb.models

import org.specs2.mutable._
import org.specs2.runner._
import org.specs2.specification._
import play.api.libs.json._

class UserSpec extends Specification {
  "User" should {
    "be JSON serializable" in {
      val user: User = User(
        id = "123",
        name = "example",
        iconUrl = "http://example.com/image.png")

      val expected: JsValue = Json.obj(
        "id" -> "123",
        "name" -> "example",
        "iconUrl" -> "http://example.com/image.png")

      Json.toJson(user) must_== expected
    }
  }
}

