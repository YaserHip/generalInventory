package monster.donjabonoso.generalinventory.domain.repository

interface AuthRepository {

    suspend fun signInWithEmail(email:String, password:String)
}