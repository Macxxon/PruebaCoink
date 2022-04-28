package com.make.deve.pruebacoink.remote.info

import com.make.deve.pruebacoink.remote.util.BaseRetrofitService
import org.json.JSONArray
import org.json.JSONObject

class InfoService: BaseRetrofitService(),IInfoService {
    override val contract: InfoContract
        get() = build(InfoContract::class.java)

    override suspend fun getDocTypes(): DocTypesResponseModel {
        var res = DocTypesResponseModel()
        try {

            val rem = contract.getDocTypes(API_KEY)
            println(rem)
            println(rem.body())
            if (rem.isSuccessful) {
                val remoteAssignedList = JSONArray(rem.body()!!)
                val itemsModel = mutableListOf<DocTypesResponseModel.DataItem>()
                for (i in 0 until remoteAssignedList.length()) {
                    val singMov = remoteAssignedList[i] as JSONObject
                    itemsModel.add(
                        DocTypesResponseModel.DataItem(
                            id = singMov.getInt("id"),
                            notation= singMov.getString("notation"),
                            description = singMov.getString("description")

                        )
                    )
                }


                res = DocTypesResponseModel(itemsModel)
            } else {
                res.errorModel = errorManager.getErrorFromBody(rem.errorBody(), rem.code())
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            res.errorModel = errorManager.getErrorFromException(ex)
        }

        return res
    }

    override suspend fun getGenders(): GendersResponseModel {
        var res = GendersResponseModel()
        try {

            val rem = contract.getGender(API_KEY)
            println(rem)
            println(rem.body())
            if (rem.isSuccessful) {
                val remoteAssignedList = JSONArray(rem.body()!!)
                val itemsModel = mutableListOf<GendersResponseModel.DataItemG>()
                for (i in 0 until remoteAssignedList.length()) {
                    val singMov = remoteAssignedList[i] as JSONObject
                    itemsModel.add(
                        GendersResponseModel.DataItemG(
                            id = singMov.getInt("id"),
                            name = singMov.getString("name"),
                            description = singMov.getString("description")

                        )
                    )
                }


                res = GendersResponseModel(itemsModel)
            } else {
                res.errorModel = errorManager.getErrorFromBody(rem.errorBody(), rem.code())
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            res.errorModel = errorManager.getErrorFromException(ex)
        }

        return res
    }

    companion object{
        const val API_KEY = "030106"
    }

}