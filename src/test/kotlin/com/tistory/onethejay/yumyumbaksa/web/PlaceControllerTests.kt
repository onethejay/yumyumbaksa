package com.tistory.onethejay.yumyumbaksa.web

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@WebMvcTest
internal class PlaceControllerTests {

    @Autowired
    lateinit var placeController: PlaceController

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(placeController).build()
    }


    @DisplayName("1. 컨트롤러 호출 테스트")
    @Test
    fun test_1(){
        //when
        val result: ResultActions = mockMvc.perform(get("/api/v1/place")
            .contentType(MediaType.APPLICATION_JSON))


        //then
        val mvcResult: MvcResult = result.andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andReturn()

        assertThat(mvcResult.response.getContentAsString(Charsets.UTF_8)).contains("성수동 카레맛집")
    }
}