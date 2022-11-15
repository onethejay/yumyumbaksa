package com.tistory.onethejay.yumyumbaksa.domain.dto

data class PlaceSaveResponseDto(
    var idx: Long?,
    var placeName: String,
    var placePhone: String,
    var placeDetailInfo: String?,
    var placePhotoUrl1: String? = null,
    var placePhotoUrl2: String? = null,
    var placePhotoUrl3: String? = null,
    var placePhotoUrl4: String? = null,
    var placePhotoUrl5: String? = null,
    var serviceYn: String,
    var useYn: String,
) {
}