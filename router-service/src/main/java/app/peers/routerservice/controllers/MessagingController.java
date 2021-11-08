package app.peers.routerservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import app.peers.routerservice.configuration.MessageRoutingConfiguration.PubsubOutboundGateway;

@Controller
public class MessagingController {
    private final PubsubOutboundGateway messageGateway;
    private final Logger logger;

    MessagingController(@Autowired PubsubOutboundGateway messageGateway) {
        this.messageGateway = messageGateway;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @MessageMapping("/logToServer")
    public void print(Message<byte[]> message){
        message.getHeaders().forEach((k,v)->{
            logger.info("Key:" +k+ ",value: " +v);
        });
        // System.out.println(new String(message.getPayload()));
        // System.out.println("-------------------------------------------------------------------------------------");
        messageGateway.sendToPubsub(message);
    }
}