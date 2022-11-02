package com.tistory.onethejay.yumyumbaksa.domain.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_PLACE")
data class PlaceEntity(
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idx: Long?,
    var placeName: String,
    var placePhone: String,
    var placeDetailInfo: String,
    var placePhotoUrl1: String? = null,
    var placePhotoUrl2: String? = null,
    var placePhotoUrl3: String? = null,
    var placePhotoUrl4: String? = null,
    var placePhotoUrl5: String? = null,
    var serviceYn: String,
    var useYn: String,
    @CreatedBy
    val createdBy: String,
    @CreatedDate
    val createdAt: LocalDateTime,
    @LastModifiedBy
    val updatedBy: String? = null,
    @LastModifiedDate
    val updatedAt: LocalDateTime? = null,
)
