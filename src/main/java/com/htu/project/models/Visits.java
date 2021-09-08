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


@Entity(name="Visits")
public class Visits {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer visitId;
	private Date visitDate;
	private String visitReasons;
	private String visitDiagnosis;
	private String visitNotes;
	
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
	public Integer getVisitId() {
		return visitId;
	}
	public void setVisitId(Integer visit_id) {
		this.visitId = visit_id;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visit_date) {
		this.visitDate = visit_date;
	}
	public String getVisitReasons() {
		return visitReasons;
	}
	public void setVisitReasons(String visit_reasons) {
		this.visitReasons = visit_reasons;
	}
	public String getVisitDiagnosis() {
		return visitDiagnosis;
	}
	public void setVisitDiagnosis(String visit_diagnosis) {
		this.visitDiagnosis = visit_diagnosis;
	}
	public String getVisitNotes() {
		return visitNotes;
	}
	public void setVisitNotes(String visit_notes) {
		this.visitNotes = visit_notes;
	}
	public Visits(Integer visit_id, Date visit_date, String visit_reasons, String visit_diagnosis, String visit_notes) {
		super();
		this.visitId = visit_id;
		this.visitDate = visit_date;
		this.visitReasons = visit_reasons;
		this.visitDiagnosis = visit_diagnosis;
		this.visitNotes = visit_notes;
	}
	public Visits() {

	}







}