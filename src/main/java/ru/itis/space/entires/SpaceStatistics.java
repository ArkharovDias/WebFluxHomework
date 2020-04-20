package ru.itis.space.entires;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceStatistics {
    private String name;
    private String spacrShip;
    private String from;
}
