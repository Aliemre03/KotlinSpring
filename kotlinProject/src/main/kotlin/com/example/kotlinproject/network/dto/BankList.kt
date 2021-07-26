package com.example.kotlinproject.network.dto

import com.example.kotlinproject.model.Bank

data class BankList(
    val results: Collection<Bank>
)
