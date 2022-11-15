package com.tistory.onethejay.yumyumbaksa.domain.dto

data class PlaceSaveResponseDto(
    val idx: Long?,
    val placeName: String,
    val placePhone: String,
    val placeDetailInfo: String?,
    val placePhotoUrl1: String? = null,
    val placePhotoUrl2: String? = null,
    val placePhotoUrl3: String? = null,
    val placePhotoUrl4: String? = null,
    val placePhotoUrl5: String? = null,
    val serviceYn: String,
    val useYn: String,
) {
}