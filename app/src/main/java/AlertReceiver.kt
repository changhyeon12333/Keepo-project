import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class AlertReceiver :  BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val notificationHelper = NotificationHelper(context)
        val nb = notificationHelper.channelNotification
        notificationHelper.manager!!.notify(1, nb.build())
    }
}