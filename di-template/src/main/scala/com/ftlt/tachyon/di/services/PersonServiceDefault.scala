package com.ftlt.tachyon.di.services

import com.ftlt.tachyon.di.clients.PersonRestClient
import com.ftlt.tachyon.di.dao.PersonDao
import com.ftlt.tachyon.di.domain.Person

trait PersonServiceDefault extends PersonService:

  lazy val personRestClient: PersonRestClient
  lazy val personDao: PersonDao

  override def save(person: Person): Unit =
    if personRestClient.isReal(person) then personDao.save(person)
