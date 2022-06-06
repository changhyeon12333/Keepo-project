package com.example.keepo_app

import AlertReceiver
import TimePickerFragment
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*


class AlarmActivity : AppCompatActivity(), OnTimeSetListener {
    private var time_text: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        time_text = findViewById(R.id.time_text)
        val time_btn = findViewById<Button>(R.id.time_btn)

        //시간 설정
        time_btn.setOnClickListener {
            val timePicker: DialogFragment = TimePickerFragment()
            timePicker.show(supportFragmentManager, "time picker")
        }

        //알람 취소
        val alarm_cancel_btn = findViewById<Button>(R.id.alarm_cancel_btn)
        alarm_cancel_btn.setOnClickListener { cancelAlarm() }

        val actionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar!!.hide()
    }

    /**
     * 시간을 정하면 호출되는 메소드
     * @param view 화면
     * @param hourOfDay 시간
     * @param minute 분
     */
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        Log.d(AlarmActivity.Companion.TAG, "## onTimeSet ## ")
        val c = Calendar.getInstance()
        c[Calendar.HOUR_OF_DAY] = hourOfDay
        c[Calendar.MINUTE] = minute
        c[Calendar.SECOND] = 0

        //화면에 시간지정
        updateTimeText(c)

        //알람설정정
        startAlarm(c)
    }

    /**
     * 화면에 사용자가 선택한 시간을 보여주는 메소드
     * @param c 시간
     */
    private fun updateTimeText(c: Calendar) {
        Log.d(AlarmActivity.Companion.TAG, "## updateTimeText ## ")
        var timeText: String? = "스트레칭 시간: "
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.time)
        time_text!!.text = timeText
    }

    /**
     * 알람 시작
     * @param c 시간
     */
    private fun startAlarm(c: Calendar) {
        Log.d(AlarmActivity.Companion.TAG, "## startAlarm ## ")
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlertReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1)
        }

        //RTC_WAKE : 지정된 시간에 기기의 절전 모드를 해제하여 대기 중인 인텐트를 실행
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.timeInMillis, pendingIntent)
    }

    /**
     * 알람 취소
     */
    private fun cancelAlarm() {
        Log.d(AlarmActivity.Companion.TAG, "## cancelAlarm ## ")
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlertReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)
        alarmManager.cancel(pendingIntent)
        time_text!!.text = "스트레칭 시간 재설정이 필요합니다"
    }

    companion object {
        const val TAG = "MAIN"
    }
}
