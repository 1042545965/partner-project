
package com.partner.controller.user;

import com.partner.api.PartnerBsOrderInfoService;
import com.partner.config.MyWebSocket;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PartnerBsOrderInfoService partnerBsOrderInfoService;
    @Autowired
    private MyWebSocket myWebSocket;

    @GetMapping("/getUserList")
    @ResponseBody
    public RestResponseBo getUserList() {

        return RestResponseBo.ok();
    }
}

