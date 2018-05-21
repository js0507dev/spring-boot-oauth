package com.jeongseop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MemberRole {
	@Id
	@GeneratedValue
	Long rid;
	String rolename;
	
	public MemberRole() {}
	public MemberRole(String rolename) {
		this.rolename = rolename;
	}
}
