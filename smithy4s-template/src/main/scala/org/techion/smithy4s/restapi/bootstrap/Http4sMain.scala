package org.techion.smithy4s.restapi.bootstrap

import org.http4s.ember.server.EmberServerBuilder
import cats.effect.{IO, IOApp}
import com.comcast.ip4s.*

object Http4sMain extends IOApp.Simple:

  val run = ServiceRegistry.factory.allroutes
    .flatMap { routes =>
      EmberServerBuilder
        .default[IO]
        .withPort(port"9000")
        .withHost(host"localhost")
        .withHttpApp(routes.orNotFound)
        .build
    }
    .use(_ => IO.never)


