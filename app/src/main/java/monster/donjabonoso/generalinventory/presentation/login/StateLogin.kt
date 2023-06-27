package monster.donjabonoso.generalinventory.presentation.login

data class StateLogin (
    val isLoading: Boolean = false,
    val isSignInSuccessful: Boolean = false,
    val error: String? = null
)