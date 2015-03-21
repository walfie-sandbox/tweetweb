package com.github.walfie.tweetweb

import play.api.GlobalSettings
import com.typesafe.config.{Config, ConfigFactory}

object TweetWeb extends GlobalSettings {
  lazy val config: Config = ConfigFactory.load
}

