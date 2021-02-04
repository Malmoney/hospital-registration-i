package com.liurq.server.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public DepartmentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageIsNull() {
            addCriterion("department_image is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageIsNotNull() {
            addCriterion("department_image is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageEqualTo(String value) {
            addCriterion("department_image =", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageNotEqualTo(String value) {
            addCriterion("department_image <>", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageGreaterThan(String value) {
            addCriterion("department_image >", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageGreaterThanOrEqualTo(String value) {
            addCriterion("department_image >=", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageLessThan(String value) {
            addCriterion("department_image <", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageLessThanOrEqualTo(String value) {
            addCriterion("department_image <=", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageLike(String value) {
            addCriterion("department_image like", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageNotLike(String value) {
            addCriterion("department_image not like", value, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageIn(List<String> values) {
            addCriterion("department_image in", values, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageNotIn(List<String> values) {
            addCriterion("department_image not in", values, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageBetween(String value1, String value2) {
            addCriterion("department_image between", value1, value2, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andDepartmentImageNotBetween(String value1, String value2) {
            addCriterion("department_image not between", value1, value2, "departmentImage");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBakCode1IsNull() {
            addCriterion("bak_code1 is null");
            return (Criteria) this;
        }

        public Criteria andBakCode1IsNotNull() {
            addCriterion("bak_code1 is not null");
            return (Criteria) this;
        }

        public Criteria andBakCode1EqualTo(String value) {
            addCriterion("bak_code1 =", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1NotEqualTo(String value) {
            addCriterion("bak_code1 <>", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1GreaterThan(String value) {
            addCriterion("bak_code1 >", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1GreaterThanOrEqualTo(String value) {
            addCriterion("bak_code1 >=", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1LessThan(String value) {
            addCriterion("bak_code1 <", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1LessThanOrEqualTo(String value) {
            addCriterion("bak_code1 <=", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1Like(String value) {
            addCriterion("bak_code1 like", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1NotLike(String value) {
            addCriterion("bak_code1 not like", value, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1In(List<String> values) {
            addCriterion("bak_code1 in", values, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1NotIn(List<String> values) {
            addCriterion("bak_code1 not in", values, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1Between(String value1, String value2) {
            addCriterion("bak_code1 between", value1, value2, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode1NotBetween(String value1, String value2) {
            addCriterion("bak_code1 not between", value1, value2, "bakCode1");
            return (Criteria) this;
        }

        public Criteria andBakCode2IsNull() {
            addCriterion("bak_code2 is null");
            return (Criteria) this;
        }

        public Criteria andBakCode2IsNotNull() {
            addCriterion("bak_code2 is not null");
            return (Criteria) this;
        }

        public Criteria andBakCode2EqualTo(String value) {
            addCriterion("bak_code2 =", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2NotEqualTo(String value) {
            addCriterion("bak_code2 <>", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2GreaterThan(String value) {
            addCriterion("bak_code2 >", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2GreaterThanOrEqualTo(String value) {
            addCriterion("bak_code2 >=", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2LessThan(String value) {
            addCriterion("bak_code2 <", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2LessThanOrEqualTo(String value) {
            addCriterion("bak_code2 <=", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2Like(String value) {
            addCriterion("bak_code2 like", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2NotLike(String value) {
            addCriterion("bak_code2 not like", value, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2In(List<String> values) {
            addCriterion("bak_code2 in", values, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2NotIn(List<String> values) {
            addCriterion("bak_code2 not in", values, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2Between(String value1, String value2) {
            addCriterion("bak_code2 between", value1, value2, "bakCode2");
            return (Criteria) this;
        }

        public Criteria andBakCode2NotBetween(String value1, String value2) {
            addCriterion("bak_code2 not between", value1, value2, "bakCode2");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_department
     *
     * @mbggenerated do_not_delete_during_merge Wed Feb 03 19:23:50 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tb_department
     *
     * @mbggenerated Wed Feb 03 19:23:50 CST 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}