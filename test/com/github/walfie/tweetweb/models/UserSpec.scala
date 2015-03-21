package com.github.walfie.tweetweb.models

import org.joda.time.DateTime
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
        iconUrl = "http://example.com/image.png",
        updatedAt = new DateTime(3141, 5, 9, 2, 6, 53))

      val expected: JsValue = Json.obj(
        "id" -> "123",
        "name" -> "example",
        "iconUrl" -> "http://example.com/image.png",
        "updatedAt" -> 36964274813000L)

      Json.toJson(user) must_== expected
    }
  }
}

