package pl.bskorka.controller;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bskorka.model.Message;

/**
 * Created by sages on 15.11.16.
 */
@RequestMapping("/message")
@RestController
@EnableConfigurationProperties(Message.class)
public class MessageController {

    private Message message;

    public MessageController(Message message) {
        this.message=message;
    }

    @GetMapping
    public Message getMessage() {
        return new Message(message.getMessage());
    }

}
