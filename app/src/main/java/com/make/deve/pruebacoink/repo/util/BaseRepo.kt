package com.make.deve.pruebacoink.repo.util

import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseRepo : KoinComponent {

    val errorMapper: IErrorMapper by inject()

}