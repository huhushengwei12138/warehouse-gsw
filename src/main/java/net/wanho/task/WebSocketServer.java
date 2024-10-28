package net.wanho.task;


import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSocket服务端
 */
@Component
@ServerEndpoint("/ws/{cid}")
public class WebSocketServer {

    // 存放会话对象
    private static Map<String, Session> sessionMap = new HashMap<>();

    /**
     * 监听连接建立成功
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("cid") String cid) {
        System.out.println("客户端：" + cid + "建立连接......");
        sessionMap.put(cid, session);
    }

    /**
     * 监听收到客户端消息
     */
    @OnMessage
    public void onMessage(String msg, @PathParam("cid") String cid) {
        System.out.println("这是来自客户端：" + cid + "的信息:" + msg);
    }

    /**
     * 监听连接关闭
     */
    @OnClose
    public void onClose(@PathParam("cid") String cid) {
        System.out.println("连接断开:" + cid);
        sessionMap.remove(cid);
    }

    /**
     * 群发消息
     */
    public void sendToAllClient(String msg) {
        Collection<Session> sessions = sessionMap.values();
        for (Session session : sessions) {
            try {
                // 服务器向客户端发送消息
                session.getBasicRemote().sendText(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
