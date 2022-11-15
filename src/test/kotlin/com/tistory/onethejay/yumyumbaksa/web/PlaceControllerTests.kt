package com.tistory.onethejay.yumyumbaksa.web

import org.assertj.core.api.Assertions.assertThat
import org.json.JSONObject
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@SpringBootTest
internal class PlaceControllerTests {

    @Autowired
    lateinit var placeController: PlaceController

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(placeController).build()
    }

    @DisplayName("1. 맛집 등록 테스트")
    @Test
    fun test_1() {
        val jobj: JSONObject = JSONObject()

        jobj.put("placeName", "합정동 라멘맛집")
        jobj.put("placePhone", "021231234")
        jobj.put("placeDetailInfo", "합정동 맛집입니다.")
        jobj.put("serviceYn", "Y")
        jobj.put("useYn", "Y")

        val result: ResultActions = mockMvc.perform(
            post("/api/v1/place/")
                .content(jobj.toString())
                .contentType(MediaType.APPLICATION_JSON)
        )

        //then
        val mvcResult: MvcResult = result.andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andReturn()

        assertThat(mvcResult.response.getContentAsString(Charsets.UTF_8)).contains("합정동")

    }

    @DisplayName("2. 맛집 전체목록 호출 테스트")
    @Test
    fun test_2() {
        //when
        val result: ResultActions = mockMvc.perform(get("/api/v1/place"))

        //then
        val mvcResult: MvcResult = result.andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andReturn()

        assertThat(mvcResult.response.getContentAsString(Charsets.UTF_8)).contains("합정동 라멘맛집")
    }

    @DisplayName("3. 특정 맛집 호출 테스트")
    @Test
    fun test_3() {
        //when
        val idx: String = "1"
        val result: ResultActions = mockMvc.perform(get("/api/v1/place/$idx"))

        //then
        val mvcResult: MvcResult = result.andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andReturn()

        assertThat(mvcResult.response.getContentAsString(Charsets.UTF_8)).contains(idx)
    }



    @DisplayName("4. 맛집 수정 테스트")
    @Test
    fun test_4() {
        val jobj: JSONObject = JSONObject()

        jobj.put("idx", "1")
        jobj.put("placeName", "수정된 합정동 라멘맛집")
        jobj.put("placePhone", "021231234")
        jobj.put("placeDetailInfo", "합정동 맛집입니다.")
        jobj.put("serviceYn", "Y")
        jobj.put("useYn", "Y")

        val result: ResultActions = mockMvc.perform(
            put("/api/v1/place/")
                .content(jobj.toString())
                .contentType(MediaType.APPLICATION_JSON)
        )

        //then
        val mvcResult: MvcResult = result.andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andReturn()

        assertThat(mvcResult.response.getContentAsString(Charsets.UTF_8)).contains("수정된 합정동 라멘맛집")
    }

    @DisplayName("5. 맛집 삭제 테스트")
    @Test
    fun test_5() {
        val result: ResultActions = mockMvc.perform(
            delete("/api/v1/place/1")
        )

        //then
        val mvcResult: MvcResult = result.andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andReturn()

        assertThat(mvcResult.response.getContentAsString(Charsets.UTF_8)).contains("success")
    }
}