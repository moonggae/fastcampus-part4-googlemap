package fastcampus.aop.part4.chapter03.utility

import fastcampus.aop.part4.chapter03.Key
import fastcampus.aop.part4.chapter03.Url
import fastcampus.aop.part4.chapter03.reponse.address.AddressInfoResponse
import fastcampus.aop.part4.chapter03.reponse.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET(Url.GET_TMAP_LOCATION)
    suspend fun getSearchLocation(
        @Header("appKey") appKey: String = Key.TMAP_API,
        @Header("Accept") accept : String = "application/json",
        @Query("version") version: Int = 1,
        @Query("callback") callback: String? = null,
        @Query("count") count: Int = 20,
        @Query("searchKeyword") keyword: String,
        @Query("areaLLCode") areaLLCode: String? = null,
        @Query("areaLMCode") areaLMCode: String? = null,
        @Query("resCoordType") resCoordType: String? = null,
        @Query("searchType") searchType: String? = null,
        @Query("multiPoint") multiPoint: String? = null,
        @Query("searchtypCd") searchtypCd: String? = null,
        @Query("radius") radius: String? = null,
        @Query("reqCoordType") reqCoordType: String? = null,
        @Query("centerLon") centerLon: String? = null,
        @Query("centerLat") centerLat: String? = null
    ): Response<SearchResponse>

    @GET(Url.GET_TMAP_REVERSE_GEO_CODE)
    suspend fun getReverseGeoCode(
        @Header("appKey") appKey: String = Key.TMAP_API,
        @Query("version") version: Int = 1,
        @Query("callback") callback: String? = null,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("coordType") coordType: String? = null,
        @Query("addressType") addressType: String? = null
    ): Response<AddressInfoResponse>
}