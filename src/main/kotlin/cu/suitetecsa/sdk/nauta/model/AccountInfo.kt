package cu.suitetecsa.sdk.nauta.model

import com.google.gson.annotations.SerializedName

data class AccountInfo(
    @SerializedName("access_areas")
    val accessAreas: String,
    @SerializedName("account_status")
    val accountStatus: String,
    @SerializedName("credit")
    val credit: String,
    @SerializedName("expiration_date")
    val expirationDate: String
)
