package com.ftlt.tachyon.di.services

import com.ftlt.tachyon.di.bootstrap.RegistryDefault
import com.ftlt.tachyon.di.clients.PersonRestClient
import com.ftlt.tachyon.di.clients.PersonRestClientDefault
import com.ftlt.tachyon.di.domain.Person

class PersonServiceTest:

  def testPersonService(): Unit =
    val testRegistry = new RegistryDefault:
      override lazy val personRestClient: PersonRestClient = new PersonRestClientStub {}
    try testRegistry.personService.save(Person("real", "10", "home"))
    catch case e: Exception => assert(false)

trait PersonRestClientStub extends PersonRestClientDefault:
  override def isReal(person: Person): Boolean = false
