package com.dl.example.websocket;


import com.dl.comm.websocket.WebSocketClient;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 配置websocket后台客户端
 */
@Slf4j
public class WebSocketClientTest {


    @Test
    public void test() {
        try {
            WebSocketClient client = new WebSocketClient("ws://localhost:8080/websocket/test");
            client.connect();
            while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
                System.out.println("还没有打开");
            }
            System.out.println("建立websocket连接");
            client.send("asd");
            client.send("11111111111");
            client.send("222222222");
            client.send("333333333");
            client.send("444444444");
            client.send("5555555555");
            client.close();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void connectTest() {
        org.java_websocket.client.WebSocketClient webSocketClient = webSocketClient("test1");
        webSocketClient.send("xxxx-test1");
        //webSocketClient.close();
    }


    @Test
    public void connectTest2() {
        org.java_websocket.client.WebSocketClient webSocketClient = webSocketClient("test2");
        webSocketClient.send("xxxx-test2");
        webSocketClient.close();
    }


    private org.java_websocket.client.WebSocketClient webSocketClient(String clientName) {
        try {
            org.java_websocket.client.WebSocketClient webSocketClient = new org.java_websocket.client.WebSocketClient(new URI("ws://localhost:8080/websocket/" + clientName), new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    log.info("[" + clientName + "] 连接成功");
                }

                @Override
                public void onMessage(String message) {
                    log.info("[client] 收到消息={}", message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    log.info("[client] 退出连接");
                }

                @Override
                public void onError(Exception ex) {
                    log.info("[client] 连接错误={}", ex.getMessage());
                }
            };
            webSocketClient.connect();
            return webSocketClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}