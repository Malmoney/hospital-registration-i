package com.liurq.server.service;

import com.github.pagehelper.PageInfo;
import com.liurq.server.model.Member;
import com.liurq.server.restful.req.hospital.SelectMemberReq;
import com.liurq.server.restful.req.system.*;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.AddHospitalAccountRsp;
import com.liurq.server.restful.rsp.hospital.MemberInfoRsp;

import java.util.List;

/**
 * @Author:hyz
 * @Date:2021-03-31
 * @Desc:
 **/
public interface MemberService {

    /**
     * 添加管理员用户
     * @return
     */
    RspInfo<String> addAdminAccount(AddAdminAccountReq req);

    /**
     * 添加医院管理员账户
     * @param req
     * @return
     */
    AddHospitalAccountRsp addHospitalAccount(AddHospitalAccountReq req, String parentId);

    /**
     * 添加医生账户
     * @param req
     * @return
     */
    RspInfo<String> addDoctorAccount(AddDoctorAccountReq req);

    /**
     * 修改账号密码
     * @param req
     * @return
     */
    RspInfo<String> modifyPassword(ModifyPasswordReq req);

    /**
     * 首次修改账号密码
     * @param req
     * @return
     */
    RspInfo<String> modifyPasswordFirstTime(ModifyPasswordReq req);

    /**
     * 系统登录
     * @param req
     * @return
     */
    RspInfo<String> systemLogin(LoginReq req);

    /**
     * 获取用户信息
     * @return
     */
    RspInfo<Member> getMemberInfo(String username);

    /**
     * 查询子账号
     * @param req
     * @return
     */
    RspInfo<PageInfo<MemberInfoRsp>> selectHospitalChildMember(SelectMemberReq req);

    /**
     *  禁用用户
     * @param memberId
     * @return
     */
    RspInfo<String> banMember(String memberId);

    /**
     * 解禁用户
     * @param memberId
     * @return
     */
    RspInfo<String> enableMember(String memberId);
}
