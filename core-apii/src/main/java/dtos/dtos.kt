package com.dev.coreapi.dtos

data class RadarRequestDto(
    var vittesseMax: Double = 0.0,
    var logitude: String = "",
    var latitude: String=""


)

data class InfractionRequestDto(

    var numRadar : String="",
    var montant: Double=0.0,
    var matricule: String="",
    var vittesseMax: Double=0.0,
    var vittesseVehicule: Double=0.0,
)
