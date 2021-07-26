package com.example.kotlinproject.network

import com.example.kotlinproject.datasource.BankDataSource
import com.example.kotlinproject.model.Bank
import com.example.kotlinproject.network.dto.BankList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(@Autowired private val restTemplate: RestTemplate) : BankDataSource {
    override fun retrieveBanks(): Collection<Bank> {
        val forEntity : ResponseEntity<BankList> = restTemplate.getForEntity("http://54.193.31.159/banks")

        return forEntity.body?.results
            ?: throw IOException("Could not fetch results from network")
    }

    override fun retrieveBanks(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNumber: String) {
        TODO("Not yet implemented")
    }


}