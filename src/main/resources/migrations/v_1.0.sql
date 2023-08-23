CREATE DATABASE tana_bus_api_v3;

\c tana_bus_api_v3;

CREATE TABLE location (
    location_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL
);

CREATE TABLE stop (
    stop_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL,
    longitude FLOAT,
    latitude FLOAT,
    location_id INTEGER REFERENCES location (location_id) NOT NULL,
    next_stop_id INTEGER REFERENCES stop (stop_id),
    direction_id INTEGER REFERENCES location (location_id)
);

CREATE TABLE route (
    route_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL,
    "company" VARCHAR(100)
);

CREATE TABLE stop_route (
    stop_route_id SERIAL PRIMARY KEY,
    stop_id INTEGER REFERENCES stop (stop_id),
    route_id INTEGER REFERENCES route (route_id),
);