package fastcampus.aop.part4.chapter03.reponse.search

data class SearchPoiInfo(
    val totalCount: String,
    val count: String,
    val page: String,
    val pois: Pois
)