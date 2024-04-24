create database Many_To_Many;
use Many_TO_MANY;

CREATE TABLE Doctor (
    doctor_Id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_Name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100)
 
);


CREATE TABLE Patient (
    patient_Id INT AUTO_INCREMENT PRIMARY KEY,
    patient_Name VARCHAR(100) NOT NULL,
    age INT,
    mobile_Number varchar(25)

);

CREATE TABLE Doctor_Patient (
    doctor_Id INT,
    patient_Id INT,
    PRIMARY KEY (doctor_Id, patient_Id),
    FOREIGN KEY (doctor_Id) REFERENCES Doctor(doctor_Id),
    FOREIGN KEY (patient_Id) REFERENCES Patient(patient_Id)
);

SELECT d.doctor_Id, d.doctor_Name, d.specialization, p.patient_Id, p.patient_Name, p.age, p.mobile_Number
FROM Doctor d
JOIN Doctor_Patient dp ON d.doctor_Id = dp.doctor_Id
JOIN Patient p ON dp.patient_Id = p.patient_Id;

select * from patient;
select * from doctor;
select * from doctor_patient;

UPDATE Patient
SET mobile_Number = '903-4226-153'
WHERE patient_Id = 3;
