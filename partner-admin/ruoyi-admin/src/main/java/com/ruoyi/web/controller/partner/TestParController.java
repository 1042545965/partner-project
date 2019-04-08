//
//package com.ruoyi.web.controller.partner;
//
//import com.partner.entity.PartnerBsUser;
//import com.partner.api.PartnerBsUserService;
//import com.ruoyi.common.core.result.RestResponseBo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * 参数配置 信息操作处理
// *
// * @author ruoyi
// */
//
//@Controller
//@RequestMapping("/testpar")
//public class TestParController {
//
//    @Autowired
//    private PartnerBsUserService partnerBsUserService;
//
//    @GetMapping("/getDate")
//    @ResponseBody
//    public PartnerBsUser getDate(Long id) {
//        return partnerBsUserService.selectPartnerBsUserById(id);
////        return null;
//    }
//
//    @GetMapping("/getResDate")
//    @ResponseBody
//    public RestResponseBo getResDate(Long id) {
//        return partnerBsUserService.selectRestPartnerBsUserById(id);
//    }
//}
//
