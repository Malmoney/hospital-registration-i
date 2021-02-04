package com.liurq.server.model;

import java.util.Date;

public class HospitalDepartment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_hospital_department.id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_hospital_department.department_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String departmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_hospital_department.hospital_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String hospitalId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_hospital_department.status
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_hospital_department.create_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_hospital_department.update_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_hospital_department.deleted
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    private String deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_hospital_department.id
     *
     * @return the value of tr_hospital_department.id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_hospital_department.id
     *
     * @param id the value for tr_hospital_department.id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_hospital_department.department_id
     *
     * @return the value of tr_hospital_department.department_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_hospital_department.department_id
     *
     * @param departmentId the value for tr_hospital_department.department_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_hospital_department.hospital_id
     *
     * @return the value of tr_hospital_department.hospital_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getHospitalId() {
        return hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_hospital_department.hospital_id
     *
     * @param hospitalId the value for tr_hospital_department.hospital_id
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_hospital_department.status
     *
     * @return the value of tr_hospital_department.status
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_hospital_department.status
     *
     * @param status the value for tr_hospital_department.status
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_hospital_department.create_date
     *
     * @return the value of tr_hospital_department.create_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_hospital_department.create_date
     *
     * @param createDate the value for tr_hospital_department.create_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_hospital_department.update_date
     *
     * @return the value of tr_hospital_department.update_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_hospital_department.update_date
     *
     * @param updateDate the value for tr_hospital_department.update_date
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_hospital_department.deleted
     *
     * @return the value of tr_hospital_department.deleted
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_hospital_department.deleted
     *
     * @param deleted the value for tr_hospital_department.deleted
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }
}