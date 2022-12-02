package kampus.merdeka.androidexercises.AlarmManager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import androidx.core.content.getSystemService
import kampus.merdeka.androidexercises.R
import java.util.Calendar

class AlarmManagerActivity : AppCompatActivity() {
    var alarmTimePicker : TimePicker? = null
    var pendingIntent : PendingIntent? = null
    var alarmManager : AlarmManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_manager)
        alarmTimePicker = findViewById(R.id.timepicker)
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
    }

    fun onToggleClicked(view: View) {

        var time : Long

        if ((view as ToggleButton).isChecked){
            Toast.makeText(this, "Alarm ON", Toast.LENGTH_SHORT).show()

            var calendar = Calendar.getInstance()

            calendar[Calendar.HOUR_OF_DAY] = alarmTimePicker!!.currentHour
            calendar[Calendar.MINUTE] = alarmTimePicker!!.currentMinute

            val intent = Intent(this,AlarmReceiver::class.java)

            pendingIntent = PendingIntent.getBroadcast(this, 0,intent,0)

            time = calendar.timeInMillis - calendar.timeInMillis % 60000

            if (System.currentTimeMillis() > time){
                time = if (Calendar.AM_PM == 0){
                    time +1000*60*60*12
                }
                else{
                    time + 1000 * 60 * 60 * 24
                }
            }
            alarmManager!!.setRepeating(AlarmManager.RTC_WAKEUP,time,1000,pendingIntent)

        }
        else{
            alarmManager!!.cancel(pendingIntent)
            Toast.makeText(this, "Alarm OFF", Toast.LENGTH_SHORT).show()
        }

    }
}