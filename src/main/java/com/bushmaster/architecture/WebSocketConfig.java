package com.bushmaster.architecture;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 添加一个Socket端点,客户端可以通过这个端点进行连接
        registry.addEndpoint("/socket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // client接收server信息的地址前缀
        registry.enableSimpleBroker("/topic");
        // client给server发消息的地址前缀
        registry.setApplicationDestinationPrefixes("/app");
    }
}
