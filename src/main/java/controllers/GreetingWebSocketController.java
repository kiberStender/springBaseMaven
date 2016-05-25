package controllers;

import model.Greeting;
import model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sirkleber on 25/05/16.
 */
@Controller
public class GreetingWebSocketController {
    private final AtomicLong counter = new AtomicLong();

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greetingWs(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting(counter.incrementAndGet(), "Hello, " + message.getName() + "!");
    }
}
