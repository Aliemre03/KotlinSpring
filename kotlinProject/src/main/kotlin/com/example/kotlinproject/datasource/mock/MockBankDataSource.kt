package com.example.kotlinproject.datasource.mock

import com.example.kotlinproject.datasource.BankDataSource
import com.example.kotlinproject.model.Bank
import org.springframework.stereotype.Repository

@Repository
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank("1234", 3.2, 13),
        Bank("1010", 1.67, 0),
        Bank("12", 0.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retrieveBanks(accountNumber: String): Bank = banks.first { it.accountNumber == accountNumber }

    override fun createBank(bank: Bank): Bank {
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not found with given account number: ${bank.accountNumber}")
        banks.remove(currentBank)
        banks.add((bank))
        return bank
    }

    override fun deleteBank(accountNumber: String): Unit {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not found with given account number: ${accountNumber}")

        banks.remove(currentBank)
    }
}