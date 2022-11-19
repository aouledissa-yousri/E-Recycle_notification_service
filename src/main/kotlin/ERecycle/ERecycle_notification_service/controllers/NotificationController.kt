package ERecycle.ERecycle_notification_service.controllers

import ERecycle.ERecycle_notification_service.Helpers.TypeConverterHelper
import ERecycle.ERecycle_notification_service.annotations.CheckAccessToken
import ERecycle.ERecycle_notification_service.models.Notification
import ERecycle.ERecycle_notification_service.payloads.AddCompleteValidateRecycleRequestNotificationPayload
import ERecycle.ERecycle_notification_service.payloads.AddMakeRecycleRequestNotificationPayload
import ERecycle.ERecycle_notification_service.services.NotificationService
import com.google.gson.Gson
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController


@RestController
class NotificationController {

  @GetMapping("/getNotifications")
  @CheckAccessToken
  public fun getNotification(@RequestHeader headers: Map<String, String>): Any {
    return NotificationService.getNotifications(headers)
  }

  @PostMapping("/addMakeRecycleRequestNotification/")
  @CheckAccessToken
  public fun addMakeRecycleRequestNotification(@RequestHeader headers: Map<String, String>, @RequestBody payload: Map<String, Map<String, Any>>): Any? {
    return NotificationService.addMakeRecycleRequestNotification(headers, Gson().fromJson(Gson().toJsonTree(payload).asJsonObject, AddMakeRecycleRequestNotificationPayload::class.java))
  }

  @PostMapping("/addCompleteRecycleRequestNotification/")
  @CheckAccessToken
  public fun addCompleteRecycleRequestNotification(@RequestHeader headers: Map<String, String>, @RequestBody payload: Map<String, Any>): Any? {
    return NotificationService.addCompleteRecycleRequestNotification(headers, Gson().fromJson(Gson().toJsonTree(payload).asJsonObject, AddCompleteValidateRecycleRequestNotificationPayload::class.java))
  }

  @PostMapping("/addValidateRecycleRequestNotification/")
  @CheckAccessToken
  public fun addValidateRecycleRequestNotification(@RequestHeader headers: Map<String, String>, @RequestBody payload: Map<String, Any>): Any? {
    return NotificationService.addCompleteRecycleRequestNotification(headers, Gson().fromJson(Gson().toJsonTree(payload).asJsonObject, AddCompleteValidateRecycleRequestNotificationPayload::class.java))
  }

  @PatchMapping("/checkNotifications/")
  @CheckAccessToken
  public fun checkNotifications(@RequestHeader headers: Map<String, String>): Any {
    return NotificationService.checkNotifications(headers)
  }


}
