package com.github.walfie.tweetweb.util

import com.github.tototoshi.slick.GenericJodaSupport
import play.api.db.slick.Config

object PortableJodaSupport extends GenericJodaSupport(Config.driver)

