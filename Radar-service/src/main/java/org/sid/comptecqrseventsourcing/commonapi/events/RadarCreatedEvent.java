package org.sid.comptecqrseventsourcing.commonapi.events;

import lombok.Getter;

public class RadarCreatedEvent extends BaseEvent<String>{

    @Getter private double vitesse_maximale;
    @Getter private double longitude;
    @Getter private double latitude;


    public RadarCreatedEvent(String id, double vitesse_maximale, double longitude, double latitude) {
        super(id);
        this.vitesse_maximale = vitesse_maximale;

        this.longitude = longitude;
        this.latitude = latitude;
    }
}
