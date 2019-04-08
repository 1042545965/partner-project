package com.partner.controller.sendmessage;


import com.alibaba.fastjson.JSON;
import com.partner.api.PartnerBsMessageService;
import com.partner.api.PartnerBsUserService;
import com.partner.config.MyWebSocket;
import com.partner.entity.PartnerBsMessage;
import com.partner.entity.PartnerBsUser;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.constant.ErrorMessageConstants;
import com.ruoyi.common.constant.WebSocketConstants;
import com.ruoyi.common.core.result.RestResponseBo;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeauty.pojo.Session;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * @author conlon123
 * @since 2019-03-31
 */
@Controller
@RequestMapping("/partnerBsMessage")
public class MessageController {
    private final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MyWebSocket myWebSocket;
    @Autowired
    private PartnerBsMessageService partnerBsMessageService;
    @Autowired
    private PartnerBsUserService partnerBsUserService;


    /**
     * 发送聊天数据 ， 使用接口推送的方式
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/putMessage")
    public RestResponseBo putMessage(PartnerBsMessage partnerBsMessage) {
        if (StringUtils.isNotNull(partnerBsMessage) || StringUtils.isNotNull(partnerBsMessage.getSendUserId()) ||
                StringUtils.isNotNull(partnerBsMessage.getAccepterUserId()) || StringUtils.isNotEmpty(partnerBsMessage.getNettyMessage())) {
            RestResponseBo.fail(ErrorMessageConstants.parameter_message);
        }

        Map<String, Session> sessionMap = myWebSocket.sessionMap;
        if (StringUtils.isNotEmpty(sessionMap)) {
            for (String s : sessionMap.keySet()) {
                if (Objects.equals(s, WebSocketConstants.USER_CHAT_REGISTER + partnerBsMessage.getAccepterUserId())) {
                    myWebSocket.OnMessage(sessionMap.get(s), partnerBsMessage.getNettyMessage());
                }
            }
        }
        //发送成功后使用异步保存信息 , 不需要事务 。没有成功无所谓
        partnerBsMessageService.insertPartnerBsMessageAsyn(partnerBsMessage);
        return RestResponseBo.ok();
    }


    @ResponseBody
    @GetMapping("/putMessageAll")
    public RestResponseBo putMessageAll(PartnerBsMessage partnerBsMessage) {
        Map<String, Session> sessionMap = myWebSocket.sessionMap;
        if (StringUtils.isNotEmpty(sessionMap)) {
            for (String s : sessionMap.keySet()) {
                myWebSocket.OnMessage(sessionMap.get(s), JSON.toJSONString(partnerBsMessage));
            }
        }
        return RestResponseBo.ok();
    }


    /**
     * 获取以登陆连接的用户列表
     *
     * @return
     */
    @GetMapping("/getLinkUserList")
    @ResponseBody
    @ApiOperation(value = "获取已经登陆的用户列表", notes = "目前不要传值 ，如果有我的好友列表的功能的话 ， 需要传值")
    public RestResponseBo<List<PartnerBsUser>> getLinkUserList() {
        Map<String, Session> sessionMap = myWebSocket.sessionMap;
        String userIds = "";
        for (String s : sessionMap.keySet()) {
            userIds = userIds + "," + s.replace(WebSocketConstants.USER_CHAT_REGISTER, "");
        }
        if (StringUtils.isEmpty(userIds)) {
            return RestResponseBo.fail("暂无用户");
        }
        return partnerBsUserService.getLinkUserList(userIds);
    }


    @GetMapping("/userMessage")
    public String userMessage(ModelMap modelMap , HttpSession httpSession) {
        PartnerBsUser user = (PartnerBsUser)httpSession.getAttribute(CacheConstants.USER_LOGIN_CACHE);
        modelMap.addAttribute(WebSocketConstants.WEB_SOCKET_USER_ID , user.getId());
        return "/usermessage";
    }

}