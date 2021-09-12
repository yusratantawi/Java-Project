create table Patients (patient_id serial PRIMARY KEY ,patient_name varchar , patient_Bod date, 
						patient_notes varchar, patient_phone integer ,user_id integer, constraint fk_user_patient foreign key (user_id)  references Users(user_id)); 