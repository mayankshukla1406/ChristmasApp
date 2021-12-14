package com.example.marvel.christmasapplication.data

import android.util.Log
import com.example.marvel.christmasapplication.domain.model.Item
import com.example.marvel.christmasapplication.domain.repository.ItemRepository
import com.example.marvel.christmasapplication.util.States.*
import com.example.marvel.christmasapplication.util.States
import com.google.firebase.firestore.Query
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ItemRepositoryImplementation @Inject constructor(
    private val query : Query
) :ItemRepository {
    @ExperimentalCoroutinesApi
    override fun getAllItems(): Flow<States<List<Item>>> = callbackFlow {
        val snapshotListener = query.addSnapshotListener { snapshot, e ->
            val response = if (snapshot != null) {
                val items = snapshot.toObjects(Item::class.java)
                Log.d("repository",items.toString())
                Success(items)
            } else {
                Error(e?.message ?: e.toString())
            }
            trySend(response).isSuccess
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}