package com.github.walfie.tweetweb.services

import org.joda.time.DateTime
import play.api.db.slick.Config.driver.simple._
import scala.slick.jdbc.JdbcBackend.Database

import com.github.walfie.tweetweb.models.{DAO, User}
import com.github.walfie.tweetweb.util.PortableJodaSupport._

trait UsersService {
  def save(user: User): Unit
  def find(
      ids: Iterable[String],
      updatedSince: DateTime = new DateTime(0)): List[User]
}

trait UsersServiceComponent {
  def usersService: UsersService
}

class SlickUsersService(
    db: Database,
    dao: DAO) extends UsersService {

  def save(user: User): Unit = {
    db.withSession { implicit session =>
      dao.users.insertOrUpdate(user).run
    }
  }

  def find(
      ids: Iterable[String],
      updatedSince: DateTime = new DateTime(0)): List[User] = {
    db.withSession { implicit session =>
      dao.users.filter { user =>
        user.id.inSetBind(ids) &&
        user.updatedAt >= updatedSince
      }.list
    }
  }
}

