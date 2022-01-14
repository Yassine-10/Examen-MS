package com.dev.coreapi.events

abstract class BaseEvent<T>(

    open val id: T

)

data class RadarCreatedEvent(
    override val id: String,
    val vittesseMax: Double,
    val logitude: String,
    val latitude: String
) : BaseEvent<String>(id)



data class InfractionCreatedEvent(
    override val id: String,
    val numRadar : String,
    val montant: Double,
    val matricule: String,
    val vittesseMax: Double,
    val vittesseVehicule: Double,
) : BaseEvent<String>(id)

