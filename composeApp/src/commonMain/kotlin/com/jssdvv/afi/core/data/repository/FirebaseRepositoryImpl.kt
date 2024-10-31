package com.jssdvv.afi.core.data.repository

import com.jssdvv.afi.core.domain.model.AcademicUnit
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FirebaseRepositoryImpl {

    private val firestore = Firebase.firestore

    fun getUnits(): Flow<List<AcademicUnit>> {
        return flow {
            firestore.collection("units").snapshots.collect { querySnapshot ->
                val units = querySnapshot.documents.map { documentSnapshot ->
                    documentSnapshot.data<AcademicUnit>()
                }
                emit(units)
            }
        }
    }
}