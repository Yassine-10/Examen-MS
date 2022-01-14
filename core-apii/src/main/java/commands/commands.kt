package com.dev.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
    @TargetAggregateIdentifier
    open val id: T

)
data class CreateRadarCommand(
    override val id: String,
    val vittesseMax: Double,
    val logitude: String,
    val latitude: String
) : BaseCommand<String>(id)

data class UpdateRadarCommand(
    override val id: String,
    val name: String,
    val email: String
) : BaseCommand<String>(id)

data class CreateInfractionCommand(
    override val id: String,
    val numRadar : String,
    val montant: Double,
    val matricule: String,
    val vittesseMax: Double,
    val vittesseVehicule: Double,
) : BaseCommand<String>(id)



