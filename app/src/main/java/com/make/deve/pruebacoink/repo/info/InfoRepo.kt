package com.make.deve.pruebacoink.repo.info

import com.make.deve.pruebacoink.remote.info.IInfoService
import com.make.deve.pruebacoink.repo.util.BaseRepo
import com.make.deve.pruebacoink.ui.registerFragments.DocItem
import com.make.deve.pruebacoink.ui.registerFragments.GenderItem
import com.make.deve.pruebacoink.ui.registerFragments.GetDocTypesResponseModel
import com.make.deve.pruebacoink.ui.registerFragments.GetGendersResponseModel
import com.make.deve.pruebacoink.ui.util.BaseUIDataError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InfoRepo(
    private val service: IInfoService,
) : BaseRepo(),
    IInfoRepo {
    override suspend fun getDocTypes(): GetDocTypesResponseModel = withContext(Dispatchers.IO) {
        var res = GetDocTypesResponseModel()

        try {
            val rem = service.getDocTypes()
            if (rem.errorModel == null) {

                res = GetDocTypesResponseModel(
                     rem.items.map {
                        DocItem(
                            description = it.description

                        )
                    }
                )

            } else {
                res.error = errorMapper.map(rem.errorModel)
            }
        } catch (ex: Exception) {
            res.error = BaseUIDataError.getErrorFromException(ex)
        }

        return@withContext res
    }

    override suspend fun getGenders(): GetGendersResponseModel = withContext(Dispatchers.IO) {
        var res = GetGendersResponseModel()

        try {
            val rem = service.getGenders()
            if (rem.errorModel == null) {

                res = GetGendersResponseModel(
                    rem.items.map {
                        GenderItem(
                            name = it.name

                        )
                    }
                )

            } else {
                res.error = errorMapper.map(rem.errorModel)
            }
        } catch (ex: Exception) {
            res.error = BaseUIDataError.getErrorFromException(ex)
        }

        return@withContext res
    }
}