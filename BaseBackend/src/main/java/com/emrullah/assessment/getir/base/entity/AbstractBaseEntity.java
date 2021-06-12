package com.emrullah.assessment.getir.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;


/**
 * Base class for document classes.
 *
 * @author Emrullah YILDIRIM
 */
public class AbstractBaseEntity {

    @JsonIgnore
    protected UUID uuid;

    @CreatedDate
    @JsonIgnore
    protected Date cDate;

    @LastModifiedDate
    @JsonIgnore
    protected Date uDate;

    @JsonIgnore
    protected Long uUser;

    @JsonIgnore
    protected Integer isActv;

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
