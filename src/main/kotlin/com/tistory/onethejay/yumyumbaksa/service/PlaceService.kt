package com.tistory.onethejay.yumyumbaksa.service

import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveRequestDto
import com.tistory.onethejay.yumyumbaksa.domain.entity.PlaceEntity
import com.tistory.onethejay.yumyumbaksa.domain.entity.PlaceRepository
import org.springframework.stereotype.Service

@Service
class PlaceService(
    val placeRepository: PlaceRepository
) {

    //목록 가져오기
    fun getPlaceList(): List<PlaceEntity> {
        return placeRepository.findAll()
    }
    
    //조회된 하나만 가져오기
    fun getPlace(idx: Long): PlaceEntity {
        return placeRepository.findById(idx).orElseThrow()
    }

    //데이터 존재 유무에 따라 INSERT 또는 UPDATE
    fun savePlace(placeSaveRequestDto: PlaceSaveRequestDto) {

    }

    //데이터 삭제
    fun deletePlace() {

    }
    
}