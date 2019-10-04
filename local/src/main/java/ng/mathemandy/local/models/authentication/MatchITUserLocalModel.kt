package ng.mathemandy.local.models.authentication

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MATCHIT_USER")
data class MatchITUserLocalModel (
    @PrimaryKey val id: String,
    val username: String?,
    val email: String?

)