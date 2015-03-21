package com.github.walfie.tweetweb.services

import org.joda.time.DateTime
import play.api.db.slick.Config.driver.simple._
import scala.slick.jdbc.JdbcBackend.Database

import com.github.walfie.tweetweb.models.{DAO, User}
import com.github.walfie.tweetweb.util.PortableJodaSupport._

trait UsersService {
  def save(user: User): Unit
  def saveAll(users: Iterable[User]): Unit
  def find(ids: Iterable[String]): List[User]
  def deleteOld(maxUpdatedAt: DateTime): Unit
}

trait UsersServiceComponent {
  def usersService: UsersService
}

class SlickUsersService(
    db: Database,
    dao: DAO) extends UsersService {

  import dao.profile.simple.queryToDeleteInvoker // Implicit required for `delete`

  def save(user: User): Unit = {
    db.withSession { implicit session =>
      dao.users.insertOrUpdate(user).run
    }
  }

  def saveAll(users: Iterable[User]): Unit = users.foreach(save)

  def find(ids: Iterable[String]): List[User] = {
    db.withSession { implicit session =>
      dao.users.filter(_.id.inSetBind(ids)).list
    }
  }

  def deleteOld(maxUpdatedAt: DateTime): Unit = {
    db.withSession { implicit session =>
      dao.users.filter(_.updatedAt < maxUpdatedAt).delete
    }
  }
}

