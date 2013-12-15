package com.bitfiction.mvctemplate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OneToOneEntity")
@SequenceGenerator(name="seqOneToOneEntity", initialValue=10, allocationSize=100)
public class OneToOneEntity {
   
   // Avoid org.hibernate.InstantiationException: No default constructor for entity	
   public OneToOneEntity() {
	   super();
   }
	
   public OneToOneEntity(String exampleString) {
	   super();
	   this.exampleString = exampleString;
   }

   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqOneToOneEntity")
   @Column(name="id")
   private Long id;
   
   @Column(name="exampleString")
   private String exampleString;
   
   
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

}