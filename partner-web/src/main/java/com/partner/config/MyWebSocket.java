package com.partner.config;

import com.ruoyi.common.constant.WebSocketConstants;
import com.ruoyi.common.utils.StringUtils;
import io.netty.handler.codec.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.*;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(port = 7009 , path = "/socket")
@Component
public class MyWebSocket {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebSocket.class);

    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, ParameterMap parameterMap) throws IOException {
        String userId = parameterMap.getParameter(WebSocketConstants.WEB_SOCKET_USER_ID);
        if (StringUtils.isNotEmpty(sessionMap)){
            Boolean flag = true;
            for (String s : sessionMap.keySet()) {
                if (Objects.equals(s , WebSocketConstants.USER_CHAT_REGISTER+userId)){
                    //有这个连接 ， 不放入map中
                    flag = false;
                }
            }
            if (flag){
                sessionMap.put(WebSocketConstants.USER_CHAT_REGISTER + userId, session);
                LOGGER.info("用户建立连接 【用户id=】" + userId);
            }
        }else {
            sessionMap.put(WebSocketConstants.USER_CHAT_REGISTER + userId, session);
            LOGGER.info("首次初始连接 ==> 用户建立连接 【用户id=】" + userId);
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        if (StringUtils.isNotEmpty(sessionMap)){
            for (Map.Entry<String, Session> m : sessionMap.entrySet()) {
                if (Objects.equals(session , m.getValue())){
                    sessionMap.remove(m.getKey());
                    LOGGER.info("用户退出登陆 【注册的key为 】" + m.getKey());
                }
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        LOGGER.error(throwable.getMessage());
    }

    @OnMessage
    public void OnMessage(Session session, String message) {
        session.sendText(message);
    }

    /**
     * 广播消息
     * @param sessionMap
     * @param message
     */
    public void OnMessageToAll(Map<String, Session> sessionMap, String message) {
        for (Session value : sessionMap.values()) {
            this.OnMessage(value , message);
        }
    }
}
