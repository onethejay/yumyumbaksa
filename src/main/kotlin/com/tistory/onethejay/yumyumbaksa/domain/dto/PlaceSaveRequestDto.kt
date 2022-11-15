package com.tistory.onethejay.yumyumbaksa.domain.dto

import com.tistory.onethejay.yumyumbaksa.domain.entity.PlaceEntity
import java.time.LocalDateTime

data class PlaceSaveRequestDto(
    val idx: Long?,
    var placeName: String,
    val placePhone: String,
    val placeDetailInfo: String? = null,
    val placePhotoUrl1: String? = null,
    val placePhotoUrl2: String? = null,
    val placePhotoUrl3: String? = null,
    val placePhotoUrl4: String? = null,
    val placePhotoUrl5: String? = null,
    val serviceYn: String,
    val useYn: String,
) {
    fun toEntity(): PlaceEntity {
        return PlaceEntity(
            idx = idx,
            placeName = placeName,
            placePhone = placePhone,
            placeDetailInfo = placeDetailInfo,
            placePhotoUrl1 = placePhotoUrl1,
            placePhotoUrl2 = placePhotoUrl2,
            placePhotoUrl3 = placePhotoUrl3,
            placePhotoUrl4 = placePhotoUrl4,
            placePhotoUrl5 = placePhotoUrl5,
            serviceYn = serviceYn,
            useYn = useYn,
            createdBy = "",
            createdAt = LocalDateTime.now()
        )
    }
}