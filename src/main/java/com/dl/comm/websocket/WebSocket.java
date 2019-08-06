package com.dl.comm.websocket;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@Component
//@ServerEndpoint把当前类标识成一个WebSocket的服务端,注解的值用户客户端连接访问的URL地址
@ServerEndpoint("/websocket/{name}")
public class WebSocket {

    private Session session;
    private String clientName;

    /** 用于存所有的连接服务的客户端，这个对象存储是安全的 */
    private static ConcurrentHashMap<String, WebSocket> webSocketSet = new ConcurrentHashMap<>();


    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name) {
        this.clientName = name;
        this.session = session;
        webSocketSet.put(name, this);// name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        log.info("[" + name + "] client连接成功，当前连接人数为：={}", webSocketSet.size());
    }


    @OnClose
    public void OnClose() {
        String name = clientName;
        webSocketSet.remove(name);
        log.info("[" + name + "] client退出成功，当前连接人数为：={}", webSocketSet.size());
    }

    @OnMessage
    public void OnMessage(String message) {
        //判断是否需要指定发送，具体规则自定义
        if (message.indexOf("TOUSER") == 0) {
            String name = message.substring(message.indexOf("TOUSER") + 6, message.indexOf(";"));
            AppointSending(name, message.substring(message.indexOf(";") + 1, message.length()));
        } else {
            GroupSending(message);
        }

    }

    /**
     * 群发
     * @param message
     */
    public void GroupSending(String message) {
        for (String name : webSocketSet.keySet()) {
            AppointSending(name, message);
        }
    }

    /**
     * 指定发送
     * @param name
     * @param message
     */
    public void AppointSending(String name, String message) {
        try {
            WebSocket webSocket = webSocketSet.get(name);
            if (webSocket == null) {
                log.warn("[" + name + "] client不存在");
                return;
            }
            log.info("[" + webSocket.clientName + "] client收到消息：{}", message);
            Session session = webSocket.session;
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}