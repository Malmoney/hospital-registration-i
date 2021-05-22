package com.liurq.server.dao;

import com.liurq.server.model.Doctor;
import com.liurq.server.model.DoctorExample;
import java.util.List;

import com.liurq.server.model.Hospital;
import com.liurq.server.restful.req.hospital.SelectDoctorReq;
import com.liurq.server.restful.req.hospital.SelectVisitDoctorReq;
import com.liurq.server.restful.rsp.hospital.DoctorInfoRsp;
import com.liurq.server.restful.rsp.hospital.SelectDoctorRsp;
import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int countByExample(DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int deleteByExample(DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int deleteByPrimaryKey(String doctorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int insert(Doctor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int insertSelective(Doctor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    List<Doctor> selectByExample(DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    Doctor selectByPrimaryKey(String doctorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int updateByPrimaryKeySelective(Doctor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_doctor
     *
     * @mbggenerated Fri Feb 26 14:46:47 CST 2021
     */
    int updateByPrimaryKey(Doctor record);

    List<SelectDoctorRsp> selectDoctor(SelectDoctorReq req);

    List<SelectDoctorRsp> selectVisitDoctor(SelectVisitDoctorReq req);

    /**
     * 查询
     * @param doctorId
     * @return
     */
    DoctorInfoRsp selectDoctorInfo(String doctorId);


}