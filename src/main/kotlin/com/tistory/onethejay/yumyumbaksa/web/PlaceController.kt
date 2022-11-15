package com.tistory.onethejay.yumyumbaksa.web

import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveRequestDto
import com.tistory.onethejay.yumyumbaksa.domain.dto.PlaceSaveResponseDto
import com.tistory.onethejay.yumyumbaksa.service.PlaceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/place")
class PlaceController(
    private val placeService: PlaceService
) {

    @GetMapping("")
    fun getPlaceList(): List<PlaceSaveResponseDto> {

        return placeService.getList()
    }

    @GetMapping("/{idx}")
    fun getPlace(@PathVariable idx: String): PlaceSaveResponseDto {
        println("## 입력받은 idx : $idx")

        return placeService.getOne(idx.toLong())
    }

    @PostMapping("")
    fun insertPlace(@RequestBody placeSaveRequestDto: PlaceSaveRequestDto): PlaceSaveResponseDto {
        return placeService.create(placeSaveRequestDto)
    }

    @PutMapping("")
    fun updatePlace(@RequestBody placeSaveRequestDto: PlaceSaveRequestDto): PlaceSaveResponseDto {
        return placeService.update(placeSaveRequestDto)
    }

    @DeleteMapping("/{idx}")
    fun deletePlace(@PathVariable idx: String): String {
        return placeService.delete(idx.toLong())
    }
}