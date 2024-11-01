package com.example.kaspi.model

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val rating: Float,
    val category: String,
    val imageUrl: String
)
