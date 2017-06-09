package com.fdmgroup.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class PushNotificationController {
	
	private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());
	
	@RequestMapping("/showNotification")
    public String showNotification() {
		return "notification";
    }
	
	@RequestMapping("/update")
	SseEmitter subscribeUpdates() {
		SseEmitter sseEmitter = new SseEmitter();
		synchronized (this.sseEmitters) {
			this.sseEmitters.add(sseEmitter);
			sseEmitter.onCompletion(() -> {
				synchronized (this.sseEmitters) {
					this.sseEmitters.remove(sseEmitter);
				}
			});
		}
		
		return sseEmitter;
	}
	
	@RequestMapping("/sseTest")
    public ResponseBodyEmitter handleRequest() {

        final SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        service.execute(() -> {
            for (int i = 0; i < 500; i++) {
                try {
                    emitter.send(LocalTime.now().toString() , MediaType.TEXT_PLAIN);

                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        });

        return emitter;
    }
	
	@RequestMapping("/getMessages")
    public ResponseBodyEmitter getMessages() {

        final SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        ExecutorService service = Executors.newSingleThreadExecutor();
        Random r = new Random();
        
        service.execute(() -> {
            try {
            	String data = "{\ndata: \"numOfMsg\": " + r.nextInt(10) +",\ndata: \"number\": " +r.nextInt() + "\ndata: }\n\n";
                emitter.send(data, MediaType.APPLICATION_JSON);

                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
                emitter.completeWithError(e);
                return;
            }
            emitter.complete();
        });

        return emitter;
    }
	
	 @RequestMapping("/systemalert")
     public @ResponseBody String sendMessage(@RequestParam String id, HttpServletResponse response) {
             Random r = new Random();
             response.setContentType("text/event-stream");
             try {
                     Thread.sleep(10000);
             } catch (InterruptedException e) {
                     e.printStackTrace();
             }  
             
             return "data: The ID is: " + id + " - "+ r.nextInt() +"\n\n";
     }
}
