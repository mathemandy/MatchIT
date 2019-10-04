package ng.mathemandy.matchit.di.modules.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ng.mathemandy.local.room.MatchITDatabase
import ng.mathemandy.local.utils.MatchITRoomConstants
import ng.mathemandy.matchit.di.scopes.MatchITAppScope

@Module
class MatchITRoomModule {
    @Provides
    @MatchITAppScope
    internal fun provideMatchITDatabase(
        context: Context
    ) = Room.databaseBuilder (
        context,
        MatchITDatabase::class.java,
        MatchITRoomConstants.MATCHIT_ROOM_DATABASE_NAME
    ).apply {
        fallbackToDestructiveMigration()
        allowMainThreadQueries()
    }.build()

    @Provides
    @MatchITAppScope
    internal fun provideMatchITUserDao(
        matchITDatabase: MatchITDatabase
    ) = matchITDatabase.getMatchITUserDao()

}