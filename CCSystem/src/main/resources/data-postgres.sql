insert into address (city, country, street) values ('Novi Sad', 'Srbija', 'Velje Veljkovica 23');
insert into address (city, country, street) values ('Novi Sad', 'Srbija', 'Futoski Put 56b');
insert into address (city, country, street) values ('Novi Sad', 'Srbija', 'Dusana radovica 2');
insert into address (city, country, street) values ('Novi Sad', 'Srbija', 'Katarine Grujic 1');

insert into clinical_center (name) values ('Clinical Center of Vojvodina'); --We have, I think, just one clinical center.

insert into clinic (average_mark, name, description, address_id, clinical_center_id) values (0, 'klinika 1', 'Neki opis za kliniku 1', 1, 1);
insert into clinic (average_mark, name, description, address_id, clinical_center_id) values (0, 'klinika 2', 'Neki opis za kliniku 2', 2, 1);

insert into clinic_admin (id, email, name, password, phone, surname, address_id, clinic_id, enabled) values (nextval('cust_seq_user'), 'clinic.admin@gmail.com', 'Nikola', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0653355', 'Plecas', 1, 1, true);

insert into patient (id, email, name, password, phone, surname, blood_type, diopter, height, policyholder, weight, address_id, clinical_center_id, enabled,allergy) values (nextval('cust_seq_user'), 'patient@gmail.com', 'Mira', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '064703', 'Miokovic', 0, 'daljina 0.75', 187, 'zdravstveno osiguranje', 78, 1, 1, true,'polen');

insert into clinical_mark (mark, clinic_id, patient_id) values (0.0, 1, 2);

insert into disease (description, name) values ('Opis bolesti.', 'Migrena');

insert into nurse (id, email, name, password, phone, surname, address_id, clinic_id, enabled) values (nextval('cust_seq_user'), 'nurse@gmail.com', 'Dusica', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '064582', 'Vasic', 1, 1, true);
insert into absence (absence_type, start_date, end_date, user_id) values (1, '2020-04-15 10:00', '2020-04-24 10:00', 1);

insert into doctor (id, email, name, surname, phone, password, average_mark, specialisation, address_id, clinic_id, enabled) values (nextval('cust_seq_user'), 'doctor@gmail.com', 'Dragan', 'Karanovic', '0619785', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 0, 0, 1, 1, true);

insert into clinical_center_admin (id, email, name, password, phone, surname, address_id, clinical_center_id, enabled) values (nextval('cust_seq_user'), 'clinic.center.admin@gmail.com', 'jovan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0614422', 'Plecas', 1, 1, true);

insert into doctor_mark (mark, doctor_id, patient_id) values (0, 4, 2);

-- examinations
insert into examination_type (duration, intervention_type, specialisation) values (20, 0, 0); --id=1
insert into examination_type (duration, intervention_type, specialisation) values (15, 0, 1); --id=2
insert into examination_type (duration, intervention_type, specialisation) values (35, 0, 2); --id=3
insert into examination_type (duration, intervention_type, specialisation) values (25, 0, 3); --id=4
insert into examination_type (duration, intervention_type, specialisation) values (30, 0, 4); --id=5
-- operations
insert into examination_type (duration, intervention_type, specialisation) values (100, 1, 0); --id=6
insert into examination_type (duration, intervention_type, specialisation) values (120, 1, 1); --id=7
insert into examination_type (duration, intervention_type, specialisation) values (240, 1, 2); --id=8
insert into examination_type (duration, intervention_type, specialisation) values (90, 1, 3); --id=9
insert into examination_type (duration, intervention_type, specialisation) values (80, 1, 4); --id=10

-- rooms 
-- clinic id=1
insert into medical_room (intervension_type, room_number, clinic_id) values (1, '111', 1);
insert into medical_room (intervension_type, room_number, clinic_id) values (1, '208a', 1);
insert into medical_room (intervension_type, room_number, clinic_id) values (0, '301b', 1);
insert into medical_room (intervension_type, room_number, clinic_id) values (0, '303c', 1);
insert into medical_room (intervension_type, room_number, clinic_id) values (0, '116', 1);
-- clinic id=2
insert into medical_room (intervension_type, room_number, clinic_id) values (0, '112a', 2);

-- Prices for clinic with id=1
insert into price (price, examination_type_id, clinic_id) values (1250, 1, 1);
insert into price (price, examination_type_id, clinic_id) values (2000, 2, 1);
insert into price (price, examination_type_id, clinic_id) values (1800, 3, 1);
insert into price (price, examination_type_id, clinic_id) values (3500, 4, 1);
insert into price (price, examination_type_id, clinic_id) values (4000, 5, 1);
insert into price (price, examination_type_id, clinic_id) values (1900, 6, 1);
insert into price (price, examination_type_id, clinic_id) values (15000, 7, 1);
insert into price (price, examination_type_id, clinic_id) values (120000, 8, 1);
insert into price (price, examination_type_id, clinic_id) values (85000, 9, 1);
insert into price (price, examination_type_id, clinic_id) values (65000, 10, 1);

insert into examination (date, description, discount, was_on_examination, doctor_id, price_id, medical_room_id, patient_id) values ('2020-04-26 07:00', 'Obican rutinski pregled', 10.0, true,  4, 1, 1, 2);
insert into examination (date, description, discount, was_on_examination, doctor_id, price_id, medical_room_id, patient_id) values ('2020-06-26 07:00', 'Obican rutinski pregled', 10.0, false, 4, 1, 2, null);

insert into medication (description, name) values ('Ovaj lek je za slomljena srca', 'Johnnie Walker');

--INSERT INTO patient_allergy (patient_id, allergy) VALUES (2, 'polen');
--INSERT INTO patient_allergy (patient_id, allergy) VALUES (2, 'ambrozija');

INSERT INTO AUTHORITY (name) VALUES ('ROLE_CLINIC_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_CLINIC_CENTER_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DOCTOR');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_NURSE');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PATIENT');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1); --ROLE_CLINIC_ADMIN
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (5, 2); --ROLE_CLINIC_CENTER_ADMIN
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (4, 3); --ROLE_DOCTOR
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 4); --ROLE_NURSE
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 5); --ROLE_PATIENT