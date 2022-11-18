package ERecycle.ERecycle_notification_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ERecycleNotificationServiceApplication{
  companion object {
    @JvmStatic fun main(args: Array<String>) {
      runApplication<ERecycleNotificationServiceApplication>(*args)
    }
  }
}


