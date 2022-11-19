package ERecycle.ERecycle_notification_service.responses

import ERecycle.ERecycle_notification_service.models.Notification

class ValidGetNotificationsResponse(public val notifications: ArrayList<Notification>, public val unchecked: Int) {}
