package com.make.deve.pruebacoink.remote.util

import com.make.deve.pruebacoink.remote.errorManager.IRemoteErrorManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

abstract class BaseRetrofitService : KoinComponent {

    protected abstract val contract: Any

    protected val baseUrl: String = "https://api.bancoink.biz"

    protected val errorManager: IRemoteErrorManager by inject()


    protected fun <ContractType> build(
        ctClass: Class<ContractType>
    ): ContractType {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(provideDefaultOkhttpClient())
            .build()
        return retrofit.create(ctClass)
    }

    private fun provideDefaultOkhttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY

        }

        return OkHttpClient.Builder()
            .addInterceptor(
                object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): Response {


                        val requestBuilder = chain.request().newBuilder()


                        requestBuilder.addHeader("Content-Type","application/json")

                        return chain.proceed(requestBuilder.build())
                    }

                }
            )
            .addInterceptor(interceptor)
            .build()
    }


}