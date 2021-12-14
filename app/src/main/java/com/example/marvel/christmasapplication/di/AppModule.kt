package com.example.marvel.christmasapplication.di

import com.example.marvel.christmasapplication.data.ItemRepositoryImplementation
import com.example.marvel.christmasapplication.domain.repository.ItemRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()
    @Singleton
    @Provides
    fun provideItemsRef(db: FirebaseFirestore) = db.collection("items")

    @Singleton
    @Provides
    fun provideItemQuery(itemRef: CollectionReference) = itemRef.orderBy("itemName")

    @Singleton
    @Provides
    fun provideBooksRepository(
        itemsQuery: Query
    ): ItemRepository = ItemRepositoryImplementation(itemsQuery)
}