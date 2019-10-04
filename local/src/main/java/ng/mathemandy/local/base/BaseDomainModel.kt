package ng.mathemandy.local.base

data class BaseDomainModel <DATA> (
    val success: Boolean,
    val data: DATA? = null,
    val message: String? = null
)