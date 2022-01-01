package com.example.marvel.christmasapplication.presentation.ItemListScreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.christmasapplication.domain.model.Item
import com.example.marvel.christmasapplication.domain.use_cases.GetItemUseCase
import com.example.marvel.christmasapplication.util.States
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val itemUseCase: GetItemUseCase
) :ViewModel(){

    private val _itemState = mutableStateOf<States<List<Item>>>(States.Loading)
    val itemState : State<States<List<Item>>> = _itemState

    init {
        getAllItems()
    }
    private fun getAllItems() {
        viewModelScope.launch {
            itemUseCase.invoke().collect {
                _itemState.value = it
                Log.d("tag",it.toString())
            }
        }
    }
}