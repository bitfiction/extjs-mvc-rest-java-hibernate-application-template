package com.bitfiction.mvctemplate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "OneToManyEntity")
@SequenceGenerator(name="seqOneToManyEntity", initialValue=10, allocationSize=100)
public class OneToManyEntity {
   
   // Avoid org.hibernate.InstantiationException: No default constructor for entity	
   public OneToManyEntity() {
       super();
   }
	
   public OneToManyEntity(String exampleString, Double exampleDouble, Integer exampleInt, Boolean exampleBool, BaseEntity baseEntity) {
		super();
		this.exampleString = exampleString;
		this.exampleDouble = exampleDouble;
		this.exampleInt = exampleInt;
		this.exampleBool = exampleBool;
		this.baseEntity = baseEntity;
   }
   
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqOneToManyEntity")
   @Column(name="id")
   private Long id;

   @Column(name="exampleString")
   private String exampleString;
   
   @Column(name="exampleDouble")
   private Double exampleDouble;
   
   @Column(name="exampleInt")
   private Integer exampleInt;
   
   @Column(name="exampleBool", columnDefinition="boolean default false")  
   private Boolean exampleBool;
   
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumns({
	   @JoinColumn(name="basedentityid", referencedColumnName="id")
   })
   @JsonIgnore
   private BaseEntity baseEntity;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getExampleString() {
		return exampleString;
	}

	public void setExampleString(String exampleString) {
		this.exampleString = exampleString;
	}

	public Double getExampleDouble() {
		return exampleDouble;
	}

	public void setExampleDouble(Double exampleDouble) {
		this.exampleDouble = exampleDouble;
	}

	public Integer getExampleInt() {
		return exampleInt;
	}

	public void setExampleInt(Integer exampleInt) {
		this.exampleInt = exampleInt;
	}

	public Boolean getExampleBool() {
		return exampleBool;
	}

	public void setExampleBool(Boolean exampleBool) {
		this.exampleBool = exampleBool;
	}

	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}
}