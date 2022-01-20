package com.GyanDaan.entities;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements UserDetails {
	    @Id
		private String email;
		private String password;
		private String phone;
		private String name;
		//private String profile;
		@Transient
		private String role; 
		
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user" )
		@JsonIgnore
		private Set<UserRoles> userRoles = new HashSet<>();
		
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		
		public Set<UserRoles> getUserRoles() {
			return userRoles;
		}
		public void setUserRoles(Set<UserRoles> userRoles) {
			this.userRoles = userRoles;
		}
		public User(String email, String password, String phone, String name) {
			super();
			this.email = email;
			this.password = password;
			this.phone = phone;
			this.name = name;
		}
		public User() {
			super();
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
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "User [email=" + email + ", password=" + password + ", phone=" + phone + ", name=" + name + "]";
		}
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			Set<Authority> set = new HashSet<>();
			this.userRoles.forEach(userRole -> {
				set.add(new Authority(userRole.getRole().getRolename()));
			 });
			
			return set;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return email;
		}
		
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
		
}
