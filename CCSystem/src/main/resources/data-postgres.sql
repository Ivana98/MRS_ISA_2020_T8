insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Velje Veljkovica 23', false);
insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Futoski Put 56b', false);
insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Dusana radovica 2', false);
insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Katarine Grujic 1', false);
insert into address (city, country, street, deleted) values ('Novi Sad', 'Srbija', 'Katarine Grujic 13', false);

insert into clinical_center (name, deleted) values ('Clinical Center of Vojvodina', false);

insert into clinic (average_mark, name, description, address_id, clinical_center_id, start_time, end_time, deleted) values (3.0, 'klinika 1', 'Neki opis za kliniku 1', 1, 1, 6, 16, false);
insert into clinic (average_mark, name, description, address_id, clinical_center_id, start_time, end_time, deleted) values (0, 'klinika 2', 'Neki opis za kliniku 2', 2, 1, 6, 16, false);

--id 1 2
insert into clinic_admin (id, email, name, password, phone, surname, address_id, clinic_id, enabled, last_password_reset_date, is_password_changed, deleted) values (nextval('cust_seq_user'), 'clinic.admin@gmail.com', 'Nikola', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+06533551', 'Plecas', 1, 1, true, '2017-10-01 21:58:58.508-07', true, false);
insert into clinic_admin (id, email, name, password, phone, surname, address_id, clinic_id, enabled, last_password_reset_date, is_password_changed, deleted) values (nextval('cust_seq_user'), 'clinic.admin2@gmail.com', 'Rade', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+06533552', 'Dusanic', 1, 1, true, '2017-10-01 21:58:58.508-07', true, false);

--id 3 4 5
insert into patient (id, email, name, password, phone, surname, blood_type, diopter, height, policyholder, weight, address_id, clinical_center_id, enabled, last_password_reset_date, allergy, deleted) values (nextval('cust_seq_user'), 'patient1@gmail.com', 'Mira1', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+0647031', 'Miokovic1', 0, 'daljina 0.75', 187, '967894-1', 78, 1, 1, true, '2017-10-01 21:58:58.508-07', 'polen', false);
insert into patient (id, email, name, password, phone, surname, blood_type, diopter, height, policyholder, weight, address_id, clinical_center_id, enabled, last_password_reset_date, allergy, deleted) values (nextval('cust_seq_user'), 'patient2@gmail.com', 'Mira2', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+0647032', 'Miokovic2', 0, 'daljina -0.5', 157, '967894-2', 78, 1, 1, true, '2017-10-01 21:58:58.508-07', 'ambrozija', false);
insert into patient (id, email, name, password, phone, surname, blood_type, diopter, height, policyholder, weight, address_id, clinical_center_id, enabled, last_password_reset_date, allergy, deleted) values (nextval('cust_seq_user'), 'patient3@gmail.com', 'Mira3', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+0647033', 'Miokovic3', 0, 'daljina 1.5', 193, '967894-3', 78, 1, 1, true, '2017-10-01 21:58:58.508-07', 'macija dlaka', false);

insert into clinical_mark (mark, clinic_id, patient_id, deleted) values (2.0, 1, 3, false);
insert into clinical_mark (mark, clinic_id, patient_id, deleted) values (4.0, 1, 4, false);

--id 1 2 3
insert into disease (description, name, deleted) values ('Opis bolesti 1.', 'Migrena', false);
insert into disease (description, name, deleted) values ('Opis bolesti 2.', 'Sizofrenija', false);
insert into disease (description, name, deleted) values ('Opis bolesti 3.', 'Virus', false);

--6
insert into nurse (id, email, name, password, phone, surname, address_id, clinic_id, enabled, last_password_reset_date, is_password_changed, deleted) values (nextval('cust_seq_user'), 'nurse@gmail.com', 'Dusica', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '064582', 'Vasic', 1, 1, true, '2017-10-01 21:58:58.508-07', true, false);

--7 8 9
insert into doctor (id, email, name, surname, phone, password, average_mark, specialisation, address_id, clinic_id, enabled, last_password_reset_date, is_password_changed, deleted) values (nextval('cust_seq_user'), 'doctor@gmail.com', 'Dragan', 'Karanovic', '+06197851', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 2.5, 0, 1, 1, true, '2017-10-01 21:58:58.508-07', false, false);
insert into doctor (id, email, name, surname, phone, password, average_mark, specialisation, address_id, clinic_id, enabled, last_password_reset_date, is_password_changed, deleted) values (nextval('cust_seq_user'), 'doctor2@gmail.com', 'Milos', 'Marosevic', '+06197852', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 0, 1, 1, 1, true, '2017-10-01 21:58:58.508-07', false, false);
insert into doctor (id, email, name, surname, phone, password, average_mark, specialisation, address_id, clinic_id, enabled, last_password_reset_date, is_password_changed, deleted) values (nextval('cust_seq_user'), 'doctor3@gmail.com', 'Veljko', 'Plecas', '+06197853', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 0, 2, 1, 1, true, '2017-10-01 21:58:58.508-07', false, false);

insert into absence (absence_type, start_date, end_date, user_id, confirmed, deleted) values (1, '2020-04-15 10:00', '2020-04-24 10:00', 1, null, false);

--10
insert into clinical_center_admin (id, email, name, password, phone, surname, address_id, clinical_center_id, enabled, last_password_reset_date, deleted) values (nextval('cust_seq_user'), 'clinic.center.admin@gmail.com', 'jovan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '0614422', 'Plecas', 1, 1, true, '2017-10-01 21:58:58.508-07', false);

insert into doctor_mark (mark, doctor_id, patient_id, deleted) values (2, 7, 3, false);
insert into doctor_mark (mark, doctor_id, patient_id, deleted) values (3, 7, 4, false);

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

-- rooms clinic id=1
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (1, '111', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (1, '208a', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '301b', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '303c', 1, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '116', 1, false);
-- rooms clinic id=2
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (0, '112', 2, false);
insert into medical_room (intervension_type, room_number, clinic_id, deleted) values (1, '113', 2, false);

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

insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-04-26 07:00', 'Obican rutinski pregled', 1251.0, true,  7, 1, 1, 3, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-05-13 10:00', 'Obican rutinski pregled', 3002.0, true,  7, 2, 2, 4, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-06-20 08:00', 'Obican rutinski pregled', 2803.0, false,  7, 3, 3, 3, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-07-26 13:00', 'Obican rutinski pregled', 1754.0, false,  7, 4, 2, 5, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-06-28 09:00', 'Obican rutinski pregled', 2105.0, false,  8, 1, 1, 5, false);

-- pregledi koji se zakazuju jednim klikom
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-06-26 07:00', 'Obican rutinski pregled', 1256.0, false, 7, 1, 1, null, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-06-27 11:00', 'Obican rutinski pregled', 2357.0, false, 7, 2, 2, null, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-06-28 15:00', 'Obican rutinski pregled', 3258.0, false, 8, 4, 3, null, false);

-- requested examinations
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-07-12 07:05', 'Obican rutinski pregled', 10001.0, false, 7, 1, null, 3, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-07-13 07:05', 'Obican rutinski pregled', 10002.0, false, 7, 2, null, 4, false);
insert into examination (date, description, static_price, was_on_examination, doctor_id, price_id, medical_room_id, patient_id, deleted) values ('2020-07-14 07:05', 'Obican rutinski pregled', 10003.0, false, 8, 4, null, 5, false);

insert into medication (description, name, deleted) values ('Za glavu', 'Brufen', false);

insert into prescription (deleted, description, expiration_date, quantity, validated, medication_id, nurse_id) 
	values (false, 'neki opis za recept', '2020-08-15 23:59', 2, true, 1, 6);

insert into prescriptioning (prescription_id, examination_id) values (1, 1);

--INSERT INTO patient_allergy (patient_id, allergy) VALUES (2, 'polen');
--INSERT INTO patient_allergy (patient_id, allergy) VALUES (2, 'ambrozija');

INSERT INTO AUTHORITY (name) VALUES ('ROLE_CLINIC_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_CLINIC_CENTER_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_DOCTOR');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_NURSE');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_PATIENT');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1); --ROLE_CLINIC_ADMIN
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1); --ROLE_CLINIC_ADMIN

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (10, 2); --ROLE_CLINIC_CENTER_ADMIN

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (7, 3); --ROLE_DOCTOR
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (8, 3); --ROLE_DOCTOR
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (9, 3); --ROLE_DOCTOR

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (6, 4); --ROLE_NURSE

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 5); --ROLE_PATIENT
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (4, 5); --ROLE_PATIENT
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (5, 5); --ROLE_PATIENT