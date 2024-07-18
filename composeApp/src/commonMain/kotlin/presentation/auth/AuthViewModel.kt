package presentation.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.repository.OtakuHubRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class AuthViewModel(
    private val repository: OtakuHubRepository
) : ViewModel(), KoinComponent {

    var state by mutableStateOf(AuthUiState())
        private set

    init {

    }

}