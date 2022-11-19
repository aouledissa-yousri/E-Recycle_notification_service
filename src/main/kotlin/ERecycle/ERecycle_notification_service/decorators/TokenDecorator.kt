package ERecycle.ERecycle_notification_service.decorators

abstract class TokenDecorator {

  companion object {

    @JvmStatic
    public fun checkAccessToken(token: String): String{
      return "Invalid Token"
    }

  }

}
