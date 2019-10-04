package ng.mathemandy.core.utils.state

class MatchITResource <out D> constructor(
    val status: MatchITStatus,
    val message: String? = null,
    val data: D? = null,
    val field: String? = null
){
    companion object {
        @JvmStatic
        fun <D> success(
            data: D,
            message: String? = null
        ): MatchITResource<D> = MatchITResource(
            status = MatchITStatus.SUCCESS,
            data = data,
            message = message
        )

        @JvmStatic
        fun <D> failed(
            message: String?
        ): MatchITResource<D> = MatchITResource(
            status = MatchITStatus.FAILED,
            data = null,
            message = message
        )

        @JvmStatic
        fun <D> validationError(
            message: String? = null,
            field: String?
        ): MatchITResource<D> = MatchITResource(
            status = MatchITStatus.VALIDATION_FAILED,
            message = message,
            field = field
        )

        @JvmStatic
        fun <D> loading(): MatchITResource<D> = MatchITResource(
            status = MatchITStatus.LOADING,
            data = null,
            message = null
        )

        @JvmStatic
        fun <D> loadingMore(): MatchITResource<D> = MatchITResource(
            status = MatchITStatus.LOADING_MORE,
            data = null,
            message = null
        )
    }
}