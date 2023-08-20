CREATE DATABASE tana_bus_api_v2;

\c tana_bus_api_v2;

CREATE TABLE location (
    location_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL
);

CREATE TABLE stop (
    stop_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL,
    longitude FLOAT,
    latitude FLOAT,
    location_id INTEGER NOT NULL,
    next_stop_id INTEGER,
    FOREIGN KEY (next_stop_id) REFERENCES stop (stop_id),
    FOREIGN KEY (location_id) REFERENCES location (location_id)
);

CREATE TABLE route (
    route_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL,
    "company" VARCHAR(100)
);

CREATE TABLE stop_route (
    stop_id INTEGER REFERENCES stop (stop_id),
    route_id INTEGER REFERENCES route (route_id),
    PRIMARY KEY (stop_id, route_id)
);