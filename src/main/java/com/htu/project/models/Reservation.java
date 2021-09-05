package com.htu.project.models;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="Reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;
	private Date reservationVisitDate;
	private String reservationVisitSlot;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patient_id")
	@JsonIgnore
	private Patients patient;
	
	
	public Patients getPatient() {
		return patient;
	}
	public void setPatient(Patients patient) {
		this.patient = patient;
	}
	public Integer getReservationId() {
		return reservationId;
	}
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	public Date getReservationVisitDate() {
		return reservationVisitDate;
	}
	public void setReservationVisitDate(Date reservationVisitDate) {
		this.reservationVisitDate = reservationVisitDate;
	}
	public String getReservationVisitSlot() {
		return reservationVisitSlot;
	}
	public void setReservationVisitSlot(String reservation_visit_slot) {
		this.reservationVisitSlot = reservation_visit_slot;
	}
	public Reservation(Integer reservationId, Date reservationVisitDate, String reservation_visit_slot,Patients patient) {
		this.reservationId = reservationId;
		this.reservationVisitDate = reservationVisitDate;
		this.reservationVisitSlot = reservation_visit_slot;
		this.patient = patient;
	}
	public Reservation() {
		
	}
	
	
}
