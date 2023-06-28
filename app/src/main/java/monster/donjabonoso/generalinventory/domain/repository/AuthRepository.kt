package monster.donjabonoso.generalinventory.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun signInWithEmail(email:String, password:String): FirebaseUser
    suspend fun signOut(): Boolean
}