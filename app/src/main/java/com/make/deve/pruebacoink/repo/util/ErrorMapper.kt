package com.make.deve.pruebacoink.repo.util

import com.make.deve.pruebacoink.remote.util.RemoteErrorModel
import com.make.deve.pruebacoink.ui.util.BaseUIDataError
import com.make.deve.pruebacoink.ui.util.ErrorActions

interface IErrorMapper : Mapper<RemoteErrorModel?, BaseUIDataError>

class ErrorMapper : IErrorMapper {
    override fun map(input: RemoteErrorModel?): BaseUIDataError {

        val action: ErrorActions = when (input?.code) {
            //412, 401 -> ErrorActions.LOGOUT
            else -> ErrorActions.NONE
        }

        return if (input != null)
            BaseUIDataError(
                id = input.code,
                message = "${input.description} (${input.code})",
                title = input.title,
                action = action
            )
        else BaseUIDataError.getDefaultUIError()
    }
}