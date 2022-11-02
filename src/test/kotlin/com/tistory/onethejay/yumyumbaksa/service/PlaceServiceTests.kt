package com.tistory.onethejay.yumyumbaksa.service

import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveRequestDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
internal class PlaceServiceTests {
    @Autowired
    lateinit var placeService: PlaceService

    @BeforeEach
    fun setUp() {
        val requestDto = PlaceSaveRequestDto(
            idx = 1L,
            placeName = "합정동 라멘맛집",
            placePhone = "021231234",
            placeDetailInfo = "합정동 맛집입니다.",
            serviceYn = "Y",
            useYn = "Y",
        )

        placeService.create(requestDto)
    }

    @DisplayName("1. Service 맛집 목록 조회 테스트")
    @Test
    @Transactional
    fun test_1() {
        val placeList = placeService.getList()
        assertThat(placeList.size).isGreaterThan(0)
        assertThat(placeList[placeList.size - 1].placeName).isEqualTo("합정동 라멘맛집")
    }
}