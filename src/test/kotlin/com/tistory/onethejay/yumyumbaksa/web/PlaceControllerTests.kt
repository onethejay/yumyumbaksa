package com.tistory.onethejay.yumyumbaksa.web

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest
internal class PlaceControllerTests {

    @Autowired
    lateinit var placeController: PlaceController

    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(placeController).build()
    }


    @DisplayName("1. 컨트롤러 호출 테스트")
    @Test
    fun test_1(){
        //when
        val result: ResultActions = mockMvc.perform(get("/api/v1/place"))

        //then
        val mvcResult: MvcResult = result.andExpect(status().isOk)
            .andReturn()

        assertThat(mvcResult.response.contentAsString).contains("성수동 카레맛집")
    }
}