package com.make.deve.pruebacoink.remote.errorManager

import com.make.deve.pruebacoink.R
import com.make.deve.pruebacoink.remote.util.RemoteErrorModel
import com.make.deve.pruebacoink.resources.Integers
import com.make.deve.pruebacoink.resources.Strings
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import java.util.concurrent.TimeoutException

class RemoteErrorManager: IRemoteErrorManager {

    override fun getErrorFromBody(errorBody: ResponseBody?, httpCode: Int): RemoteErrorModel {
        return if (errorBody != null) {
            try {
                val moshi = Moshi.Builder().build()
                val errorAdapter = moshi.adapter(RemoteErrorModel::class.java)

                val error = errorAdapter.fromJson(errorBody.source()) ?: getDefaultError(httpCode)
                //if the code is -1, it's the default, so no code was in the error body, so the http code is used
                if (error.code == -1) error.code = httpCode

                error
            } catch (ex: Exception) {
                ex.printStackTrace()

                getDefaultError(httpCode)
            }
        } else {
            getDefaultError(httpCode)
        }
    }

    override fun getErrorFromException(ex: Exception): RemoteErrorModel {
        return when (ex) {
            is TimeoutException -> {
                RemoteErrorModel(
                    code = Integers.get(R.integer.error_remote_timeout),
                    description = Strings.get(R.string.error_remote_timeout)
                )
            }
            is java.net.UnknownHostException -> {
                RemoteErrorModel(
                    code = Integers.get(R.integer.error_remote_unhost),
                    description = Strings.get(R.string.error_remote_unhost)
                )
            }
            else -> getDefaultError()
        }
    }

    private fun getDefaultError(): RemoteErrorModel {
        return RemoteErrorModel(
            code = Integers.get(R.integer.error_remote_default_code),
            description = Strings.get(R.string.error_remote_default_desc)
        )
    }

    private fun getDefaultError(httpCode: Int): RemoteErrorModel {
        return RemoteErrorModel(
            code = httpCode,
            description = Strings.get(R.string.error_remote_default_desc)
        )
    }

}