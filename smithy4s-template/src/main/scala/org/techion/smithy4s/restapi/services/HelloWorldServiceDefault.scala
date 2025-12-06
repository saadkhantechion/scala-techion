package org.techion.smithy4s.restapi.services

import cats.effect.IO
import org.techion.smithy4s.helloworld.{Greeting, HelloWorldService}

trait HelloWorldServiceDefault extends HelloWorldService[IO] {

  override def hello(name: String, town: Option[String]): IO[Greeting] = IO.pure(Greeting("HelloWorld") )


}
