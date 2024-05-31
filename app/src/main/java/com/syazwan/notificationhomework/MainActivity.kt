package com.syazwan.notificationhomework

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun courseupdate(view: View){

            //create the notification channel

            val channel_id = "channel 01"
            val channel_Name = "Notification"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(channel_id,channel_Name,importance)
            mChannel.description = "test description"
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)

            //use notification.builder to generate your notification message

            val notification: Notification = Notification.Builder(this,channel_id)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Android ATC New Notification")
                .setContentText("Check Android ATC New Course!!")
                .build()

            //register the channek with Android system

            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        mNotificationManager.createNotificationChannel(mChannel)
        //Show the notification
        mNotificationManager.notify(1,notification)
    }
}