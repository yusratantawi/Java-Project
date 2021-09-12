create table Reservation (reservation_id serial primary key , reservation_visit_date timestamp ,reservation_visit_slot varchar,patient_id integer,
												constraint fk_reservation_patient foreign key (patient_id)  references  Patients(patient_id) );
