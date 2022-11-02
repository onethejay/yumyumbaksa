package com.tistory.onethejay.yumyumbaksa.domain.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TB_PLACE")
data class PlaceEntity(
    @Id
    val idx: Long,
    var placeName: String,
    val placePhone: String,
    val placeDetailInfo: String,
    val placePhotoUrl1: String? = null,
    val placePhotoUrl2: String? = null,
    val placePhotoUrl3: String? = null,
    val placePhotoUrl4: String? = null,
    val placePhotoUrl5: String? = null,
    val serviceYn: String,
    val useYn: String,
    @CreatedBy
    val createdBy: String,
    @CreatedDate
    val createdAt: LocalDateTime,
    @LastModifiedBy
    val updatedBy: String? = null,
    @LastModifiedDate
    val updatedAt: LocalDateTime? = null,
)
