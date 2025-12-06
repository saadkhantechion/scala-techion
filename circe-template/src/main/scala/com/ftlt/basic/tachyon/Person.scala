package com.ftlt.basic.tachyon



case class Person(
                   name: String,
                   age: Int,
                   isActive: Boolean,
                   height: Double,
                   luckyNumber: Option[Long]
                 )

object Person {

  import io.circe.generic.semiauto._
  import io.circe._
  import io.circe.syntax._

  given decoder: Decoder[Person] = deriveDecoder[Person]
  given encoder: Encoder[Person] = deriveEncoder[Person]

  extension(value : Person )
    def toJson : String = value.asJson.toString

  
  
}