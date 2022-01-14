package org.sid.comptecqrseventsourcing.commands.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.comptecqrseventsourcing.commonapi.commands.CreateRadarCommand;
import org.sid.comptecqrseventsourcing.commonapi.events.RadarCreatedEvent;

@Aggregate
public class RadarAggregate {
    @AggregateIdentifier
    private String Id;
    private double vitesse_maximale;
    private double longitude;
    private double latitude;

    public RadarAggregate() {
        // required by AXON
    }

    @CommandHandler  
    public RadarAggregate(CreateRadarCommand command) {

        AggregateLifecycle.apply(new RadarCreatedEvent(
            command.getId(),
            command.getVitesse_maximale(),
            command.getLongitude(),
            command.getLongitude()));

    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event) {
       this.Id = event.getId();
       this.vitesse_maximale = event.getVitesse_maximale();
       this.longitude = event.getLongitude();
       this.latitude= event.getLatitude();
    }

}
