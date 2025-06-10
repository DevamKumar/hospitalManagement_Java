CREATE TABLE patient_entity (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    contact VARCHAR(20)
);

CREATE TABLE doctor_entity (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    speciality VARCHAR(255) NOT NULL,
    contact VARCHAR(20)
);

CREATE TABLE appointment_entity (
    id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT REFERENCES patient_entity(id),
    doctor_id BIGINT REFERENCES doctor_entity(id),
    date DATE NOT NULL,
    time TIME NOT NULL
);