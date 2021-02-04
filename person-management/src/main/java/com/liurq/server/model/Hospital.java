package com.liurq.server.model;

import java.util.Date;

public class Hospital {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_name
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_address
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_city
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_country
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalCountry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_province
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalProvince;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_image
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_level
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalLevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_level_name
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalLevelName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_type
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_phone
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.hospital_order_count
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private Long hospitalOrderCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.status
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.create_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.update_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.bak_code1
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String bakCode1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_hospital.bak_code2
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String bakCode2;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_id
     *
     * @return the value of tb_hospital.hospital_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalId() {
        return hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_id
     *
     * @param hospitalId the value for tb_hospital.hospital_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_name
     *
     * @return the value of tb_hospital.hospital_name
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_name
     *
     * @param hospitalName the value for tb_hospital.hospital_name
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_address
     *
     * @return the value of tb_hospital.hospital_address
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalAddress() {
        return hospitalAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_address
     *
     * @param hospitalAddress the value for tb_hospital.hospital_address
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress == null ? null : hospitalAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_city
     *
     * @return the value of tb_hospital.hospital_city
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalCity() {
        return hospitalCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_city
     *
     * @param hospitalCity the value for tb_hospital.hospital_city
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalCity(String hospitalCity) {
        this.hospitalCity = hospitalCity == null ? null : hospitalCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_country
     *
     * @return the value of tb_hospital.hospital_country
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalCountry() {
        return hospitalCountry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_country
     *
     * @param hospitalCountry the value for tb_hospital.hospital_country
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalCountry(String hospitalCountry) {
        this.hospitalCountry = hospitalCountry == null ? null : hospitalCountry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_province
     *
     * @return the value of tb_hospital.hospital_province
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalProvince() {
        return hospitalProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_province
     *
     * @param hospitalProvince the value for tb_hospital.hospital_province
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalProvince(String hospitalProvince) {
        this.hospitalProvince = hospitalProvince == null ? null : hospitalProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_image
     *
     * @return the value of tb_hospital.hospital_image
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalImage() {
        return hospitalImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_image
     *
     * @param hospitalImage the value for tb_hospital.hospital_image
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalImage(String hospitalImage) {
        this.hospitalImage = hospitalImage == null ? null : hospitalImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_level
     *
     * @return the value of tb_hospital.hospital_level
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalLevel() {
        return hospitalLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_level
     *
     * @param hospitalLevel the value for tb_hospital.hospital_level
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalLevel(String hospitalLevel) {
        this.hospitalLevel = hospitalLevel == null ? null : hospitalLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_level_name
     *
     * @return the value of tb_hospital.hospital_level_name
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalLevelName() {
        return hospitalLevelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_level_name
     *
     * @param hospitalLevelName the value for tb_hospital.hospital_level_name
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalLevelName(String hospitalLevelName) {
        this.hospitalLevelName = hospitalLevelName == null ? null : hospitalLevelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_type
     *
     * @return the value of tb_hospital.hospital_type
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalType() {
        return hospitalType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_type
     *
     * @param hospitalType the value for tb_hospital.hospital_type
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalType(String hospitalType) {
        this.hospitalType = hospitalType == null ? null : hospitalType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_phone
     *
     * @return the value of tb_hospital.hospital_phone
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalPhone() {
        return hospitalPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_phone
     *
     * @param hospitalPhone the value for tb_hospital.hospital_phone
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone == null ? null : hospitalPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.hospital_order_count
     *
     * @return the value of tb_hospital.hospital_order_count
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public Long getHospitalOrderCount() {
        return hospitalOrderCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.hospital_order_count
     *
     * @param hospitalOrderCount the value for tb_hospital.hospital_order_count
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalOrderCount(Long hospitalOrderCount) {
        this.hospitalOrderCount = hospitalOrderCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.status
     *
     * @return the value of tb_hospital.status
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.status
     *
     * @param status the value for tb_hospital.status
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.create_date
     *
     * @return the value of tb_hospital.create_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.create_date
     *
     * @param createDate the value for tb_hospital.create_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.update_date
     *
     * @return the value of tb_hospital.update_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.update_date
     *
     * @param updateDate the value for tb_hospital.update_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.bak_code1
     *
     * @return the value of tb_hospital.bak_code1
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getBakCode1() {
        return bakCode1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.bak_code1
     *
     * @param bakCode1 the value for tb_hospital.bak_code1
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setBakCode1(String bakCode1) {
        this.bakCode1 = bakCode1 == null ? null : bakCode1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_hospital.bak_code2
     *
     * @return the value of tb_hospital.bak_code2
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getBakCode2() {
        return bakCode2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_hospital.bak_code2
     *
     * @param bakCode2 the value for tb_hospital.bak_code2
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setBakCode2(String bakCode2) {
        this.bakCode2 = bakCode2 == null ? null : bakCode2.trim();
    }
}