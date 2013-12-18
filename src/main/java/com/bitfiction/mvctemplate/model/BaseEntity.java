package com.bitfiction.mvctemplate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "BaseEntity")
@SequenceGenerator(name="seqBaseEntity", initialValue=10, allocationSize=100)
public class BaseEntity {
     
   // Avoid org.hibernate.InstantiationException: No default constructor for entity	
   public BaseEntity() {
	   super();
   }
   
   public BaseEntity(
		   OneToOneEntity oneToOneEntity, 
		   OneToOneEntityEditableByAdmin OneToOneEntityEditableByAdmin) {
		this(oneToOneEntity, OneToOneEntityEditableByAdmin, null);
   }
	
   public BaseEntity(
		   OneToOneEntity oneToOneEntity, 
		   OneToOneEntityEditableByAdmin OneToOneEntityEditableByAdmin, 
		   Set<OneToManyEntity> oneToManyEntities) {
		super();
		this.oneToOneEntity = oneToOneEntity;
		this.OneToOneEntityEditableByAdmin = OneToOneEntityEditableByAdmin;
		this.oneToManyEntities = oneToManyEntities;
   }
   
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqBaseEntity")
   @Column(name="id")
   private Long id;
   
   @OneToOne(fetch=FetchType.EAGER, optional=true)
   @JoinColumn(name="oneToOneEntityId", referencedColumnName="id")
   private OneToOneEntity oneToOneEntity;
   
   @OneToOne(fetch=FetchType.EAGER, optional=true)
   @JoinColumn(name="oneToOneEntityEditableByAdminId", referencedColumnName="id")
   private OneToOneEntityEditableByAdmin OneToOneEntityEditableByAdmin;
   
   @JsonIgnore
   @OneToMany(mappedBy="baseEntity", fetch=FetchType.LAZY)
   private Set<OneToManyEntity> oneToManyEntities = new HashSet<OneToManyEntity>();
	
    public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public OneToOneEntity getOneToOneEntity() {
		return oneToOneEntity;
	}

	public void setOneToOneEntity(OneToOneEntity oneToOneEntity) {
		this.oneToOneEntity = oneToOneEntity;
	}

	public OneToOneEntityEditableByAdmin getOneToOneEntityEditableByAdmin() {
		return OneToOneEntityEditableByAdmin;
	}

	public void setOneToOneEntityEditableByAdmin(
			OneToOneEntityEditableByAdmin OneToOneEntityEditableByAdmin) {
		this.OneToOneEntityEditableByAdmin = OneToOneEntityEditableByAdmin;
	}

	public Set<OneToManyEntity> getOneToManyEntities() {
		return oneToManyEntities;
	}

	public void setOneToManyEntities(Set<OneToManyEntity> oneToManyEntities) {
		this.oneToManyEntities = oneToManyEntities;
	}
   

}