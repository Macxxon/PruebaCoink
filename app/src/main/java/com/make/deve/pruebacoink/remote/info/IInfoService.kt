package com.make.deve.pruebacoink.remote.info

interface IInfoService {
    suspend fun getDocTypes(): DocTypesResponseModel
    suspend fun getGenders(): GendersResponseModel
}