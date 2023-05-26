package com.example.composegenerator.di.modules

import com.example.composegenerator.api.API
import org.kodein.di.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = DI.Module {
    constant("baseUrl") with "https://api.figma.com/"

    bind<Gson>() with singleton { GsonBuilder().create() }
    bind<OkHttpClient>() with singleton {
        OkHttpClient.Builder()
            .addInterceptor(instance())
            .build()
    }
    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .client(instance())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(instance()))
            .baseUrl(instance<String>("baseUrl"))
            .build()
    }
    bind<API>() with singleton { instance<Retrofit>().create(API::class.java) }
}