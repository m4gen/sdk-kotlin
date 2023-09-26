package cu.suitetecsa.sdk.nauta.model

import java.util.Date

data class Connection(
    val startSession: Date,
    val endSession: Date,
    val duration: Long,
    val uploaded: Double,
    val downloaded: Double,
    val import: Float
)
