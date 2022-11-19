package ERecycle.ERecycle_notification_service.payloads

import ERecycle.ERecycle_notification_service.models.Notification

class AddMakeRecycleRequestNotificationPayload(val notification: Notification) {

  companion object {

    @JvmStatic public fun createAddMakeRecycleRequestPayload(notification: Notification): AddMakeRecycleRequestNotificationPayload{
      return createAddMakeRecycleRequestPayload(notification)
    }

  }


}
