package com.tistory.onethejay.yumyumbaksa.domain.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import javax.transaction.Transactional

@SpringBootTest
internal class PlaceEntityTests {

    @Autowired
    lateinit var placeRepository: PlaceRepository

    @DisplayName("1. TB_PLACE INSERT 테스트")
    @Test
    @Transactional
    fun test_1(){
        val idx: Long = 1L
        val placeEntity: PlaceEntity = PlaceEntity(
            idx = idx,
            placeName = "성수동 카레맛집",
            placePhone = "021231234",
            placeDetailInfo = "성수동 맛집입니다.",
            serviceYn = "Y",
            useYn = "Y",
            createdBy = "ADMIN",
            createdAt = LocalDateTime.now()
        )


        val savedEntity = placeRepository.save(placeEntity)

        assertThat(savedEntity.idx).isEqualTo(idx)
    }
}