import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class NotificationHelper(base: Context?) : ContextWrapper(base) {
    private var notiManager: NotificationManager? = null
    @RequiresApi(api = Build.VERSION_CODES.O)
    fun createChannels() {
        val channel1 =
            NotificationChannel(channeID, channeNm, NotificationManager.IMPORTANCE_DEFAULT)
        channel1.enableLights(true)
        channel1.enableVibration(true)
        channel1.lightColor = R.color.black
        channel1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        manager!!.createNotificationChannel(channel1)
    }

    val manager: NotificationManager?
        get() {
            if (notiManager == null) {
                notiManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            }
            return notiManager
        }
    val channelNotification: NotificationCompat.Builder
        get() = NotificationCompat.Builder(applicationContext, channeID)
            .setContentTitle("알람")
            .setContentText("알람매니저 실행중")

    companion object {
        const val channeID = "channelID"
        const val channeNm = "channelNm"
    }

    init {

        //안드로이드 버전이 오레오거나 이상이면 채널생성성
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels()
        }
    }
}