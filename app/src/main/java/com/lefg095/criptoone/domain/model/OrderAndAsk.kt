package com.lefg095.criptoone.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class OrderAndAsk (
    @Embedded val order: Order,
    @Relation(
        parentColumn = "book",
        entityColumn = "book"
    )
    val askList: List<Ask> = emptyList()
)