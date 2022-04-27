package com.make.deve.pruebacoink.remote.info

import com.make.deve.pruebacoink.remote.util.RemoteResponseModel

data class DocTypesResponseModel(
    val items: List<DataItem> = listOf()
) : RemoteResponseModel() {
    data class DataItem(
        val id: Int = 0,
        val notation: String = "",
        val description: String = "",
    )
}

data class GendersResponseModel(
    val items: List<DataItemG> = listOf()
) : RemoteResponseModel() {
    data class DataItemG(
        val id: Int = 0,
        val name: String = "",
        val description: String = "",
    )
}