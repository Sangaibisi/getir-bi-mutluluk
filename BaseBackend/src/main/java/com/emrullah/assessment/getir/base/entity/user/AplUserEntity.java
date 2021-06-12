package com.emrullah.assessment.getir.base.entity.user;

import com.emrullah.assessment.getir.base.entity.AbstractBaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "APL_USER")
public class AplUserEntity extends AbstractBaseEntity {

    private Long userId;
    private String email;
    private String password;
    private Long userTpId;
    private Long dealerId;

    public AplUserEntity() {
    }

    public AplUserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="USER_ID")
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
            name = "USER_TP_ID"
    )
    public Long getUserTpId() {
        return userTpId;
    }

    public void setUserTpId(Long userTpId) {
        this.userTpId = userTpId;
    }

    @Basic
    @Column(
            name = "DEALER_ID"
    )
    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }
}
