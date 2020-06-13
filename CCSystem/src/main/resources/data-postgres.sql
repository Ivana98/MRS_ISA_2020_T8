insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Velje Veljkovica 23', false);
insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Futoski Put 56b', false);
insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Dusana radovica 2', false);
insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Katarine Grujic 1', false);

insert into clinical_center (name, deleted) values ('Clinical Center of Vojvodina', false);

insert into clinic (average_mark, name, description, address_id, clinical_center_id, deleted) values (0, 'klinika 1', 'Neki opis za kliniku 1', 1, 1, false);
insert into clinic (average_mark, name, description, address_id, clinical_center_id, deleted) values (0, 'klinika 2', 'Neki opis za kliniku 2', 2, 1, false);

insert into clinic_admin (id, email, name, password, phone, surname, address_id, clinic_id, enabled, is_password_changed, deleted) values (nextval('cust_seq_user'), 'clinic.admin@gmail.com', 'Nikola', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0653355', 'Plecas', 1, 1, true, true, false);

insert into patient (id, email, name, password, phone, surname, blood_type, diopter, height, policyholder, weight, address_id, clinical_center_id, enabled, allergy, deleted) values (nextval('cust_seq_user'), 'patient@gmail.com', 'Mira', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '064703', 'Miokovic', 0, 'daljina 0.75', 187, 'zdravstveno osiguranje', 78, 1, 1, true, 'polen', false);

insert into clinical_mark (mark, clinic_id, patient_id, deleted) values (0.0, 1, 2, false);

insert into disease (description, name, deleted) values ('Opis bolesti.', 'Migrena', false);

insert into nurse (id, email, name, password, phone, surname, address_id, clinic_id, enabled, is_password_changed, deleted) values (nextval('cust_seq_user'), 'nurse@gmail.com', 'Dusica', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '064582', 'Vasic', 1, 1, true, true, false);
insert into absence (absence_type, start_date, end_date, user_id, confirmed, deleted) values (1, '2020-04-15 10:00', '2020-04-24 10:00', 1, null, false);

insert into doctor (id, email, name, surname, phone, password, average_mark, specialisation, address_id, clinic_id, enabled, is_password_changed, deleted) values (nextval('cust_seq_user'), 'doctor@gmail.com', 'Dragan', 'Karanovic', '0619785', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 0, 0, 1, 1, true, false, false);

insert into clinical_center_admin (id, email, name, password, phone, surname, address_id, clinical_center_id, enabled, deleted) values (nextval('cust_seq_user'), 'clinic.center.admin@gmail.com', 'jovan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0614422', 'Plecas', 1, 1, true, false);

insert into doctor_mark (mark, doctor_id, patient_id, deleted) values (0, 4, 2, false);

-- examinations
insert into examination_type (duration, intervention_type, specialisation, deleted) values (20, 0, 0, false); --id=1
insert into examination_type (duration, intervention_type, specialisation, deleted) values (15, 0, 1, false); --id=2
insert into examination_type (duration, intervention_type, specialisation, deleted) values (30, 0, 2, false); --id=3
insert into examination_type (duration, intervention_type, specialisation, deleted) values (25, 0, 3, false); --id=4
insert into examination_type (duration, intervention_type, specialisation, deleted) values (30, 0, 4, false); --id=5
-- operations
insert into examination_type (duration, intervention_type, specialisation, deleted) values (105, 1, 0, false); --id=6
insert into examination_type (duration, intervention_type, specialisation, deleted) values (120, 1, 1, false); --id=7
insert into examination_type (duration, intervention_type, specialisation, deleted) values (240, 1, 2, false); --id=8
insert into examination_type (duration, intervention_type, specialisation, deleted) values (90, 1, 3, false); --id=9
insert into examination_type (duration, intervention_type, specialisation, deleted) values (90, 1, 4, false); --id=10

-- rooms 
-- clinic id=1
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (1, '111', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (1, '208a', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '301b', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '303c', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '116', 1, false);
-- clinic id=2
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '112a', 2, false);

-- Prices for clinic with id=1
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (1250, 0, 1, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (2000, 0, 2, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (1800, 0, 3, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (3500, 0, 4, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (4000, 0, 5, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (1900, 0, 6, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (15000, 0, 7, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (120000, 0, 8, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (85000, 0, 9, 1, false);
insert into price (price, discount, examination_type_id, clinic_id, deleted) values (65000, 0, 10, 1, false);

insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-04-26 07:00', 'Obican rutinski pregled', 1250.0, true,  4, 1, 1, 2, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-06-26 07:00', 'Obican rutinski pregled', 1250.0, false, 4, 1, 2, null, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-06-26 07:05', 'Obican rutinski pregled', 1250.0, false, 4, 1, null, 2, false);

insert into medication (description, name, deleted) values ('Za muskarce, ne i decake...', 'Johnnie Walker', false);

insert into prescription (deleted, description, expiration_date, quantity, validated, medication_id, nurse_id) 
	values (false, 'neki opis za recept', '2020-08-15 23:59', 2, true, 1, 3);

insert into prescriptioning (prescription_id, examination_id) values (1, 1);

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