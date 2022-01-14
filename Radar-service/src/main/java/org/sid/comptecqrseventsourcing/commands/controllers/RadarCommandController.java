package org.sid.comptecqrseventsourcing.commands.controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.comptecqrseventsourcing.commonapi.commands.CreateRadarCommand;
import org.sid.comptecqrseventsourcing.commonapi.dtos.CreateRadarRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/radar")
public class RadarCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    public RadarCommandController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateRadarRequestDto createRadarRequestDto)
    {
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateRadarCommand(
            UUID.randomUUID().toString(),
            createRadarRequestDto.getVitesse_maxiamle(),
            createRadarRequestDto.getLongitude(),
            createRadarRequestDto.getLongitude()
        ));
      return commandResponse;
    }



    @GetMapping("/eventStore/{accountId}")
    public Stream eventStore(@PathVariable String accountId)
    {
       return eventStore.readEvents(accountId).asStream();
    }



     @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception)
     {
         ResponseEntity<String> responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

         return responseEntity;
     }

}
