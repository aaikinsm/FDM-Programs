package com.fdmgroup.controller;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fdmgroup.dao.NotificationDao;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.Notification;
import com.fdmgroup.model.User;

@Controller
public class PushNotificationController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private NotificationDao notificationDao;
	
	@RequestMapping("/showNotification")
    public String showNotification() {
		return "notification";
    }
	
	@RequestMapping("/getMessages")
    public ResponseBodyEmitter getMessages() {

        final SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        ExecutorService service = Executors.newSingleThreadExecutor();
        Random r = new Random();
        
        service.execute(() -> {
            try {
            	String data = "{\ndata: \"numOfMsg\": " + r.nextInt(10) +",\ndata: \"number\": " + r.nextInt() + "\ndata: }\n\n";
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
	
	@RequestMapping("/getNotifications")
    public ResponseBodyEmitter getNotifications(@RequestParam int id) {

        final SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        service.execute(() -> {
            try {
            	User user = userDao.findUserById(id);
            	List<Notification> notifications = notificationDao.findByUser(user);
            	String data = "{\ndata: \"numOfMsg\": " + notifications.size() + "}\n\n";
                emitter.send(data, MediaType.APPLICATION_JSON);

                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
                emitter.completeWithError(e);
                return;
            }
            emitter.complete();
        });

        return emitter;
    }
}
