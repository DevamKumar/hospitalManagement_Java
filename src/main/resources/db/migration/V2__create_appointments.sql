CREATE TABLE appointments (
    id SERIAL PRIMARY KEY,
    patient_id INT REFERENCES patients_entity(id),
    doctor_id INT REFERENCES doctors_entity(id),
    date DATE NOT NULL,
    time TIME NOT NULL
);