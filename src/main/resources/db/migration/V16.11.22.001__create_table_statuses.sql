CREATE TABLE statuses
(
    uuid          VARCHAR(36)  NOT NULL,
    serial_number VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NOT NULL,
    date          TIMESTAMP,
    status        BOOLEAN DEFAULT false,
    CONSTRAINT pk_statuses PRIMARY KEY (uuid)
);

ALTER TABLE statuses
    ADD CONSTRAINT uc_statuses_name UNIQUE (name);

ALTER TABLE statuses
    ADD CONSTRAINT uc_statuses_serial_number UNIQUE (serial_number);

ALTER TABLE statuses
    ADD CONSTRAINT uc_statuses_uuid UNIQUE (uuid);
