package com.tistory.onethejay.yumyumbaksa.domain.entity

import org.springframework.data.jpa.repository.JpaRepository

interface PlaceRepository : JpaRepository<PlaceEntity, Long> {

}