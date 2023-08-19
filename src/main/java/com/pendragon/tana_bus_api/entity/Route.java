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
public class Route {
    private int route_id;
    private String name;
    private String company;
}