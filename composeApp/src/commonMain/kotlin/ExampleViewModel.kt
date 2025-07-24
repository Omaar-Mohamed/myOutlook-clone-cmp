import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExampleViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ExampleUiState())
    val uiState: StateFlow<ExampleUiState> = _uiState.asStateFlow()

    fun updateText(newText: String) {
        _uiState.value = _uiState.value.copy(text = newText)
    }

    fun incrementCounter() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(counter = _uiState.value.counter + 1)
        }
    }

    fun resetCounter() {
        _uiState.value = _uiState.value.copy(counter = 0)
    }
}

data class ExampleUiState(
    val text: String = "Hello ViewModel!",
    val counter: Int = 0,
    val isLoading: Boolean = false
)
