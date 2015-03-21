package com.github.walfie.tweetweb.services

import org.joda.time.DateTime
import play.api.db.slick.Config.driver.simple._
import scala.slick.jdbc.JdbcBackend.Database

import com.github.walfie.tweetweb.models.{DAO, User}

trait UsersService {
  def save(user: User): Unit
  def find(id: String): Option[User]
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

  def find(id: String): Option[User] = {
    db.withSession { implicit session =>
      dao.users.filter(_.id === id).firstOption
    }
  }

  def findMulti(ids: Iterable[String]): List[User] = {
    db.withSession { implicit session =>
      dao.users.filter(_.id.inSetBind(ids)).list
    }
  }
}

