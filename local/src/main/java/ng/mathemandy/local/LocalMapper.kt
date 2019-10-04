package ng.mathemandy.local

/**
 * Created by ayokunlepaul on 2019-07-09
 */
interface LocalMapper<L, R> {

    fun mapFromLocal(local: L): R

    fun mapFromRemote(remote: R): L
}