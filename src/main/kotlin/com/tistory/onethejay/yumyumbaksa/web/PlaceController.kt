package com.tistory.onethejay.yumyumbaksa.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/place")
class PlaceController {

    @GetMapping("")
    fun getPlaceList(): List<HashMap<String, String>> {
        val rtnList: ArrayList<HashMap<String, String>> = ArrayList()
        val rtnMap: HashMap<String, String> = HashMap()
        rtnMap.put("idx", "1")
        rtnMap.put("placeName", "성수동 카레맛집")

        rtnList.add(rtnMap)

        return rtnList
    }

    @GetMapping("/{idx}")
    fun getPlace(@PathVariable idx: String): HashMap<String, String> {
        val rtnMap: HashMap<String, String> = HashMap()

        println("## 입력받은 idx : $idx")

        val placeName: String = when (idx) {
            "11" -> {
                "성수동 카레맛집"
            }
            "12" -> {
                "합정동 라멘맛집"
            }
            else -> {
                "등록된 맛집이 없습니다."
            }
        }

        rtnMap.put("idx", idx)
        rtnMap.put("placeName", placeName)

        return rtnMap
    }

}


