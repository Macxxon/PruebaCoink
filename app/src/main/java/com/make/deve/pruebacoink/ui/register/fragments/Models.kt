package com.make.deve.pruebacoink.ui.register.fragments

import com.make.deve.pruebacoink.ui.util.BaseUIData

data class GetDocTypesResponseModel(
    val items: List<DocItem> = listOf()
): BaseUIData()

data class DocItem(
    val description: String = "",
)

data class GetGendersResponseModel(
    val items: List<GenderItem> = listOf()
): BaseUIData()

data class GenderItem(
    val name: String = "",
)