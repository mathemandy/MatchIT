package ng.mathemandy.remote.utils

import io.reactivex.Observable
import io.reactivex.Single
import ng.mathemandy.remote.base.BaseMatchITRemoteModel

fun <T> Observable<BaseMatchITRemoteModel<T>>.performActionOnError(): Observable<BaseMatchITRemoteModel<T>> {
    return onErrorReturn {
        it.printStackTrace()
        BaseMatchITRemoteModel (
            success = false,
            message = MatchITRemoteExceptionHandler.getErrorFromThrowable(
                throwable = it
            ),
            data = null,
            error = null
        )
    }
}

fun <T> Single<BaseMatchITRemoteModel<T>>.performActionOnError(): Single<BaseMatchITRemoteModel<T>> {
    return toObservable().performActionOnError().singleOrError()
}