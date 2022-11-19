package ERecycle.ERecycle_notification_service.Helpers

abstract class TypeConverterHelper {

  companion object {

    @JvmStatic public fun convertToBoolean(param: Any?): Boolean{
      if(param == false) return false
      return true
    }

  }
}
