package com.jeongseop.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {
    @Id
    @GeneratedValue
    Long id;
    String uid;
    String password;
    String name;
    String email;
    @CreationTimestamp
    Date regdate;
    @UpdateTimestamp
    Date chgdate;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="uid")
    List<MemberRole> roles;
    
    
    public Member() {}
    public Member(String uid, String password, String name, String email) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
