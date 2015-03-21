package com.github.walfie.tweetweb.models

import org.specs2.mutable._
import org.specs2.runner._
import org.specs2.specification._
import play.api.libs.json._

class InteractionSpec extends Specification {
  "Interaction" should {
    "be JSON serializable" in {
      val interaction: Interaction = Interaction(
        fromId = "123",
        toId = "456",
        count = 10)

      val expected: JsValue = Json.obj(
        "fromId" -> "123",
        "toId" -> "456",
        "count" -> 10)

      Json.toJson(interaction) must_== expected
    }
  }
}


