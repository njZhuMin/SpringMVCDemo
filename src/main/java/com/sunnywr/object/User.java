package com.sunnywr.object;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class User {
    private String name;
    private Integer age;

    private ContactInfo contactInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        User user = (User)obj;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .add("contactInfo", contactInfo)
                .toString();
    }
}
