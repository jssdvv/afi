package com.jssdvv.afi.directory.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.jssdvv.afi.core.data.repository.FirebaseRepositoryImpl

@Composable
fun DirectoryScreen(modifier: Modifier = Modifier) {

    val firebaseRepository = remember { FirebaseRepositoryImpl() }

    val units by firebaseRepository.getUnits().collectAsState(emptyList())
    LazyColumn {
        items(
            items = units
        ) { unit ->
            Row {
                Text(unit.code.toString())
                Text(unit.name)
            }

        }
    }
}