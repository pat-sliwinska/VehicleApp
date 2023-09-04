CREATE TABLE IF NOT EXISTS vehicle_equipment
(
    vehicle_id BIGINT not null,
    equipment_id BIGINT not null,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    created_on timestamp(6) not null default (CURRENT_TIMESTAMP(6)),
    updated_on timestamp(6) not null default (CURRENT_TIMESTAMP(6)),
    FOREIGN KEY(vehicle_id) REFERENCES vehicle(id),
    FOREIGN KEY(equipment_id) REFERENCES equipment(id),
    PRIMARY KEY(vehicle_id, equipment_id)
)