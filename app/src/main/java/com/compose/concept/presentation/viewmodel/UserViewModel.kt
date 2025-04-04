package com.compose.concept.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.concept.data.local.entity.UserEntity
import com.compose.concept.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val users: StateFlow<List<UserEntity>> = repository.allUsers.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )


    fun insertUser(name: String, email: String) {
        viewModelScope.launch {
            repository.insertUser(UserEntity(name = name, email = email))
        }
    }

    fun clearUsers() {
        viewModelScope.launch {
            repository.deleteAllUsers()
        }
    }


}