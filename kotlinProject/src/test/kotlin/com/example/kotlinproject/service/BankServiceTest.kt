package com.example.kotlinproject.service

import com.example.kotlinproject.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val dataSoruce : BankDataSource = mockk()
    private val bankService = BankService(dataSoruce)

    @Test
    fun `should call its data source to retrieve banks`() {
        //given
        every { dataSoruce.retrieveBanks() } returns emptyList()

        //when
         bankService.getBanks()

        //then
        verify { dataSoruce.retrieveBanks() }

    }
}