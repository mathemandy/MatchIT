package ng.mathemandy.domain.interactors

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import ng.mathemandy.domain.models.BaseDomainModel
import ng.mathemandy.domain.utils.RxObservationThread

abstract class SingleUseCase<in PARAMETER, RETURN : BaseDomainModel<*>>(
    private val observationThread: RxObservationThread
) {
    private val disposable = CompositeDisposable()

    abstract fun buildUseCaseSingle(param: PARAMETER?): Single<RETURN>

    fun executeUseCase(param: PARAMETER?, observer: DisposableSingleObserver<RETURN>) {
        disposable.add(
            buildUseCaseSingle(param).observeOn(observationThread.observerThread).subscribeWith(
                observer
            )
        )
    }

    fun executeUseCaseAndPerformAction(
        param: PARAMETER?,
        action: (RETURN) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        disposable.add(
            buildUseCaseSingle(param).doOnSuccess {
                if (it.success) action.invoke(it)
                else errorHandler.invoke(Throwable(it.message))
            }.observeOn(observationThread.observerThread).subscribe()
        )
    }

    fun dispose() = disposable.dispose()
}