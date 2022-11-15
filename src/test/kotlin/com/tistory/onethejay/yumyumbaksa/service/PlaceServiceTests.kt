package com.tistory.onethejay.yumyumbaksa.service

import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveRequestDto
import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveResponseDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.NoSuchElementException
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

        val placeSaveResponseDto = placeService.getOne(1L)
        assertThat(placeSaveResponseDto.idx).isEqualTo(1L)
    }

    @DisplayName("2. Service 맛집 정보 수정 테스트")
    @Test
    @Transactional
    fun test_2() {
        val placeSaveRequestDto: PlaceSaveRequestDto = PlaceSaveRequestDto(
            idx = 1L,
            placeName = "합정동 라멘맛집22",
            placePhone = "0212345678",
            serviceYn = "Y",
            useYn = "Y"
        )

        val responseDto: PlaceSaveResponseDto = placeService.update(placeSaveRequestDto)

        assertThat(responseDto.placeName).isEqualTo("합정동 라멘맛집22")
        assertThat(responseDto.placePhone).isEqualTo("0212345678")
    }

    @DisplayName("3. Service 맛집 정보 삭제 테스트")
    @Test
    @Transactional
    fun test_3() {
        placeService.delete(1L)

        //삭제된 데이터 조회
        try {
            placeService.getOne(1L)
        } catch (_: NoSuchElementException) {
            println("### 데이터가 없습니다. ###")
        }
    }
}