package com.liurq.server.controller.system;

import com.github.pagehelper.PageInfo;
import com.liurq.server.feign.PersonRedisFeignClient;
import com.liurq.server.model.Member;
import com.liurq.server.restful.req.hospital.SelectMemberReq;
import com.liurq.server.restful.req.system.*;
import com.liurq.server.restful.req.user.TokenReq;
import com.liurq.server.restful.rsp.RspInfo;
import com.liurq.server.restful.rsp.hospital.AccountInfoRsp;
import com.liurq.server.restful.rsp.hospital.AddHospitalAccountRsp;
import com.liurq.server.restful.rsp.hospital.DoctorMemberInfoRsp;
import com.liurq.server.restful.rsp.hospital.HospitalMemberInfoRsp;
import com.liurq.server.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author:hyz
 * @Date:2021-03-31
 * @Desc:
 **/
@RestController
@RequestMapping("/server/member")
@Api(description = "平台信息管理员账号处理")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private PersonRedisFeignClient personRedisFeignClient;

    /**
     * 添加省级管理员
     * @param req
     * @return
     */
    @ApiOperation(value = "添加省级管理员账号",notes = "添加省级管理员账号")
    @RequestMapping(value = "/addProvAdmin",method = RequestMethod.POST)
    public RspInfo<String> addProvAdmin(@RequestBody @Valid AddAdminAccountReq req){
        req.setType("9");
        return memberService.addAdminAccount(req);
    }

    /**
     * 添加区县管理员
     * @param req
     * @return
     */
    @ApiOperation(value = "添加市级管理员账号",notes = "添加市级管理员账号")
    @RequestMapping(value = "/addCityAdmin",method = RequestMethod.POST)
    public RspInfo<String> addCityAdmin(@RequestBody @Valid AddAdminAccountReq req){
        req.setType("8");
        return memberService.addAdminAccount(req);
    }

    /**
     * 添加医院管理员
     * @param req
     * @return
     */
    @ApiOperation(value = "添加医院管理账号",notes = "添加医院管理账号")
    @RequestMapping(value = "/addHospitalAdmin",method = RequestMethod.POST)
    public RspInfo<String> addHospitalAdmin(@RequestBody @Valid AddHospitalAccountReq req){
        req.setType("1");
        Member member = memberService.getMemberInfo(req.getUserName()).getRspData();
        if(!ObjectUtils.isEmpty(member)){
            return RspInfo.fail("3001","用户名已存在");
        }
        AddHospitalAccountRsp rsp = memberService.addHospitalAccount(req, "0");
        return RspInfo.success("成功");
    }

    /**
     * 添加医生账号
     * @param req
     * @return
     */
    @ApiOperation(value = "添加医生账号",notes = "添加医生账号")
    @RequestMapping(value = "/addDoctorAccount",method = RequestMethod.POST)
    public RspInfo<String> addDoctorAccount(@RequestBody @Valid AddDoctorAccountReq req){
        req.setType("0");
        return memberService.addDoctorAccount(req);
    }

    /**
     * 修改账号密码
     * @param req
     * @return
     */
    @ApiOperation(value = "修改账号密码",notes = "修改账号密码")
    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    public RspInfo<String> modifyPassword(@RequestBody @Valid ModifyPasswordReq req){
        if (StringUtils.isEmpty(req.getOldPassword())){
            return RspInfo.fail("旧密码不能为空");
        }
        return this.memberService.modifyPassword(req);
    }

    /**
     * 首次修改账号密码
     * @param req
     * @return
     */
    @ApiOperation(value = "首次修改账号密码",notes = "首次修改账号密码")
    @RequestMapping(value = "/modifyPasswordFirstTime",method = RequestMethod.POST)
    public RspInfo<String> modifyPasswordFirstTime(@RequestBody @Valid ModifyPasswordReq req){
        return this.memberService.modifyPasswordFirstTime(req);
    }

    /**
     * 首次修改账号密码
     * @param req
     * @return
     */
    @ApiOperation(value = "获取账号信息",notes = "获取账号信息")
    @RequestMapping(value = "/getMemberInfo",method = RequestMethod.POST)
    public RspInfo<Member> getMemberInfo(@RequestBody @Valid TokenReq req){
        String username = personRedisFeignClient.getUser(req.getToken());
        if(StringUtils.isEmpty(username)){
            return RspInfo.fail("获取用户信息失败");
        }
        return this.memberService.getMemberInfo(username);
    }

    /**
     * 查询子账号
     * @param req
     * @return
     */
    @ApiOperation(value = "查询子账号",notes = "查询子账号")
    @RequestMapping(value = "/selectHospitalChildMember",method = RequestMethod.POST)
    public RspInfo<PageInfo<DoctorMemberInfoRsp>> selectHospitalChildMember(@RequestBody @Valid SelectMemberReq req){
        return this.memberService.selectHospitalChildMember(req);
    }
    /**
     * 查询子账号
     * @param req
     * @return
     */
    @ApiOperation(value = "查询子账号",notes = "查询子账号")
    @RequestMapping(value = "/selectProvChildMember",method = RequestMethod.POST)
    public RspInfo<PageInfo<AccountInfoRsp>> selectProvChildMember(@RequestBody @Valid SelectMemberReq req){
        return this.memberService.selectProvChildMember(req);
    }
    /**
     * 查询子账号
     * @param req
     * @return
     */
    @ApiOperation(value = "查询城市管理员的子账号",notes = "查询城市管理员的子账号")
    @RequestMapping(value = "/selectCityChildMember",method = RequestMethod.POST)
    public RspInfo<PageInfo<HospitalMemberInfoRsp>> selectCityChildMember(@RequestBody @Valid SelectMemberReq req){
        return this.memberService.selectCityChildMember(req);
    }

    @ApiOperation(value = "禁用账号",notes = "禁用账号")
    @RequestMapping(value = "/banMember",method = RequestMethod.POST)
    public RspInfo<String> banMember(@RequestBody @Valid MemberIdReq req){
        return this.memberService.banMember(req.getMemberId());
    }

    @ApiOperation(value = "解禁账号",notes = "解禁账号")
    @RequestMapping(value = "/enableMember",method = RequestMethod.POST)
    public RspInfo<String> enableMember(@RequestBody @Valid MemberIdReq req){
        return this.memberService.enableMember(req.getMemberId());
    }
}
