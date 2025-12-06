package com.ftlt.tachyon.di.clients

import com.ftlt.tachyon.di.domain.Person

trait PersonRestClientDefault extends PersonRestClient:

  override def isReal(person: Person): Boolean = true
