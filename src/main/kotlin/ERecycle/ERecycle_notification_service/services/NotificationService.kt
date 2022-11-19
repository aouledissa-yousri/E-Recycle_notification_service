package ERecycle.ERecycle_notification_service.services

import ERecycle.ERecycle_notification_service.Hosts
import ERecycle.ERecycle_notification_service.HttpRequestResolver
import ERecycle.ERecycle_notification_service.responses.InvalidTokenResponse
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





  }

}
