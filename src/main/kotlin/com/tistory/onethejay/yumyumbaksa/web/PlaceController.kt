package com.tistory.onethejay.yumyumbaksa.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/place")
class PlaceController {

    @GetMapping("")
    fun getPlace(): HashMap<String, String> {
        val rtnMap: HashMap<String, String> = HashMap()
        rtnMap.put("idx", "1")
        rtnMap.put("placeName", "성수동 카레맛집")

        return rtnMap
    }

}


