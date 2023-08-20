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
public class Location {
    private int location_id;
    private String name;
}
