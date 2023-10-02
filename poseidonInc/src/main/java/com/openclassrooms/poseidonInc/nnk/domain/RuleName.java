package com.openclassrooms.poseidonInc.nnk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rulename")
public class RuleName {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
	String name;
	String description;
	String json;
	String template;
	@Column(name="sqlstr")
	String sqlStr;
	@Column(name="sqlpart")
	String sqlPart;
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String str) {
        this.name = str;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String str) {
        this.description = str;
    }
    
    public String getJson() {
        return json;
    }

    public void setJson(String str) {
        this.json = str;
    }
    
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String str) {
        this.template = str;
    }
    
    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String str) {
        this.sqlStr = str;
    }
    
    public String getSqlPart() {
        return sqlPart;
    }

    public void setSqlPart(String str) {
        this.sqlPart = str;
    }
}
