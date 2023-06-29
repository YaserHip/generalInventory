package monster.donjabonoso.generalinventory.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import monster.donjabonoso.generalinventory.domain.repository.RepositoryAuth
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImplRepositoryAuth @Inject constructor(
    private val auth: FirebaseAuth
) : RepositoryAuth {

    override suspend fun signInWithEmail(email: String, password: String): FirebaseUser {
        auth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun signOut(): Boolean {
        TODO("Not yet implemented")
    }
}