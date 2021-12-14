package com.example.marvel.christmasapplication.domain.repository

import com.example.marvel.christmasapplication.domain.model.Item
import com.example.marvel.christmasapplication.util.States
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getAllItems():Flow<States<List<Item>>>
}