package com.cuong.springbootdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private String is_active;

}
