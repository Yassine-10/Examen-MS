package org.sid.comptecqrseventsourcing.commonapi.commands;


import lombok.Getter;

public class CreateRadarCommand extends BaseCommand<String>{

    @Getter private double vitesse_maximale;
    @Getter private double longitude;
    @Getter private double latitude;
    public CreateRadarCommand(String id, double vitesse_maximale, double longitude, double latitude) {
        super(id);
        this.vitesse_maximale = vitesse_maximale;
        this.longitude = longitude;
        this.latitude = latitude;

    }
}
