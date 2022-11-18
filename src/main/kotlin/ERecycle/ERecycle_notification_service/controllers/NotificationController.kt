package ERecycle.ERecycle_notification_service.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class NotificationController {

  @GetMapping("/getNotifications")
  public fun getNotification(): String{
    return "notification list";
  }


}
