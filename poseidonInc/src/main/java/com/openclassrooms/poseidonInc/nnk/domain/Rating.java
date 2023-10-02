package com.openclassrooms.poseidonInc.nnk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
	@Column(name="moodysrating")
	String moodysRating;
	@Column(name="sandprating")
	String sandPRating;
	@Column(name="fitchrating")
	String fitchRating;
	@Column(name="ordernumber")
	Integer orderNumber;
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getMoodysRating() {
    	return moodysRating;
    }
    
    public void setMoodysRating(String string) {
    	moodysRating = string;
    }
    
    public String getSandPRating() {
    	return sandPRating;
    }
    
    public void setSandPRating(String string) {
    	sandPRating = string;
    }
    
    public String getFitchRating() {
    	return fitchRating;
    }
    public void setFitchRating(String string) {
    	fitchRating = string;
    }
    
    public Integer getOrderNumber() {
    	return orderNumber;
    }
    
    public void setOrderNumber(Integer integer) {
    	orderNumber = integer;
    }
    
    
}
