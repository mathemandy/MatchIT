package ng.mathemandy.domain.utils

import io.reactivex.Scheduler

interface RxObservationThread {
    val observerThread: Scheduler
}