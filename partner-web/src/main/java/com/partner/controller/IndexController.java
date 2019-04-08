package com.partner.controller;

import com.partner.api.PartnerBsUserService;
import com.partner.entity.PartnerBsUser;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.constant.ErrorMessageConstants;
import com.ruoyi.common.core.result.RestResponseBo;
import com.ruoyi.common.utils.CheckUtil;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PartnerBsUserService partnerBsUserService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/userLogin")
    @ResponseBody
    @ApiOperation(value = "用户登陆", notes = "登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "string", required = true)})
    public RestResponseBo userLogin(String username, String password , HttpSession httpSession) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return RestResponseBo.fail("用户名密码不能为空");
        }
//        if (!CheckUtil.checkBizPassword(password)) {
//            return RestResponseBo.fail("请输入六位以上的数字和字母");
//        }
        if (!CheckUtil.checkMobile(username)) {
            return RestResponseBo.fail("请输入正确的用户名号码");
        }
        PartnerBsUser queryUser = new PartnerBsUser();
        queryUser.setUserName(username);
        PartnerBsUser partnerBsUser = partnerBsUserService.selectPartnerBsUserByOne(queryUser);
        if (StringUtils.isNull(partnerBsUser)){
            return RestResponseBo.fail("用户不存在");
        }
        RestResponseBo responseBo = partnerBsUserService.userLogin(username, password);
        if (responseBo.isSuccess()){
            //session 放入用户缓存
            httpSession.setAttribute(CacheConstants.USER_LOGIN_CACHE , partnerBsUser);
        }
        return responseBo;
    }

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @PostMapping("/userRegister")
    @ResponseBody
    @ApiOperation(value = "用户注册", notes = "登陆")
    public RestResponseBo userRegister(PartnerBsUser partnerBsUser) {
        if (StringUtils.isNull(partnerBsUser) || StringUtils.isEmpty(partnerBsUser.getPassword())||
        StringUtils.isEmpty(partnerBsUser.getNickName()) || StringUtils.isEmpty(partnerBsUser.getUserMobile())||
        StringUtils.isEmpty(partnerBsUser.getUserName())){
            return RestResponseBo.fail(ErrorMessageConstants.parameter_message);
        }
        if (!CheckUtil.checkMobile(partnerBsUser.getUserMobile())){
            return RestResponseBo.fail("手机号码错误");
        }
//        if (!CheckUtil.checkBizPassword(partnerBsUser.getPassword())) {
//            return RestResponseBo.fail("密码请输入六位以上的数字和字母");
//        }
        PartnerBsUser queryUser = partnerBsUserService.selectPartnerBsUserByUserName(partnerBsUser.getUserName());
        if (StringUtils.isNotNull(queryUser)){
            return RestResponseBo.fail("用户已经存在");
        }
        return partnerBsUserService.userRegister(partnerBsUser);
    }


    @GetMapping("/userMessage")
    public String userMessage() {
        return "/usermessage";
    }

}
