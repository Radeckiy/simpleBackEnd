package com.jobhunter.simpleBackEnd.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class PotentialEmployees {
    @Id
    private ObjectId _id;
    private String createDate, fullName, aboutYourself, vacancyRequired, contacts;
    private Integer age = 0, desiredWage = 0;

    public PotentialEmployees(ObjectId _id, String createDate, String fullName, String aboutYourself, String vacancyRequired, String contacts, Integer age, Integer desiredWage) {
        this._id = _id;
        this.createDate = createDate;
        this.fullName = fullName;
        this.aboutYourself = aboutYourself;
        this.vacancyRequired = vacancyRequired;
        this.contacts = contacts;
        this.age = age;
        this.desiredWage = desiredWage;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAboutYourself() {
        return aboutYourself;
    }

    public void setAboutYourself(String aboutYourself) {
        this.aboutYourself = aboutYourself;
    }

    public String getVacancyRequired() {
        return vacancyRequired;
    }

    public void setVacancyRequired(String vacancyRequired) {
        this.vacancyRequired = vacancyRequired;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDesiredWage() {
        return desiredWage;
    }

    public void setDesiredWage(Integer desiredWage) {
        this.desiredWage = desiredWage;
    }
}
