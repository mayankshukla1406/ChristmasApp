package com.example.marvel.christmasapplication.domain.use_cases

import com.example.marvel.christmasapplication.domain.repository.ItemRepository
import javax.inject.Inject

class GetItemUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    operator fun invoke() = repository.getAllItems()
}