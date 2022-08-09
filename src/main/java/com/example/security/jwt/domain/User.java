package com.example.security.jwt.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;


@Entity @NoArgsConstructor @AllArgsConstructor @Data
@Table(name="USERS")
public class User{

    @Id @GeneratedValue(strategy = AUTO)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column
    private String company;

    @Column
    private String position;

    @ManyToMany(fetch = EAGER)
    private List<Role> roles = new ArrayList<>();
}