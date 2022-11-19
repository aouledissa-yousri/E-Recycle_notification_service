package ERecycle.ERecycle_notification_service

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

  }


}
