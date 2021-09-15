package com.example.minitp1.model

sealed class SodaObjectForRecycleView() {
    abstract val id: Int
}

data class SodaHeaderSample(
    override val id: Int,
    val header: String
) : SodaObjectForRecycleView()

data class SodaFooterSample(
    override val id: Int,
    val footer: String
) : SodaObjectForRecycleView()


data class SodaPojo(
    override val id: Int,
    val sodaName: String,
    val sodaSugarGramme: Double,
    var isFavorite: Boolean
) : SodaObjectForRecycleView()
