INSERT INTO app_user (name, created_by, updated_by)
VALUES
('Filip', 'Admin', 'Admin'),
('Wojtek', 'Admin', 'Admin'),
('Stefan', 'Admin', 'Admin');


INSERT INTO  vehicle (user_id, brand, model, number_of_seats, production_year, top_speed, type, created_by, updated_by)
VALUES
('1', 'Toyota', 'Auris', '5', '2010', '180', 'CAR', 'admin', 'admin'),
('1', 'Porsche', 'Panamera', '4', '2020', '280', 'CAR', 'admin', 'admin'),
('1', 'BMW', 'S1000RR', '1', '2020', '299', 'MOTORCYCLE', 'admin', 'admin'),
('2', 'Toyota', 'Supra', '4', '1998', '180', 'CAR', 'admin', 'admin'),
('2', 'Mercedes', 'E', '5', '2010', '230', 'CAR', 'admin', 'admin'),
('3', 'Kawasaki', 'Z1000', '2', '2018', '250', 'MOTORCYCLE', 'admin', 'admin'),
('3', 'Sailor', 'Star', '15', '2000', '40', 'BOAT', 'admin', 'admin');

INSERT INTO equipment (name, created_by, updated_by)
VALUES
('Airbag', 'Admin', 'Admin'),
('Radio', 'Admin', 'Admin'),
('Air condition', 'Admin', 'Admin'),
('Heated seats', 'Admin', 'Admin'),
('TV', 'Admin', 'Admin'),
('Air suspension', 'Admin', 'Admin'),
('Sport exhaust', 'Admin', 'Admin'),
('Alloy wheels', 'Admin', 'Admin'),
('Twin cab', 'Admin', 'Admin'),
('Quick shifter', 'Admin', 'Admin'),
('Satellite radio', 'Admin', 'Admin'),
('Adaptive dampers', 'Admin', 'Admin'),
('Leather seats', 'Admin', 'Admin'),
('Cup holders', 'Admin', 'Admin');

INSERT INTO vehicle_equipment (vehicle_id, equipment_id)
VALUES
('1', '2'),
('1', '3'),
('1', '1'),
('1', '14'),
('2', '1'),
('2', '2'),
('2', '3'),
('2', '4'),
('2', '6'),
('3', '7'),
('3', '10'),
('3', '12'),
('4', '3'),
('4', '2'),
('4', '8'),
('5', '1'),
('5', '2'),
('5', '3'),
('5', '4'),
('5', '13'),
('6', '7'),
('6', '10'),
('6', '12'),
('7', '9'),
('7', '11');