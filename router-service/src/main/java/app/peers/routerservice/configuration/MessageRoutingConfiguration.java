package app.peers.routerservice.configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@Configuration
public class MessageRoutingConfiguration {
    private final String topicName;
    private final SimpMessageSendingOperations rabbitTemplate;
    private final Logger logger;

    MessageRoutingConfiguration(@Value("${spring.cloud.pubsub.topic.name}") String topicName,
                                @Autowired SimpMessageSendingOperations operations) {
        this.topicName = topicName;
        this.rabbitTemplate = operations;
        this.logger = LoggerFactory.getLogger(this.getClass());
    }
    
    @Bean
    Executor getSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
    public interface PubsubOutboundGateway {
        Message<byte[]> sendToPubsub(Message<byte[]> msg);
    }

    @Bean
    @ServiceActivator(inputChannel = "pubsubOutputChannel")
    public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
      return new PubSubMessageHandler(pubsubTemplate, topicName );
    }

    @Bean
    public MessageChannel pubsubOutputChannel() {
      return new PublishSubscribeChannel(this.getSingleThreadExecutor());
    }

    @Bean
    @ServiceActivator(inputChannel = "pubsubOutputChannel")
    public void messageRouter(Message<byte[]> message) {
      // return message ->{
          rabbitTemplate.convertAndSend("/queue/rabbit", message);
          logger.info(message.getPayload().toString());
      // };
    }
}
