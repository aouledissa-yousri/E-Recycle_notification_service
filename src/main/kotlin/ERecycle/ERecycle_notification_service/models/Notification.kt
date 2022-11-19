package ERecycle.ERecycle_notification_service.models

class Notification (public val description: String?, public val date: String?, public val checked: Boolean) {

  companion object {
    @JvmStatic
    public fun createNotification(description: String?, date: String?, checked: Boolean): Notification{
      return Notification(description, date, checked)
    }

  }


}
