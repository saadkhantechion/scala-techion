package com.ftlt.tachyon.di.bootstrap

import com.ftlt.tachyon.di.clients.PersonRestClient
import com.ftlt.tachyon.di.clients.PersonRestClientDefault
import com.ftlt.tachyon.di.dao.PersonDao
import com.ftlt.tachyon.di.dao.PersonDaoJdbc
import com.ftlt.tachyon.di.services.PersonService
import com.ftlt.tachyon.di.services.PersonServiceDefault

trait Registry:

  lazy val personRestClient: PersonRestClient
  lazy val personDao: PersonDao
  lazy val personService: PersonService

trait RegistryDefault extends Registry:
  self =>

  override lazy val personRestClient: PersonRestClient = new PersonRestClientDefault {}

  override lazy val personDao: PersonDao = new PersonDaoJdbc {}

  override lazy val personService: PersonService = new PersonServiceDefault:
    override lazy val personRestClient: PersonRestClient = self.personRestClient
    override lazy val personDao: PersonDao               = self.personDao

object Registry:
  val registry = new RegistryDefault {}
