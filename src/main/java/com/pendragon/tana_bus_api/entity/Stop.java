package com.pendragon.tana_bus_api.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Stop {
    private Integer stop_id;
    @NonNull
    private String name;
    private double longitude;
    private double latitude;
    @NonNull
    private Integer location_id;
    private int next_stop_id;
}
