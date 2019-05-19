package com.example.demo.login.domain.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private int age;
	private boolean marriage;
	private String role;

}
