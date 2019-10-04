package ng.mathemandy.repository.models

data class BaseMatchITRepositoryModel <DATA> (
    val success: Boolean,
    val data : DATA? = null,
    val message : String? = null
)