package com.ftlt.basic.tachyon

object SandboxMain extends App {

  @main def sbm = println(Person(
    name = "name",
    age = 1,
    isActive = true,
    height = 5.00,
    luckyNumber = Option(1L)
  ).toJson)

}
