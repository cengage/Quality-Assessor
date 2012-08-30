package com.qaitdevlabs.qualityassessor.dto;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anujchhabra
 * Date: 28/8/12
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserProfileDTO {
    private String username;
    private String password;
    private String firstName;
    private String middleName;
    private String suffix;
    private String lastName;
    private String city;
    private String state;
    private String zipCode;

    private String address;
   
    private String education;
    private List<String> title;
    private List<String> areaOfExpertise;
    private List<Date> fromDate;
    private List<Date> toDate;
    private List<String> socialSiteName;
    private List<String> socialSiteId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setSity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(List<String> areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    public List<Date> getFromDate() {
        return fromDate;
    }

    public void setFromDate(List<Date> fromDate) {
        this.fromDate = fromDate;
    }

    public List<Date> getToDate() {
        return toDate;
    }

    public void setToDate(List<Date> toDate) {
        this.toDate = toDate;
    }

    public List<String> getSocialSiteName() {
        return socialSiteName;
    }

    public void setSocialSiteName(List<String> socialSiteName) {
        this.socialSiteName = socialSiteName;
    }

    public List<String> getSocialSiteId() {
        return socialSiteId;
    }

    public void setSocialSiteId(List<String> socialSiteId) {
        this.socialSiteId = socialSiteId;
    }
}
