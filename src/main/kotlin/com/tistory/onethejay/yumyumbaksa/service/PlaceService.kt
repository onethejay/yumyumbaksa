package com.tistory.onethejay.yumyumbaksa.service

import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveResponseDto
import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveRequestDto
import com.tistory.onethejay.yumyumbaksa.domain.entity.PlaceEntity
import com.tistory.onethejay.yumyumbaksa.domain.entity.PlaceRepository
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class PlaceService(
    private val placeRepository: PlaceRepository
) {

    //목록 가져오기
    fun getList(): List<PlaceSaveResponseDto> {
        val placeEntities: List<PlaceEntity> = placeRepository.findAll()

        return placeEntities.stream()
            .map {
                PlaceSaveResponseDto(
                    idx = it.idx,
                    placeName = it.placeName,
                    placePhone = it.placePhone,
                    placeDetailInfo = it.placeDetailInfo,
                    placePhotoUrl1 = it.placePhotoUrl1,
                    placePhotoUrl2 = it.placePhotoUrl2,
                    placePhotoUrl3 = it.placePhotoUrl3,
                    placePhotoUrl4 = it.placePhotoUrl4,
                    placePhotoUrl5 = it.placePhotoUrl5,
                    serviceYn = it.serviceYn,
                    useYn = it.useYn
                )
            }
            .toList()
    }

    //조회된 하나만 가져오기
    fun getOne(idx: Long): PlaceSaveResponseDto {
        val placeEntity: PlaceEntity = placeRepository.findById(idx).orElseThrow()

        return PlaceSaveResponseDto(
            idx = placeEntity.idx,
            placeName = placeEntity.placeName,
            placePhone = placeEntity.placePhone,
            placeDetailInfo = placeEntity.placeDetailInfo,
            placePhotoUrl1 = placeEntity.placePhotoUrl1,
            placePhotoUrl2 = placeEntity.placePhotoUrl2,
            placePhotoUrl3 = placeEntity.placePhotoUrl3,
            placePhotoUrl4 = placeEntity.placePhotoUrl4,
            placePhotoUrl5 = placeEntity.placePhotoUrl5,
            serviceYn = placeEntity.serviceYn,
            useYn = placeEntity.useYn
        )
    }

    //데이터 생성
    fun create(placeSaveRequestDto: PlaceSaveRequestDto): PlaceSaveResponseDto {
        val placeEntity = placeRepository.save(placeSaveRequestDto.toEntity())

        return PlaceSaveResponseDto(
            idx = placeEntity.idx,
            placeName = placeEntity.placeName,
            placeDetailInfo = placeEntity.placeDetailInfo,
            placePhone = placeEntity.placeName,
            placePhotoUrl1 = placeEntity.placePhotoUrl1,
            placePhotoUrl2 = placeEntity.placePhotoUrl2,
            placePhotoUrl3 = placeEntity.placePhotoUrl3,
            placePhotoUrl4 = placeEntity.placePhotoUrl4,
            placePhotoUrl5 = placeEntity.placePhotoUrl5,
            serviceYn = placeEntity.serviceYn,
            useYn = placeEntity.useYn
        )

    }

    //데이터 수정
    fun update(placeSaveRequestDto: PlaceSaveRequestDto): PlaceSaveResponseDto {
        val placeEntity: PlaceEntity = placeRepository.findById(placeSaveRequestDto.idx ?: 0)
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

        return PlaceSaveResponseDto(
            idx = placeEntity.idx,
            placeName = placeEntity.placeName,
            placeDetailInfo = placeEntity.placeDetailInfo,
            placePhone = placeEntity.placePhone,
            placePhotoUrl1 = placeEntity.placePhotoUrl1,
            placePhotoUrl2 = placeEntity.placePhotoUrl2,
            placePhotoUrl3 = placeEntity.placePhotoUrl3,
            placePhotoUrl4 = placeEntity.placePhotoUrl4,
            placePhotoUrl5 = placeEntity.placePhotoUrl5,
            serviceYn = placeEntity.serviceYn,
            useYn = placeEntity.useYn
        )
    }

    //데이터 삭제
    fun delete(idx: Long): String {
        placeRepository.findById(idx)
            .map { placeRepository.delete(it) }

        return "success"
    }

}