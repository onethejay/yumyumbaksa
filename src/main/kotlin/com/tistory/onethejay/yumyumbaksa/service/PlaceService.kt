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
    fun getList(): List<PlaceEntity> {
        return placeRepository.findAll()
    }

    //조회된 하나만 가져오기
    fun getOne(idx: Long): PlaceEntity {
        return placeRepository.findById(idx).orElseThrow()
    }

    //데이터 생성
    fun create(placeSaveRequestDto: PlaceSaveRequestDto): PlaceEntity {
        return placeRepository.save(placeSaveRequestDto.toEntity())
    }

    //데이터 수정
    fun update(placeSaveRequestDto: PlaceSaveRequestDto): PlaceEntity {
        return placeRepository.findById(placeSaveRequestDto.idx ?: 0)
            .map {
                it.placeName = placeSaveRequestDto.placeName
                it.placePhone = placeSaveRequestDto.placePhone
                it.placeDetailInfo = placeSaveRequestDto.placeDetailInfo
                it.placePhotoUrl1 = placeSaveRequestDto.placePhotoUrl1
                it.placePhotoUrl2 = placeSaveRequestDto.placePhotoUrl2
                it.placePhotoUrl3 = placeSaveRequestDto.placePhotoUrl3
                it.placePhotoUrl4 = placeSaveRequestDto.placePhotoUrl4
                it.placePhotoUrl5 = placeSaveRequestDto.placePhotoUrl5
                it.serviceYn = placeSaveRequestDto.serviceYn
                it.useYn = placeSaveRequestDto.useYn

                placeRepository.save(it)
            }
            .orElseThrow()
    }

    //데이터 삭제
    fun delete(idx: Long): String {
        placeRepository.findById(idx)
            .map { placeRepository.delete(it) }

        return "success"
    }

}