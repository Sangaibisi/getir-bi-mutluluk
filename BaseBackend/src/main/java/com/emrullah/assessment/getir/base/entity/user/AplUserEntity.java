package com.emrullah.assessment.getir.base.entity.user;

import com.emrullah.assessment.getir.base.entity.AbstractBaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "apl_users")
public class AplUserEntity extends AbstractBaseEntity {

    private String email;
    private String password;
    private String name;
    private String surname;

    public AplUserEntity() {
    }

    @PersistenceConstructor
    public AplUserEntity(Long userId, String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

        if (this.email == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }

        AplUserEntity that = (AplUserEntity) obj;

        return this.email.equals(that.getEmail());
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return email == null ? 0 : email.hashCode();
    }
}


