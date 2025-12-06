package cucumber.features

import io.cucumber.scala.{EN, ScalaDsl}

object GlobalHooks extends ScalaDsl with EN:

  BeforeAll {
    println("Before All")
  }

  AfterAll {
    println("After All")
  }