package ng.mathemandy.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ng.mathemandy.local.BuildConfig
import ng.mathemandy.local.models.authentication.MatchITUserLocalModel
import ng.mathemandy.local.room.dao.MatchITUserDao


@Database(
    version = BuildConfig.VERSION_CODE,
    entities = [
        MatchITUserLocalModel::class
    ]
)
abstract class MatchITDatabase : RoomDatabase() {
    abstract fun getMatchITUserDao(): MatchITUserDao
}