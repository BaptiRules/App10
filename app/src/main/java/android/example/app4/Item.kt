package android.example.app4

import java.util.*

data class Item(
        var Deutsch: String = "",
        var Englisch: String = "",
        val textResId: UUID = UUID.randomUUID()
)