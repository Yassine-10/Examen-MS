package org.sid.comptecqrseventsourcing.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateRadarRequestDto {
    private double vitesse_maxiamle;
    private double longitude;
    private double latitude;
}
