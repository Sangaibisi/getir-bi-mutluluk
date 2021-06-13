package com.emrullah.assessment.getir.base.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.*;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;


/**
 * Base class for document classes.
 *
 * @author Emrullah YILDIRIM
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractDocument {

    @Id
    private BigInteger id;

    @CreatedBy
    private String uuser;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedBy
    private String lastModifiedUser;

    @LastModifiedDate
    private Instant lastModifiedDate;

    /**
     * Returns the identifier of the document.
     *
     * @return the id
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Returns the creation date of the document.
     *
     * @return the date
     */
    public String getUuser() {
        return uuser;
    }

    /**
     * Returns the creation date of the document.
     *
     * @return the date
     */
    public Instant getCreatedDate() {
        return createdDate;
    }

    /**
     * Returns the last modification user of the document.
     *
     * @return the date
     */
    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    /**
     * Returns the last modification date of the document.
     *
     * @return the date
     */
    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        AbstractDocument that = (AbstractDocument) obj;

        return this.id.equals(that.getId());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}