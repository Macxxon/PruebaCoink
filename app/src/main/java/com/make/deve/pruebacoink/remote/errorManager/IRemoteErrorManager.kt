package com.make.deve.pruebacoink.remote.errorManager

import com.make.deve.pruebacoink.remote.util.RemoteErrorModel
import okhttp3.ResponseBody

interface IRemoteErrorManager {

    fun getErrorFromBody(errorBody: ResponseBody?, httpCode: Int): RemoteErrorModel
    fun getErrorFromException(ex: Exception): RemoteErrorModel

}