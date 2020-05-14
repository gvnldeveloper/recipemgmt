package com.receipe.management.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	@Getter
	@Setter
	private String username;
	@Column
	@JsonIgnore
	@Getter
	@Setter
	private String password;


}