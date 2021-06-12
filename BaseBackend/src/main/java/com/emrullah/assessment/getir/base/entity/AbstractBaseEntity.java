package com.emrullah.assessment.getir.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class AbstractBaseEntity {

    @Transient
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Column(name = "UUID", unique = true)
    protected UUID uuid;

    @Column(name = "CDATE", nullable = false, updatable = false)
    @CreatedDate
    @JsonIgnore
    protected Date cDate;

    @Column(name = "UDATE")
    @LastModifiedDate
    @JsonIgnore
    protected Date uDate;

    @Column(name = "UUser")
    @JsonIgnore
    protected Long uUser;

    @Column(name = "IS_ACTV")
    @JsonIgnore
    protected Integer isActv;

    @PrePersist
    public void onPrePersist() {
        this.isActv = 1;
        this.cDate=new Date();
        this.uuid=UUID.randomUUID();
    }

    @PreUpdate
    public void onUpdate(){
        this.uDate= new Date();
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractBaseEntity)) {
            return false;
        }
        AbstractBaseEntity other = (AbstractBaseEntity) obj;
        return getUuid().equals(other.getUuid());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Date getuDate() {
        return uDate;
    }

    public void setuDate(Date uDate) {
        this.uDate = uDate;
    }

    public Long getuUser() {
        return uUser;
    }

    public void setuUser(Long uUser) {
        this.uUser = uUser;
    }

    public Integer getIsActv() {
        return isActv;
    }

    public void setIsActv(Integer isActv) {
        this.isActv = isActv;
    }
}
