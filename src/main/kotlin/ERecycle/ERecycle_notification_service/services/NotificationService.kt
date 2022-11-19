package ERecycle.ERecycle_notification_service.services

import ERecycle.ERecycle_notification_service.Hosts
import ERecycle.ERecycle_notification_service.HttpRequestResolver
import ERecycle.ERecycle_notification_service.models.Notification
import ERecycle.ERecycle_notification_service.payloads.AddCompleteValidateRecycleRequestNotificationPayload
import ERecycle.ERecycle_notification_service.payloads.AddMakeRecycleRequestNotificationPayload
import ERecycle.ERecycle_notification_service.responses.InvalidTokenResponse
import ERecycle.ERecycle_notification_service.responses.NotificationSentResponse
import ERecycle.ERecycle_notification_service.responses.ValidGetNotificationsResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson

abstract class NotificationService {

  companion object {

    @JvmStatic val serializer = Gson()

    @JvmStatic
    public fun getNotifications(headers: Map<String, String>): Any{
      try {
        val result = NotificationService.serializer.fromJson(HttpRequestResolver.get(Hosts.coreUrl + "/getNotifications/", headers["token"]), ValidGetNotificationsResponse::class.java)
        if(result.notifications == null) return InvalidTokenResponse("invalid token")
        return result

      }catch(exception: NullPointerException) {
        return InvalidTokenResponse("invalid token")
      }

    }

    @JvmStatic
    public fun addMakeRecycleRequestNotification(headers: Map<String, String>, payload: AddMakeRecycleRequestNotificationPayload): Any {
      try {
        return NotificationService.serializer.fromJson(HttpRequestResolver.post(Hosts.coreUrl + "/addMakeRecycleRequestNotification/", headers["token"], payload), NotificationSentResponse::class.java)

      }catch(exception: NullPointerException) {
        return InvalidTokenResponse("invalid token")
      }
    }

    @JvmStatic
    public fun addCompleteRecycleRequestNotification(headers: Map<String, String>, payload: AddCompleteValidateRecycleRequestNotificationPayload): Any {
      try {
        return NotificationService.serializer.fromJson(HttpRequestResolver.post(Hosts.coreUrl + "/addCompleteRecycleRequestNotification/", headers["token"], payload), NotificationSentResponse::class.java)

      }catch(exception: NullPointerException) {
        return InvalidTokenResponse("invalid token")
      }
    }


    @JvmStatic
    public fun addValidateRecycleRequestNotification(headers: Map<String, String>, payload: AddCompleteValidateRecycleRequestNotificationPayload): Any {
      try {
        return NotificationService.serializer.fromJson(HttpRequestResolver.post(Hosts.coreUrl + "/addValidateRecycleRequestNotification/", headers["token"], payload), NotificationSentResponse::class.java)

      }catch(exception: NullPointerException) {
        return InvalidTokenResponse("invalid token")
      }
    }


    @JvmStatic
    public fun checkNotifications(headers: Map<String, String>): Any{
      try {
        return NotificationService.serializer.fromJson(HttpRequestResolver.patch(Hosts.coreUrl + "/checkNotifications/", headers["token"]), NotificationSentResponse::class.java)

      }catch(exception: NullPointerException) {
        return InvalidTokenResponse("invalid token")
      }

    }




  }

}
