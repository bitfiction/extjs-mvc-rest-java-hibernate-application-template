package com.bitfiction.mvctemplate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@SequenceGenerator(name="seqUser", initialValue=10, allocationSize=100)
public class User implements Serializable {

   // Composite-id class must implement Serializable
   private static final long serialVersionUID = 1L;
   
   // Avoid org.hibernate.InstantiationException: No default constructor for entity	   
   public User() {
	   super();
   }
   
   public User(String username, String password) {
		this(username, password, null, null);
   }
   
   public User(String username, String password,  BaseEntity baseEntity, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.baseEntity = baseEntity;
		this.roles = roles;
   }
   
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUser")
   @Column(name="id")
   private Long id;
   
   @Id
   @Column(name="username", length = 127)
   private String username;
   
   @Column(name="password", length = 127)
   private String password;
   
   @OneToOne(fetch=FetchType.EAGER, optional=true)
   @JoinColumn(name="baseEntityId", referencedColumnName="id")
   private BaseEntity baseEntity;

   @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
   @JoinTable(name="userrole",
              joinColumns={@JoinColumn(referencedColumnName="id"),
		   				   @JoinColumn(referencedColumnName="username")},
              inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
   private Set<Role> roles = new HashSet<Role>();
	
    public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
   
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public boolean hasRole(String rolename) {
		if (this.getRoles() != null) {
			for (Role role: this.getRoles()) {
				if (role.getRolename().equalsIgnoreCase(rolename)) {
					return true;
				}
			}
		}
		return false;
	}

	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}

}