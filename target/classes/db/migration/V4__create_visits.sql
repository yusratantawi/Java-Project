create table Visits(visit_id serial primary key , visit_date timestamp ,visit_reasons varchar ,
						visit_diagnosis varchar , visit_notes varchar,patient_id integer,
						constraint fk_visits_patient foreign key (patient_id)  references  Patients(patient_id));