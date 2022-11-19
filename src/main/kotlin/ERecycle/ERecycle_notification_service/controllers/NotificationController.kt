package ERecycle.ERecycle_notification_service.controllers

import ERecycle.ERecycle_notification_service.annotations.CheckAccessToken
import ERecycle.ERecycle_notification_service.responses.InvalidTokenResponse
import ERecycle.ERecycle_notification_service.services.NotificationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController


@RestController
class NotificationController {

  @GetMapping("/getNotifications")
  @CheckAccessToken
  public fun getNotification(@RequestHeader headers: Map<String, String>): Any {
    return NotificationService.getNotifications(headers)
  }


}
