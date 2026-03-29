package com.gxhenrique.projetoLinks.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gxhenrique.projetoLinks.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "cannot be null")
	@Size(min = 3, max = 50, message = "minimum 3 characters")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "only letters")
	private String name;

	@NotBlank(message = "cannot be null")
	@Size(min = 3, max = 20, message = "minimum 3 characters")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = " Invalid username ")
	private String username;

	@NotBlank(message = "cannot be null")
	@Email(message = "Invalid email address")
	private String email;

	@NotBlank(message = "cannot be null")
	@Size(min = 6, message = "minimum 6 characters")
	private String password;

	private String bio;

	private String photoUrl;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Link> links = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User() {

	}
	



	public User(Long id, String name, String username, String email, String password, String bio, String photoUrl) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.bio = bio;
		this.photoUrl = photoUrl;
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

	@Override
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

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public List<Link> getLinks() {
		return links;
	}
	
	public UserRole getRole() {
		return role;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}




	public void setRole(UserRole roleAdmin) {
		this.role = roleAdmin;
		
	}




}
