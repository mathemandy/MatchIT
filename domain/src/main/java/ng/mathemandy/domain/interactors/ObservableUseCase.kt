package ng.mathemandy.domain.interactors

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import ng.mathemandy.domain.utils.RxObservationThread

abstract class ObservableUseCase<in P, R>(
    private val observationThread: RxObservationThread
) {
    private val disposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(param: P?): Observable<R>

    fun executeUseCase(param: P? = null, observer: DisposableObserver<R>) {
        disposable.add(
            buildUseCaseObservable(param).observeOn(observationThread.observerThread).subscribeWith(observer)
        )
    }

    fun executeUseCaseAndPerformAction(param: P? = null, action: (R) -> Unit, errorHandler: (Throwable) -> Unit) {
        disposable.add(
            buildUseCaseObservable(param).doOnError {
                errorHandler.invoke(it)
            }.doOnNext {
                action.invoke(it)
            }.doFinally {
                disposable.dispose()
            }.observeOn(observationThread.observerThread).subscribe()
        )
    }

    fun dispose() = disposable.dispose()
}