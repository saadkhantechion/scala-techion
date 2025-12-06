package org.techion.smithy4s.restapi.bootstrap

import cats.effect.IO
import org.techion.smithy4s.helloworld.HelloWorldService
import org.techion.smithy4s.restapi.services.HelloWorldServiceDefault
import cats.data.Kleisli
import org.http4s.*
import cats.data.OptionT
import cats.effect.Resource
import smithy4s.http4s.SimpleRestJsonBuilder
import cats.implicits.*

trait ServiceRegistry :
  lazy val helloWorldService : HelloWorldService[IO]
  lazy val allroutes: Resource[IO, HttpRoutes[IO]]


trait ServiceRegistryDefault extends ServiceRegistry {self =>

  override lazy val helloWorldService : HelloWorldService[IO] = new HelloWorldServiceDefault{}

  override lazy val allroutes: Resource[IO, HttpRoutes[IO]] =
    for
      helloWorldService <- SimpleRestJsonBuilder.routes(self.helloWorldService).resource
    yield List(helloWorldService).foldK <+> smithy4s.http4s.swagger.docs[IO](HelloWorldService)


}

object ServiceRegistry:

  val factory = new ServiceRegistryDefault {}
