package com.tistory.onethejay.yumyumbaksa.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
internal class PlaceServiceTests {
    @Autowired
    lateinit var placeService: PlaceService

    @DisplayName("1. Service 맛집 목록 조회 테스트")
    @Test
    @Transactional
    fun test_1(){
        val placeList = placeService.getPlaceList()
        assertThat(placeList.size).isGreaterThan(0)
    }
}