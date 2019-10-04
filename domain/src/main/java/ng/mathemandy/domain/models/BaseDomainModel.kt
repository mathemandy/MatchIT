package ng.mathemandy.domain.models

data class BaseDomainModel <DATA> (
    val success: Boolean,
    val data: DATA? = null,
    val message: String? = null
)