package com.liurq.server.dao;

import com.liurq.server.model.Hospital;
import com.liurq.server.model.HospitalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int countByExample(HospitalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int deleteByExample(HospitalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int deleteByPrimaryKey(String hospitalId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int insert(Hospital record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int insertSelective(Hospital record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    List<Hospital> selectByExampleWithBLOBs(HospitalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    List<Hospital> selectByExample(HospitalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    Hospital selectByPrimaryKey(String hospitalId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int updateByExampleSelective(@Param("record") Hospital record, @Param("example") HospitalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") Hospital record, @Param("example") HospitalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int updateByExample(@Param("record") Hospital record, @Param("example") HospitalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int updateByPrimaryKeySelective(Hospital record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(Hospital record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_hospital
     *
     * @mbggenerated Wed Feb 03 19:34:01 CST 2021
     */
    int updateByPrimaryKey(Hospital record);
}