package com.example.coincapapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincapapp.firebase.AuthRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _user = MutableStateFlow<FirebaseUser?>(null)
    val user: StateFlow<FirebaseUser?> = _user

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    init {
        checkCurrentUser()
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loading.value = true
            val result = repository.login(email, password)
            _loading.value = false

            result
                .onSuccess { firebaseUser ->
                    _user.value = firebaseUser
                    _error.value = null
                }
                .onFailure { exception ->
                    _user.value = null
                    _error.value = exception.message
                }
        }
    }

    fun logout() {
        repository.logout()
        _user.value = null
    }

    fun checkCurrentUser() {
        _user.value = repository.getCurrentUser()
    }
}