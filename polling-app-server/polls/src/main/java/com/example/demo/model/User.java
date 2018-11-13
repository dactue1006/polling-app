package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.example.demo.model.audit.DateAudit;


//@UniqueConstraint use for multiple unique key in table.
//So you you can use @Column(unique=true)
@Entity
@Table(name = "users")
public class User extends DateAudit {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 40)
	private String name;
	
	@NotBlank
	@Size(max = 15)
	@Column(unique = true)
	private String username;
	
	@NaturalId
	@Email
	@Size(max = 40)
	@NotBlank
	@Column(unique = true)
	private String email;
	
	@NotBlank
	@Size(max = 50)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
    	@JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
}
