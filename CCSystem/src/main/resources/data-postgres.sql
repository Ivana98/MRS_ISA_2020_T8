insert into adress (city, country, street) values ('Novi Sad', 'Srbija', 'Velje Veljkovica 23');
insert into adress (city, country, street) values ('Novi Sad', 'Srbija', 'Futoski Put 56b');
insert into adress (city, country, street) values ('Novi Sad', 'Srbija', 'Dusana radovica 2');
insert into adress (city, country, street) values ('Novi Sad', 'Srbija', 'Katarine Grujic 1');

insert into clinical_center (name) values ('clinical center Vojvodina'); --We have, I think, just one clinical center.
-- insert into clinical_center (name) values ('clinical center Beograd');
-- insert into clinical_center (name) values ('clinical center Nis');

insert into clinic (average_mark, name, address_id, clinical_center_id) values (0, 'klinika 1', 1, 1);
insert into clinic (average_mark, name, address_id, clinical_center_id) values (0, 'klinika 2', 2, 1);
-- insert into clinic (average_mark, name, address_id, clinical_center_id) values (0, 'klinika 3', 3, 2);

insert into clinic_admin (id, email, name, password, phone, surname, address_id, clinic_id) values (nextval('cust_seq_user'), 'clinic.admin@gmail', 'Nikola', 'sifra1', '0653355', 'Plecas', 1, 1);

insert into clinical_center_admin (email, name, password, phone, surname, address_id, clinical_center_id) values ('clinic.center.admin@gmail', 'jovan', 'sifra1', '0614422', 'Plecas', 1, 1);

insert into patient (id, email, name, password, phone, surname, allergy, blood_type, diopter, height, policyholder, weight, address_id, clinical_center_id) values (nextval('cust_seq_user'), 'patient@gmail', 'Mira', 'sifra1', '064703', 'Miokovic', 'Polen', 0, 'daljina 0.75', 187, 'zdravstveno osiguranje', 78, 1, 1);

insert into clinical_mark (mark, clinic_id, patient_id) values (0.0, 1, 2);

insert into disease (description, name) values ('Opis bolesti.', 'Migrena');

insert into nurse (id, email, name, password, phone, surname, address_id, clinic_id) values (nextval('cust_seq_user'), 'nurse@gmail', 'Dusica', 'sifra1', '064582', 'Vasic', 1, 1);

insert into absence (absence_type, start_date, end_date, user_id) values (1, '2020-04-15 10:00', '2020-04-24 10:00', 1);

insert into doctor (id, email, name, surname, phone, password, average_mark, specialisation, address_id, clinic_id) values (nextval('cust_seq_user'), 'doctor@gmail', 'Dragan', 'Karanovic', '0619785', 'sifra1', 0, 0, 1, 1);

insert into doctor_mark (mark, doctor_id, patient_id) values (0, 4, 2);

insert into examination_type (duration, intervention_type, price, specialisation) values (3, 0, 3000.00, 1);

insert into medical_room (intervension_type, room_number, clinic_id) values (1, '1', 1);

insert into examination (date, description, discount, was_on_examination, doctor_id, examination_type_id, medical_room_id, patient_id) values ('2020-04-26 07:00', 'Obican rutinski pregled', 10.0, true, 4, 1, 1, 2);

insert into examinationing (disease_id, examination_id) values (1, 1);

insert into medication (description, name) values ('Ovaj lek je samo za dusu', 'Johnnie Walker');

insert into prescription (description, expiration_date, quantity, validated, medication_id, nurse_id) values ('Opis recepta', '2020-08-26 23:59', 2, true, 1, 3);

insert into prescriptioning (prescription_id, examination_id) values (1, 1);