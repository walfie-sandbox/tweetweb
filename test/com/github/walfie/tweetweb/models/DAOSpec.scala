package com.github.walfie.tweetweb.models

import org.joda.time.DateTime
import org.specs2.mutable._
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB
import play.api.test.Helpers._
import play.api.test._

class DAOSpec extends Specification {
  "DAO" should {
    def fakeApp(): FakeApplication =
      FakeApplication(additionalConfiguration = inMemoryDatabase())

    "write and read users" in new WithApplication(fakeApp) {
      val dao = new DAO(DB.driver)

      DB.withSession { implicit s: Session =>
        val users: Seq[User] = Seq(
          User("1", "hello", "http://example.com/image1.png", new DateTime(123)),
          User("2", "world", "http://example.com/image2.png", new DateTime(456)))

        dao.users.insertAll(users:_*)
        dao.users.list must_== users
      }
    }

    "write and read interactions" in new WithApplication(fakeApp) {
      val dao = new DAO(DB.driver)

      DB.withSession { implicit s: Session =>
        val interactions: Seq[Interaction] = Seq(
          Interaction("1", "2", 3),
          Interaction("4", "5", 6))

        dao.interactions.insertAll(interactions:_*)
        dao.interactions.list must_== interactions
      }
    }
  }
}

