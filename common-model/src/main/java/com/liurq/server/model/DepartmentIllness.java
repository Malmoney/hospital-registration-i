package com.liurq.server.model;

import java.util.Date;

public class DepartmentIllness {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_department_illness.id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_department_illness.department_id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    private String departmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_department_illness.illness_id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    private String illnessId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_department_illness.status
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_department_illness.create_date
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tr_department_illness.update_date
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_department_illness.id
     *
     * @return the value of tr_department_illness.id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_department_illness.id
     *
     * @param id the value for tr_department_illness.id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_department_illness.department_id
     *
     * @return the value of tr_department_illness.department_id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_department_illness.department_id
     *
     * @param departmentId the value for tr_department_illness.department_id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_department_illness.illness_id
     *
     * @return the value of tr_department_illness.illness_id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public String getIllnessId() {
        return illnessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_department_illness.illness_id
     *
     * @param illnessId the value for tr_department_illness.illness_id
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public void setIllnessId(String illnessId) {
        this.illnessId = illnessId == null ? null : illnessId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_department_illness.status
     *
     * @return the value of tr_department_illness.status
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_department_illness.status
     *
     * @param status the value for tr_department_illness.status
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_department_illness.create_date
     *
     * @return the value of tr_department_illness.create_date
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_department_illness.create_date
     *
     * @param createDate the value for tr_department_illness.create_date
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tr_department_illness.update_date
     *
     * @return the value of tr_department_illness.update_date
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tr_department_illness.update_date
     *
     * @param updateDate the value for tr_department_illness.update_date
     *
     * @mbggenerated Mon Feb 15 21:01:31 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}