package com.liurq.server.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liurq.server.dao.DepartmentMapper;
import com.liurq.server.dao.HospitalDepartmentMapper;
import com.liurq.server.dao.HospitalMapper;
import com.liurq.server.model.*;
import com.liurq.server.restful.req.hospital.MajorDepartmentReq;
import com.liurq.server.restful.req.hospital.ModifyHospitalInfoReq;
import com.liurq.server.restful.req.hospital.SelectHospitalByDepartmentReq;
import com.liurq.server.restful.req.hospital.SelectHospitalReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.SelectHospitalRsp;
import com.liurq.server.service.HospitalService;
import com.liurq.util.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-02-13
 * @Desc:
 **/
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;
    @Autowired
    private HospitalDepartmentMapper hospitalDepartmentMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 根据条件查询医院信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<PageInfo<Hospital>> selectHospital(SelectHospitalReq req) {
        String city = req.getCity();
        String hospitalName =req.getHospitalName();
        HospitalExample example = new HospitalExample();
        HospitalExample.Criteria criteria = example.createCriteria();
        //根据城市
        if(!StringUtils.isBlank(city)){
            criteria.andHospitalCityEqualTo(city.trim());
        }
        //根据名称
        if(!StringUtils.isBlank(hospitalName)){
            criteria.andHospitalNameLike("%"+hospitalName.trim()+"%");
        }
        criteria.andParentIdEqualTo("0");
        criteria.andStatusEqualTo("0");
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Hospital> result = hospitalMapper.selectByExample(example);
        if (ObjectUtils.isEmpty(result)){
            result = new ArrayList<>();
        }
        PageInfo<Hospital> pageInfo = new PageInfo<>(result);
        return RspInfo.success(pageInfo);
    }

    /**
     * 根据科室和城市查询医院
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<PageInfo<SelectHospitalRsp>> selectHospitalByDepartment(SelectHospitalByDepartmentReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<SelectHospitalRsp> result = this.hospitalMapper.selectHospitalByDepartment(req);

        if (result == null){
            result = new ArrayList<>();
        }
        PageInfo<SelectHospitalRsp> pageInfo = new PageInfo<>(result);
        return new RspInfo<>(pageInfo);
    }

    /**
     * 注册医院信息
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<String> modifyHospitalInfo(ModifyHospitalInfoReq req) {
        Date now = new Date();
        //保存医院信息
        Hospital hospital = new Hospital();
        hospital.setHospitalId(req.getHospitalId());
        hospital.setHospitalAddress(req.getAddress());
        hospital.setHospitalCity(req.getCity());
        hospital.setHospitalProvince(req.getProvince());
        hospital.setHospitalImage(req.getImage());
        hospital.setHospitalPhone(req.getHospitalPhone());
        hospital.setStatus("0");
        hospital.setCreateDate(now);
        hospital.setUpdateDate(now);
        hospital.setLongitude(req.getLongitude());
        hospital.setLatitude(req.getLatitude());
        hospital.setRemark(req.getRemark());
        hospitalMapper.updateByPrimaryKeySelective(hospital);
        return RspInfo.success("成功");
    }

    /**
     * 更新医院的科室信息
     * @param newDepart
     * @param hospitalId
     * @return
     */
    @Override
    public RspInfo<String> updateHospitalDepartment(List<Department> newDepart, String hospitalId){
        //查询旧关联信息
        List<Department> oldDepart = departmentMapper.selectByHospitalId(hospitalId);
        //旧的为空，新增所有新的
        if (ObjectUtils.isEmpty(oldDepart)){
            this.saveHospitalDepartment(newDepart,hospitalId);
            return RspInfo.success("成功");
        }
        //新的为空，删除所有旧的
        if (ObjectUtils.isEmpty(newDepart)){
            HashMap<String, Object> param = new HashMap<>();
            param.put("list",oldDepart);
            param.put("hospitalId",hospitalId);
            this.hospitalDepartmentMapper.deleteAllHospitalDepartment(param);
            return RspInfo.success("成功");
        }

        //遍历比对不同项
        ArrayList<Department> removeFlag = new ArrayList<>();
        for(Department department:newDepart ){
//            for (int i =0; i< oldDepart.size();i++){
            for (Department old:oldDepart){
                if (department.getDepartmentId().equals(old.getDepartmentId())){
                    removeFlag.add(old);
                    oldDepart.remove(old);
                    break;
                }
            }
        }

        //删除原有不动的数据
        if (!ObjectUtils.isEmpty(removeFlag)){
            newDepart.removeAll(removeFlag);
        }
        //保存新增的数据
        this.saveHospitalDepartment(newDepart, hospitalId);
        //删除旧的数据
        if (!ObjectUtils.isEmpty(oldDepart)){
            HashMap<String, Object> param = new HashMap<>();
            param.put("list",oldDepart);
            param.put("hospitalId",hospitalId);
            this.hospitalDepartmentMapper.deleteAllHospitalDepartment(param);
        }

        return RspInfo.success("成功");
    }

    /**
     * 新增医院主攻科室
     *
     * @param req
     * @param status
     * @return
     */
    @Override
    public RspInfo<String> updateMajorDepartment(MajorDepartmentReq req, String status) {
        hospitalDepartmentMapper.updateMajorDepartment(req.getHospitalId(),req.getDepartmentId(),status);
        return RspInfo.success("成功");
    }

    /**
     * 查询医院信息
     *
     * @param hospital
     * @return
     */
    @Override
    public RspInfo<Hospital> selectHospitalInfoById(String hospitalId) {
        return RspInfo.success(this.hospitalMapper.selectByPrimaryKey(hospitalId));
    }

    /**
     * 保存新的部门信息
     * @param newDepart
     * @param hospitalId
     * @return
     */
    private int saveHospitalDepartment(List<Department> newDepart,String hospitalId){
        Date date = new Date();
        for (Department department:newDepart){
            HospitalDepartment hospitalDepartment = new HospitalDepartment();
            hospitalDepartment.setId(IDUtils.genUUId());
            hospitalDepartment.setDepartmentId(department.getDepartmentId());
            hospitalDepartment.setHospitalId(hospitalId);
            hospitalDepartment.setStatus("0");
            hospitalDepartment.setCreateDate(date);
            hospitalDepartment.setUpdateDate(date);
            hospitalDepartment.setDeleted("0");
            hospitalDepartment.setIsMajor("0");
            hospitalDepartmentMapper.insertSelective(hospitalDepartment);
        }
        return 1;
    }

}
