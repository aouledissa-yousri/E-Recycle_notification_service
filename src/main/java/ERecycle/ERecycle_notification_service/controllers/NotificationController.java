package ERecycle.ERecycle_notification_service.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

  @GetMapping("/getNotifications")
  public String getNotifications(){
    return "notifications list";
  }
}
