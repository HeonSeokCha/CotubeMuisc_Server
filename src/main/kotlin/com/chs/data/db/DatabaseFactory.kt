package com.chs.data.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {

    fun init() {
        Database.connect(hikari())
    }

    private fun hikari() : HikariDataSource {
        val sqlId = System.getenv("SQL_ID")
        val sqlPw = System.getenv("SQL_PW")
        val config = HikariConfig().apply {
            this.driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
            this.jdbcUrl = "jdbc:sqlserver://localhost;database=Compose_music;user=$sqlId;password=$sqlPw"
            this.maximumPoolSize = 3
            this.isAutoCommit = false
            this.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            this.validate()
        }
        return HikariDataSource(config)
    }
}