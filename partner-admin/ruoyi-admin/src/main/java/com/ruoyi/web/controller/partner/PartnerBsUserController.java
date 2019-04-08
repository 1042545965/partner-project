package com.ruoyi.web.controller.partner;

import com.partner.api.PartnerBsOrderInfoService;
import com.partner.api.PartnerBsUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.result.RestResponseBo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户 信息操作处理
 *
 * @author ruoyi
 * @date 2019-03-29
 */
@Controller
@RequestMapping("/system/partnerBsUser")
public class PartnerBsUserController extends BaseController {
    private String prefix = "system/partnerBsUser";

    @Autowired
    private PartnerBsUserService partnerBsUserService;
    @Autowired
    private PartnerBsOrderInfoService partnerBsOrderInfoService;

    @RequiresPermissions("system:partnerBsUser:view")
    @GetMapping()
    public String partnerBsUser() {
        return prefix + "/partnerBsUser";
    }


    @RequiresPermissions("system:partnerBsUser:list")
    @GetMapping("/testList")
    @ResponseBody
    public RestResponseBo testList(Long id) {
        return RestResponseBo.ok(partnerBsOrderInfoService.selectPartnerBsOrderInfoById(id));
    }
}
