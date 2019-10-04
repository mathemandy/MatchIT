package ng.mathemandy.matchit.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import ng.mathemandy.domain.utils.RxObservationThread
import javax.inject.Inject

class MatchITObservationThread @Inject constructor(
): RxObservationThread {

    override val observerThread: Scheduler
        get() = AndroidSchedulers.mainThread()
}