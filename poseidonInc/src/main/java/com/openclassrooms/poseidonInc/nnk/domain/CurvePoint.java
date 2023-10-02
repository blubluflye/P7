package com.openclassrooms.poseidonInc.nnk.domain;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
	
	@Column (name="curveid")
	@NotNull(message = "must be not null")
	Integer curveId;
	@Column(name="asofdate")
	Timestamp asOfDate;
	Double term;
	Double value;
	@Column(name="creationdate")
	Timestamp creationDate;
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public Integer getCurveId() {
        return curveId;
    }

    public void setCurveId(Integer id) {
        this.curveId = id;
    }
    
    public Timestamp getAsOfDate() {
    	return asOfDate;
    }
    
    public void setAsOfDate(Timestamp time) {
    	this.asOfDate = time;
    }
    
    public Double getTerm() {
    	return term;
    }
    
    public void setTerm(Double term) {
    	this.term = term;
    }
    
    public Double getValue() {
    	return value;
    }
    
    public void setValue(Double value) {
    	this.value = value;
    }
    
    public Timestamp getCreationDate() {
    	return creationDate;
    }
    
    public void setCreationDate(Timestamp time) {
    	this.creationDate = time;
    }
}
