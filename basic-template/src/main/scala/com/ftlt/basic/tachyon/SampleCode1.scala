package com.ftlt.basic.tachyon

import scala.annotation.nowarn

class SampleCode:

  val example1 =
    """Examples:
      |  * one
      |  * two
      |  * three
      |""".stripMargin

  @nowarn
  private def thisIsPrivate(arg1: String) =
    if "foo" == arg1 && "bar" == ""
    then "baz"
    else "bar"

  def thisIsPublic(
      arg1: String,
      arg2: String,
      arg3: String,
      arg4: String,
      arg5: String,
      arg6: String
  ): String =
    "baz"

end SampleCode

trait TraitOne:

  def thisIsPublic(
      arg1: String,
      arg2: String
  ): Unit

end TraitOne
