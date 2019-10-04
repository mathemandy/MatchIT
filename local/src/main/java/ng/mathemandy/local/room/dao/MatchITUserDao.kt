package ng.mathemandy.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import ng.mathemandy.local.models.authentication.MatchITUserLocalModel


@Dao
interface  MatchITUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(userLocalModel: MatchITUserLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUsers(userLocalModels: List<MatchITUserLocalModel>)

    @Query("SELECT * FROM MATCHIT_USER ")
    fun getUser(): Observable<List<MatchITUserLocalModel>>
}