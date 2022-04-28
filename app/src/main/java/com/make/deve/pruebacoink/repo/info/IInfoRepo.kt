package com.make.deve.pruebacoink.repo.info

import com.make.deve.pruebacoink.ui.register.fragments.GetDocTypesResponseModel
import com.make.deve.pruebacoink.ui.register.fragments.GetGendersResponseModel

interface IInfoRepo {
    suspend fun getDocTypes(): GetDocTypesResponseModel
    suspend fun getGenders(): GetGendersResponseModel
}