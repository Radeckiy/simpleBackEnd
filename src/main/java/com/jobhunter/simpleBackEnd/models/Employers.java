package com.jobhunter.simpleBackEnd.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Employers {
    @Id
    private ObjectId _id;
    private String createDate, companyName, companyDescription, vacancyRequired, vacancyDescription, contacts;
    private Integer wageMin = 0, wageMax = 0;

    public Employers(ObjectId _id, String createDate, String companyName, String companyDescription, String vacancyRequired, String vacancyDescription, String contacts, Integer wageMin, Integer wageMax) {
        this._id = _id;
        this.createDate = createDate;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.vacancyRequired = vacancyRequired;
        this.vacancyDescription = vacancyDescription;
        this.contacts = contacts;
        this.wageMin = wageMin;
        this.wageMax = wageMax;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getVacancyRequired() {
        return vacancyRequired;
    }

    public void setVacancyRequired(String vacancyRequired) {
        this.vacancyRequired = vacancyRequired;
    }

    public String getVacancyDescription() {
        return vacancyDescription;
    }

    public void setVacancyDescription(String vacancyDescription) {
        this.vacancyDescription = vacancyDescription;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Integer getWageMin() {
        return wageMin;
    }

    public void setWageMin(Integer wageMin) {
        this.wageMin = wageMin;
    }

    public Integer getWageMax() {
        return wageMax;
    }

    public void setWageMax(Integer wageMax) {
        this.wageMax = wageMax;
    }
}
