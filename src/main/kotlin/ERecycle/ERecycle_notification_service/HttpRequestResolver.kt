package ERecycle.ERecycle_notification_service

import ERecycle.ERecycle_notification_service.models.Notification
import ERecycle.ERecycle_notification_service.payloads.AddMakeRecycleRequestNotificationPayload
import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class HttpRequestResolver {

  companion object {

    @JvmStatic val client = HttpClient.newBuilder().build()


    @JvmStatic
    public fun get(url: String, token: String? = ""): String{
      val request = HttpRequest.newBuilder().uri(URI.create(url))
      request.setHeader("Token", token)
      return  client.send(request.build(), HttpResponse.BodyHandlers.ofString()).body()
    }

    @JvmStatic fun post(url: String, token: String? = "", payload: Any): String {
      val request = HttpRequest.newBuilder().uri(URI.create(url))
      request.setHeader("Token", token)
      request.POST(HttpRequest.BodyPublishers.ofString(ObjectMapper().writeValueAsString(payload)))
      return client.send(request.build(), HttpResponse.BodyHandlers.ofString()).body()
    }

    @JvmStatic fun patch(url: String, token: String? = "", payload: Any? = null): String{
      val request = HttpRequest.newBuilder().uri(URI.create(url))
      request.setHeader("Token", token)
      request.method("PATCH", HttpRequest.BodyPublishers.ofString(ObjectMapper().writeValueAsString(payload)))
      return client.send(request.build(), HttpResponse.BodyHandlers.ofString()).body()
    }

  }


}
