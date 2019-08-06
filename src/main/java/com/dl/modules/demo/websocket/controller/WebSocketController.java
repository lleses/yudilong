package com.dl.modules.demo.websocket.controller;

import com.dl.comm.websocket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * websocket客户端
 */
@RestController
@RequestMapping("/socket")
public class WebSocketController {


    @Autowired
    private WebSocket webSocket;

    @GetMapping("/appointSending")
    public String appointSending(String name, String message) {
        webSocket.AppointSending(name, message);
        return message;
    }
}
