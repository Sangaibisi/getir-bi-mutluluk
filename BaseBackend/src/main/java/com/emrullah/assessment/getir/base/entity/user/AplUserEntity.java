package com.emrullah.assessment.getir.base.entity.user;

import com.emrullah.assessment.getir.base.entity.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "APL_USER")
public class AplUserEntity extends AbstractBaseEntity {

    private Long userId;
    private String email;
    private String password;
    private String name;
    private String surname;

    public AplUserEntity() {
    }

    public AplUserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(
            name = "EMAIL"
    )
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(
            name = "PWD"
    )
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(
            name = "NAME"
    )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(
            name = "SURNAME"
    )
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}


