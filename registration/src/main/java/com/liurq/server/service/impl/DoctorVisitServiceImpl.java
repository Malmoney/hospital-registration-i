package com.liurq.server.service.impl;

import com.liurq.server.dao.DoctorVisitMapper;
import com.liurq.server.dao.UserRegistrationMapper;
import com.liurq.server.dao.VisitRecordMapper;
import com.liurq.server.model.DoctorVisit;
import com.liurq.server.model.VisitRecord;
import com.liurq.server.restful.req.hospital.DoctorIdReq;
import com.liurq.server.restful.req.reg.*;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.reg.DoctorVisitRsp;
import com.liurq.server.restful.rsp.reg.VisitItem;
import com.liurq.server.restful.rsp.reg.VisitListRsp;
import com.liurq.server.service.DoctorVisitService;
import com.liurq.util.IDUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:hyz
 * @Date:2021-04-20
 * @Desc:
 **/
@Service
public class DoctorVisitServiceImpl implements DoctorVisitService {

    @Autowired
    private DoctorVisitMapper doctorVisitMapper;

    @Autowired
    private VisitRecordMapper visitRecordMapper;
    @Autowired
    private UserRegistrationMapper userRegistrationMapper;
    /**
     * 添加医生出诊
     *
     * @param req
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RspInfo<String> addDoctorVisit(AddVisitReq req) {
        Date now = new Date();
        //查询医生当日的出诊记录
        HashMap<String, Object> param = new HashMap<>();
        param.put("doctorId",req.getDoctorId());
        param.put("startTime",req.getStartTime());
        param.put("endTime",req.getEndTime());
        if(!ObjectUtils.isEmpty(this.doctorVisitMapper.selectVisitByStartTime(param))){
            return RspInfo.fail("3001","出诊时间冲突!");
        }
        String visitId = IDUtils.genUUId();
        DoctorVisit doctorVisit = new DoctorVisit();
        doctorVisit.setId(visitId);
        doctorVisit.setDoctorId(req.getDoctorId());
        doctorVisit.setVisitStartDate(req.getStartTime());
        doctorVisit.setVisitEndDate(req.getEndTime());
        doctorVisit.setVisitLocation(req.getRoom());
//        doctorVisit.setDepartmentId(req.getDepartId());
        doctorVisit.setStatus("0");
        doctorVisit.setCreateDate(now);
        doctorVisit.setUpdateDate(now);
        this.doctorVisitMapper.insertSelective(doctorVisit);

        VisitRecord visitRecord = new VisitRecord();
        visitRecord.setId(IDUtils.genUUId());
        visitRecord.setVisitId(visitId);
        visitRecord.setNum(1);
        visitRecord.setStatus("0");
        visitRecord.setCreateDate(now);
        this.visitRecordMapper.insertSelective(visitRecord);
        return RspInfo.success("成功");
    }

    /**
     * 查看医生可挂号列表
     *
     * @param req
     * @return
     */
    @Override
    public RspInfo<List<VisitListRsp>> selectVisitList(DoctorIdReq req) {
        String doctorId = req.getDoctorId();
        List<DoctorVisit> visitList = this.doctorVisitMapper.selectVisitList(doctorId);

        if (ObjectUtils.isEmpty(visitList)){
            return RspInfo.success(null);
        }
        ArrayList<VisitListRsp> result = new ArrayList<>();
        //遍历查询
        for (DoctorVisit doctorVisit:visitList){
            Date startDate = doctorVisit.getVisitStartDate();
            Date endDate = doctorVisit.getVisitEndDate();
            VisitListRsp visitListRsp = new VisitListRsp();
            SimpleDateFormat sf = new SimpleDateFormat("MM月dd日");
            visitListRsp.setTime(sf.format(startDate));
            visitListRsp.setRoom(doctorVisit.getVisitLocation());
            visitListRsp.setItemList(this.getVisitItem(startDate,endDate,doctorVisit.getId()));
            visitListRsp.setVisitId(doctorVisit.getId());
            result.add(visitListRsp);
        }

        return RspInfo.success(result);
    }

    /**
     * 叫号
     *
     * @param req
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RspInfo<String> nextNum(PassNumReq req) {
        //修改当前号的状态0-等待中，1-已过号，2-已结束
        String nowRegId = req.getNowRegId();
        if(!StringUtils.isBlank(nowRegId)){
            this.userRegistrationMapper.updateRegStatus(nowRegId,"2",null);
        }
        //修改visit_record记录中的num
        String visitId = req.getVisitId();
        this.visitRecordMapper.updateRecordNum(visitId,req.getNum());
        //修改下一个号的状态
//        String nextRegId = req.getNextRegId();
//        this.userRegistrationMapper.updateRegStatus(nowRegId,"3");
        return RspInfo.success("成功");
    }

    /**
     * 过号
     *
     * @param req
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RspInfo<String> passNum(PassNumReq req) {
        //修改当前号的状态0-等待中，1-已过号，2-已结束
        String nowRegId = req.getNowRegId();
        this.userRegistrationMapper.updateRegStatus(nowRegId,"1",req.getReason());
        //修改visit_record记录中的num
        String visitId = req.getVisitId();
        this.visitRecordMapper.updateRecordNum(visitId,req.getNum());
        return RspInfo.success("成功");
    }

    /**
     * 过号
     *
     * @param req
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RspInfo<String> endVisit(VisitIdReq req) {
        //2-已结束
        this.visitRecordMapper.updateRecordStatus(req.getVisitId(),"2");
        //2-已结束
        this.userRegistrationMapper.updateAllRegStatus(req.getVisitId(),"3");
        return RspInfo.success("成功");
    }

    /**
     * 查询医生的出诊安排
     *
     * @param doctorId
     * @return
     */
    @Override
    public RspInfo<List<DoctorVisitRsp>> selectDoctorVisitList(String doctorId) {
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(new Date());
        startDate.set(Calendar.HOUR_OF_DAY,0);
        startDate.set(Calendar.MINUTE,0);
        startDate.set(Calendar.SECOND,0);
        List<DoctorVisit> list = this.doctorVisitMapper.selectDoctorVisitList(doctorId, startDate.getTime());
        ArrayList<DoctorVisitRsp> result = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat timeFormat = new SimpleDateFormat("H:mm");
        for (DoctorVisit v : list){
            DoctorVisitRsp rsp = new DoctorVisitRsp();
            rsp.setDate(dateFormat.format(v.getVisitStartDate()));
            rsp.setTime(timeFormat.format(v.getVisitStartDate())+"-"+timeFormat.format(v.getVisitEndDate()));
            rsp.setVisitId(v.getId());
            rsp.setRoom(v.getVisitLocation());
            result.add(rsp);
        }
        return RspInfo.success(result);
    }

    /**
     * 查询挂号的详情
     * @param visitId
     * @return
     */
    @Override
    public RspInfo<List<VisitItem>> selectRegList(String visitId) {
        List<VisitItem> result = this.userRegistrationMapper.selectRegList(visitId);
        return RspInfo.success(result);
    }

    private ArrayList<VisitItem> getVisitItem(Date start, Date end, String visitId){
        //查询不可以挂号的号码
        List<Integer> nums = this.doctorVisitMapper.selectVisitNum(visitId);
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(start);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(end);
        Calendar noonDate = Calendar.getInstance();
        noonDate.setTime(start);
        noonDate.set(Calendar.HOUR_OF_DAY,12);
        noonDate.set(Calendar.MINUTE,00);


        Calendar noonEndDate = Calendar.getInstance();
        noonEndDate.setTime(start);
        noonEndDate.set(Calendar.HOUR_OF_DAY,14);
        noonEndDate.set(Calendar.MINUTE,30);

        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
        ArrayList<VisitItem> items = new ArrayList<>();
        int num = 1;
        while (startDate.before(endDate)){
            if (nums.contains(num)){
                num++;
                startDate.add(Calendar.MINUTE,15);
                continue;
            }
            if (startDate.get(Calendar.HOUR_OF_DAY)>=12 && startDate.get(Calendar.HOUR_OF_DAY)<14){
                startDate.set(Calendar.HOUR_OF_DAY,14);
                startDate.set(Calendar.MINUTE,00);
                continue;
            }
            VisitItem visitItem = new VisitItem();
            visitItem.setNum(num+"");
            visitItem.setTime(sf.format(startDate.getTime()));

            num++;
            startDate.add(Calendar.MINUTE,15);
            items.add(visitItem);
        }
        return items;
    }

}
