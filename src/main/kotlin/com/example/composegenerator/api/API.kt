package com.example.composegenerator.api

import com.example.composegenerator.model.entity.figmaui.NodesResponse
import io.reactivex.Single
import org.gradle.model.Path
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface API {

    @GET("v1/files/{key}/nodes")
    fun getRes(
        @Header("X-Figma-Token") token: String,
        @Path("key") key: String,
        @Query("ids") ids: String
    ): Single<NodesResponse>
}