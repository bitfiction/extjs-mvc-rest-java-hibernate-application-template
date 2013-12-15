package com.bitfiction.mvctemplate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@SequenceGenerator(name="seqRole", initialValue=10, allocationSize=100)
public class Role {
   
   // Avoid org.hibernate.InstantiationException: No default constructor for entity		
   public Role() {
	   super();
   }
   
   public Role(String rolename) {
		super();
		this.rolename = rolename;
   }

   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqRole")
   @Column(name="id")
   private Long id;
   
   @Column(name="rolename", length = 127)
   private String rolename;
   
   @ManyToMany(mappedBy="roles", fetch=FetchType.EAGER)
   private Set<User> users = new HashSet<User>();

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRolename() {
		return rolename;
	}
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}

}