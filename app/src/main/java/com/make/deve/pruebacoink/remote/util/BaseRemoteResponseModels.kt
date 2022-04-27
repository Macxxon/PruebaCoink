package com.make.deve.pruebacoink.remote.util

import com.squareup.moshi.Json

abstract class RemoteResponseModel {
    open var errorModel: RemoteErrorModel? = null
}

/**
 * Response model with a boolean as its [data]
 */
data class SimpleBooleanRemoteModel(
    val data: Boolean = false
) : RemoteResponseModel()

/**
 * Response model with a [SimpleSuccessResponse] as its [data]
 */
data class SimpleSuccessRemoteModel(
    val data: SimpleSuccessResponse = SimpleSuccessResponse(false)
) : RemoteResponseModel()

/**
 * The default error response.
 */
data class RemoteErrorModel(

    @field:Json(name = "code")
    var code: Int = -1,

    @field:Json(name = "title")
    val title: String? = null,

    @field:Json(name = "message")
    val description: String = "",

    @field:Json(name = "timestamp")
    val timestamp: String = "",

    @field:Json(name = "description")
    val internalServerMessage: String = "",

    @field:Json(name = "error")
    val errorAlert: String = "",

    @field:Json(name = "message")
    val error_description: String = "",


    )

/**
 * A response model with a [success] boolean and a [message] string. To be used inside a [RemoteResponseModel].
 * The default implementation is a [SimpleSuccessRemoteModel]
 */
data class SimpleSuccessResponse(
    @field:Json(name = "success") val success: Boolean = false,
    @field:Json(name = "message") val message: String = ""
)