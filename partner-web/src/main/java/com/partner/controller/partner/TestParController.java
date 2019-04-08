
package com.partner.controller.partner;

import com.partner.api.PartnerBsOrderInfoService;
import com.partner.api.PartnerBsUserService;
import com.partner.config.MyWebSocket;
import com.partner.entity.PartnerBsUser;
import com.ruoyi.common.core.result.RestResponseBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 参数配置 信息操作处理
 *
 * @author ruoyi
 */

@Controller
@RequestMapping("/testpar")
public class TestParController {

    @Autowired
    private PartnerBsUserService partnerBsUserService;
    @Autowired
    private PartnerBsOrderInfoService partnerBsOrderInfoService;
    @Autowired
    private MyWebSocket myWebSocket;

    @GetMapping("/getDate")
    @ResponseBody
    public PartnerBsUser getDate(Long id) {
        return partnerBsUserService.selectPartnerBsUserById(id);
//        return null;
    }

    @GetMapping("/getResDate")
    @ResponseBody
    public RestResponseBo getResDate(Long id) {
        if (id == null) {
            return RestResponseBo.fail("用户id不能为空");
        }
        return RestResponseBo.ok(partnerBsOrderInfoService.selectPartnerBsOrderInfoById(id));
    }

    @GetMapping("/putMessage")
    @ResponseBody
    public PartnerBsUser putMessage(Long id) {
//        Map<String, Session> sessionMap = myWebSocket.sessionMap;
//        if (StringUtils.isNotEmpty(sessionMap)){
//            for (String s : sessionMap.keySet()) {
//                if (Objects.equals(s , WebSocketConstants.USER_CHAT_REGISTER + id)){
//                    myWebSocket.OnMessage(sessionMap.get(s) , "test netty");
//                }
//            }
//        }
        return null;
    }
}

