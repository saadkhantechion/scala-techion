package com.ftlt.tachyon.di.clients

import com.ftlt.tachyon.di.domain.Person

trait PersonRestClient:

  def isReal(person: Person): Boolean
