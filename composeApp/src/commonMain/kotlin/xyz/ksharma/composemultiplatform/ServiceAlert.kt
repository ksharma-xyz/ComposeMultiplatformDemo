package xyz.ksharma.composemultiplatform

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class ServiceAlert(
    val heading: String,
    val message: String,
) {

    fun toJsonString() = Json.encodeToString(serializer(), this)

    @Suppress("ConstPropertyName")
    companion object {
        private const val serialVersionUID: Long = 1L

        fun fromJsonString(json: String) =
            kotlin.runCatching { Json.decodeFromString(serializer(), json) }.getOrNull()
    }
}
