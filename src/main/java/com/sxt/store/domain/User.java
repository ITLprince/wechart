package com.sxt.store.domain;

import com.sxt.store.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer uid;
    private String uname;
    private String openid;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
