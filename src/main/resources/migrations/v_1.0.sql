-- CREATE DATABASE tana_bus_api_v3;

-- \c tana_bus_api_v3;

CREATE TABLE location (
    location_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL
);

insert into location (location_id, name) values (1, 'Merry');
insert into location (location_id, name) values (2, '7th');
insert into location (location_id, name) values (3, '4th');
insert into location (location_id, name) values (4, 'Carpenter');
insert into location (location_id, name) values (5, 'Fordem');
insert into location (location_id, name) values (6, 'Mcguire');
insert into location (location_id, name) values (7, '5th');
insert into location (location_id, name) values (8, 'Corry');
insert into location (location_id, name) values (9, 'Emmet');
insert into location (location_id, name) values (10, 'Ramsey');
insert into location (location_id, name) values (11, 'Waywood');
insert into location (location_id, name) values (12, 'Grim');
insert into location (location_id, name) values (13, 'Dorton');
insert into location (location_id, name) values (14, 'Sutherland');
insert into location (location_id, name) values (15, 'Fordem');
insert into location (location_id, name) values (16, 'Armistice');
insert into location (location_id, name) values (17, 'Havey');
insert into location (location_id, name) values (18, 'Farragut');
insert into location (location_id, name) values (19, 'Chinook');
insert into location (location_id, name) values (20, 'Lawn');

CREATE TABLE stop (
    stop_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL,
    longitude FLOAT,
    latitude FLOAT,
    location_id INTEGER REFERENCES location (location_id) NOT NULL,
    next_stop_id INTEGER REFERENCES stop (stop_id)
);

insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (1, 'Central Station', 106.9299579, -6.9277361, 17, 1);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (2, 'Maple Avenue', 107.42099, 27.86732, 2, 1);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (3, 'Sunset Boulevard', 15.0797515, 50.9213963, 20, 2);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (4, 'Park Street', 120.6736482, 24.1477358, 15, 3);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (5, 'Main Street', -62.97238, -33.95115, 2, 4);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (6, 'Oakwood Avenue', -74.7088325, -8.7695621, 8, 5);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (7, 'Riverside Drive', -7.5788975, 33.3527276, 11, 6);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (8, 'Pine Street', -87.3388767, 14.7980871, 6, 7);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (9, 'Hillside Avenue', 123.4551696, -10.1508133, 14, 8);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (10, 'Broadway', 110.084789, 34.477861, 15, 9);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (11, 'Elm Street', 25.432447, 36.4166485, 19, 10);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (12, 'Cedar Lane', 118.510616, 32.955581, 4, 11);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (13, 'Washington Avenue', 5.8978018, 43.4945737, 12, 12);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (14, 'Highland Avenue', 124.770152, 8.6427567, 12, 13);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (15, 'Lakeview Drive', 115.16736, -8.665118, 19, 14);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (16, 'Springfield Road', 18.4538421, 44.6254349, 6, 15);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (17, 'Meadow Lane', 16.2948002, 64.918515, 20, 16);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (18, 'Church Street', -8.4873087, 41.4514619, 14, 17);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (19, 'Market Square', 124.4758849, 6.7826022, 15, 18);
insert into stop (stop_id, name, longitude, latitude, location_id, next_stop_id) values (20, 'Victory Lane', 112.5511892, 37.8298386, 4, 19);

CREATE TABLE route (
    route_id SERIAL PRIMARY KEY,
    "name" VARCHAR(300) NOT NULL,
    "company" VARCHAR(100),
    direction_id INTEGER REFERENCES location (location_id)
);


insert into route (route_id, name, company, direction_id) values (1, '102 blue', 'EZAKA', 17);
insert into route (route_id, name, company, direction_id) values (2, '103 green', 'KOFIA', 3);
insert into route (route_id, name, company, direction_id) values (3, '104 red', 'CTE', 6);
insert into route (route_id, name, company, direction_id) values (4, '105 i', 'SOAMIRA', 2);
insert into route (route_id, name, company, direction_id) values (5, '106 a', 'EZAKA', 11);
insert into route (route_id, name, company, direction_id) values (6, '107 b', 'Aingavao', 1);
insert into route (route_id, name, company, direction_id) values (7, '108 blue', 'Miray', 8);
insert into route (route_id, name, company, direction_id) values (8, '109 green', 'EZAKA', 12);
insert into route (route_id, name, company, direction_id) values (9, '110 red', 'Rova', 15);
insert into route (route_id, name, company, direction_id) values (10, '111 i', 'Aingavao', 4);
insert into route (route_id, name, company, direction_id) values (11, '112 a', 'SOAMIRA', 13);
insert into route (route_id, name, company, direction_id) values (12, '113 b', 'CTE', 17);
insert into route (route_id, name, company, direction_id) values (13, '114 blue', 'Rova', 15);
insert into route (route_id, name, company, direction_id) values (14, '115 green', 'Mitsinjo', 9);
insert into route (route_id, name, company, direction_id) values (15, '116 red', 'Ambinintsoa', 9);
insert into route (route_id, name, company, direction_id) values (16, '117 i', 'Miray', 11);
insert into route (route_id, name, company, direction_id) values (17, '118 a', 'Mitsinjo', 18);
insert into route (route_id, name, company, direction_id) values (18, '119 b', 'Mitsinjo', 15);
insert into route (route_id, name, company, direction_id) values (19, '120 blue', 'KOFIA', 16);
insert into route (route_id, name, company, direction_id) values (20, '121 green', 'KOFIA', 13);

CREATE TABLE stop_route (
    stop_route_id SERIAL PRIMARY KEY,
    stop_id INTEGER REFERENCES stop (stop_id),
    route_id INTEGER REFERENCES route (route_id)
);

insert into stop_route (stop_route_id, stop_id, route_id) values (1, 17, 11);
insert into stop_route (stop_route_id, stop_id, route_id) values (2, 17, 17);
insert into stop_route (stop_route_id, stop_id, route_id) values (3, 20, 20);
insert into stop_route (stop_route_id, stop_id, route_id) values (4, 16, 9);
insert into stop_route (stop_route_id, stop_id, route_id) values (5, 3, 7);
insert into stop_route (stop_route_id, stop_id, route_id) values (6, 12, 8);
insert into stop_route (stop_route_id, stop_id, route_id) values (7, 3, 11);
insert into stop_route (stop_route_id, stop_id, route_id) values (8, 5, 2);
insert into stop_route (stop_route_id, stop_id, route_id) values (9, 7, 8);
insert into stop_route (stop_route_id, stop_id, route_id) values (10, 6, 5);
insert into stop_route (stop_route_id, stop_id, route_id) values (11, 6, 20);
insert into stop_route (stop_route_id, stop_id, route_id) values (12, 17, 7);
insert into stop_route (stop_route_id, stop_id, route_id) values (13, 17, 12);
insert into stop_route (stop_route_id, stop_id, route_id) values (14, 20, 13);
insert into stop_route (stop_route_id, stop_id, route_id) values (15, 13, 2);
insert into stop_route (stop_route_id, stop_id, route_id) values (16, 13, 17);
insert into stop_route (stop_route_id, stop_id, route_id) values (17, 10, 1);
insert into stop_route (stop_route_id, stop_id, route_id) values (18, 1, 12);
insert into stop_route (stop_route_id, stop_id, route_id) values (19, 6, 5);
insert into stop_route (stop_route_id, stop_id, route_id) values (20, 11, 3);