package com.pendragon.tana_bus_api.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Stop {
    private int stop_id;
    private String name;
    private double longitude;
    private double latitude;
    private String location_id;
    private int next_stop_id;
}
