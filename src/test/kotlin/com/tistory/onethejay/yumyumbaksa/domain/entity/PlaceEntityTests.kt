package com.tistory.onethejay.yumyumbaksa.domain.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.util.*
import javax.transaction.Transactional

@SpringBootTest
internal class PlaceEntityTests {

    @Autowired
    lateinit var placeRepository: PlaceRepository

    @BeforeEach
    fun setUp() {
        val placeEntity: PlaceEntity = PlaceEntity(
            idx = 1L,
            placeName = "합정동 라멘맛집",
            placePhone = "021231234",
            placeDetailInfo = "합정동 맛집입니다.",
            serviceYn = "Y",
            useYn = "Y",
            createdBy = "ADMIN",
            createdAt = LocalDateTime.now()
        )

        placeRepository.save(placeEntity)
    }

    @DisplayName("1. TB_PLACE INSERT 테스트")
    @Test
    @Transactional
    fun test_1() {
        val idx: Long = 2L
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

        assertThat(savedEntity.placeName).isEqualTo("성수동 카레맛집")
    }

    @DisplayName("2. TB_PLACE SELECT 테스트")
    @Test
    @Transactional
    fun test_2() {
        //모든 데이터 조회
        val placeEntities: List<PlaceEntity> = placeRepository.findAll()
        assertThat(placeEntities[0].placeName).contains("합정동")

        //특정 ID값으로 조회
        val placeEntity: PlaceEntity = placeRepository.findById(1L).get()
        assertThat(placeEntity.placeName).contains("합정동")
    }

    @DisplayName("3. TB_PLACE UPDATE 테스트")
    @Test
    @Transactional
    fun test_3() {
        //수정할 데이터 조회 후 데이터 변경하여 save
        placeRepository.findById(1L)
            .map {
                it.placeName = "합정동 디저트맛집"
                placeRepository.save(it)
            }

        val updatedEntity: PlaceEntity = placeRepository.findById(1L).get()

        println("변경된 이름 : ${updatedEntity.placeName}")
        assertThat(updatedEntity.placeName).isEqualTo("합정동 디저트맛집")
    }

    @DisplayName("4. TB_PLACE DELETE 테스트")
    @Test
    @Transactional
    fun test_4(){
        //수정할 데이터 조회 후 데이터 삭제
        placeRepository.findById(1L)
            .map {
                placeRepository.delete(it)
            }

        //삭제된 데이터 조회
        try {
            placeRepository.findById(1L).get()
        } catch (_: NoSuchElementException) {
            println("### 데이터가 없습니다. ###")
        }
    }
}