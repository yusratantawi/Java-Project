package com.htu.project.models;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name="Patients")
public class Patients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	private String patientName;
	private Integer patientPhone;
	private Date patientBod;
	@OneToOne()
	@JoinColumn(name="user_id" , referencedColumnName="userId")
	private User user;
	
	@OneToMany(mappedBy="patient" , fetch= FetchType.LAZY , cascade = CascadeType.REMOVE )

	private List<Reservation> reservations;
	
	
	@OneToMany(mappedBy="patient" , fetch= FetchType.LAZY , cascade = CascadeType.REMOVE )
	private List<Visits> visits;

	public List<Visits> getVisits() {
		return visits;
	}


	public void setVisits(List<Visits> visits) {
		this.visits = visits;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getPatientId() {
		return patientId;
	}


	public void setPatientId(Integer patient_id) {
		this.patientId = patient_id;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patient_name) {
		this.patientName = patient_name;
	}


	public Integer getPatientPhone() {
		return patientPhone;
	}


	public void setPatientPhone(Integer patient_phone) {
		this.patientPhone = patient_phone;
	}


	public Date getPatientBod() {
		return patientBod;
	}


	public void setPatientBod(Date patient_Bod) {
		this.patientBod = patient_Bod;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}	

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Patients(Integer patient_id, String patient_name, Integer patient_phone, Date patient_Bod,User user ) {
		
		this.patientId = patient_id;
		this.patientName = patient_name;
		this.patientPhone = patient_phone;
		this.patientBod = patient_Bod;
		this.user = user;
	}

	public Patients() {
		
	}


}