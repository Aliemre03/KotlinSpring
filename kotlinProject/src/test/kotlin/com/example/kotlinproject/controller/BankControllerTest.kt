package com.example.kotlinproject.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return all banks`() {
        //when/then
        mockMvc.get("/api/banks")
            .andDo { print() }
            .andExpect { status { isOk() } }
    }

    @Test
    fun `should return the bank with the given account number`() {
        //given
        val accountNumber = 1234
        
        //when
        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect { status { isOk() } }
    }

    @Test
    fun `should return NOT found if the account with the given number is not exist`() {
        //given
        val accountNumber = "does_not_exist"

        //when//then
        mockMvc.get("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }
}