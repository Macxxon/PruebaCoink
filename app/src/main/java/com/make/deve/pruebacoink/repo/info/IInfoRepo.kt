package com.make.deve.pruebacoink.repo.info

import com.make.deve.pruebacoink.ui.registerFragments.GetDocTypesResponseModel
import com.make.deve.pruebacoink.ui.registerFragments.GetGendersResponseModel

interface IInfoRepo {
    suspend fun getDocTypes(): GetDocTypesResponseModel
    suspend fun getGenders(): GetGendersResponseModel
}