package com.example.notification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import com.example.notification.app.Companion.CHANNEL_1_ID
import com.example.notification.app.Companion.CHANNEL_2_ID
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        notificationManager = NotificationManagerCompat.from(this)
        binding.channe1Btn.setOnClickListener { sendOnChannel1() }
        binding.channe2Btn.setOnClickListener { sendOnChannel2() }
        binding.channe1Btn3.setOnClickListener { ChannelWithBigPicture() }
        binding.channe2Mediastyle.setOnClickListener { sendOnChannel2MediaStyle() }


    }

    private fun sendOnChannel2() {
        var str1: String = binding.title.text.toString()
        var str2: String = binding.message.text.toString()
        val builder: Notification = NotificationCompat.Builder(this, CHANNEL_2_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(str1)
            .setContentText(str2)
            .setStyle(NotificationCompat.InboxStyle()
                .addLine("This is Line")
                .addLine("This is Line")
                .addLine("This is Line")
                .addLine("This is Line")
                .addLine("This is Line")
                .addLine("This is Line")
                .setBigContentTitle("Big Content Title")
                .setSummaryText("Summary Text")
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .build()

        notificationManager.notify(2, builder)
    }

    private fun sendOnChannel1() {
        var str1: String = binding.title.text.toString()
        var str2: String = binding.message.text.toString()


        // Start a new Activity
        var intent: Intent = Intent(this, MainActivity::class.java)
        var pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)


        // Start a Broadcast
        // the default behavior when tapping a notification is opening a activity  if u want different action then write your own Broadcast ..
        val i = Intent(this, NotificationReceiver::class.java)
        i.putExtra("toastMessage", str2)
        // here i used "PendingIntent.FLAG_UPDATE_CURRENT" to request that system update the existing PendingIntent with the new extra data
        // rather than storing a new PendingIntent
        val pendingIntentReceiver: PendingIntent = PendingIntent.getBroadcast(this, 1, i, PendingIntent.FLAG_UPDATE_CURRENT)

        // setting Large Icon / Image
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.cat)

        val builder: Notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(str1)
            .setContentText(str2)
            .setLargeIcon(bitmap) // setting the large icon
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(getString(R.string.notification_content_string)) // description under BigContentTitle
                    .setBigContentTitle("Big Content Title") // when it collapsed the title wii change
                    .setSummaryText("Summary Text") // the text besides app name
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent) // when click on the whole message will move to the MainActivity
            .addAction(
                R.drawable.ic_launcher_foreground,
                "Button",
                pendingIntentReceiver
            ) // When click on the button "Button"
            .setColor(Color.RED)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .build()

        notificationManager.notify(1, builder)
    }

    private fun ChannelWithBigPicture() {
        var str1: String = binding.title.text.toString()
        var str2: String = binding.message.text.toString()


        // Start a new Activity
        var intent: Intent = Intent(this, MainActivity::class.java)
        var pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)


        // setting Large Icon / Image
        var picture = BitmapFactory.decodeResource(resources, R.drawable.cat)

        val builder: Notification = NotificationCompat.Builder(this, CHANNEL_1_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(str1)
            .setContentText(str2)
            .setLargeIcon(picture) // setting the large icon
            .setStyle(
               NotificationCompat.BigPictureStyle()
                   .bigPicture(picture)
                   .bigLargeIcon(null) // make it null because when big picture show , the large icon disappear

            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent) // when click on the whole message will move to the MainActivity
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .build()

        notificationManager.notify(1, builder)
    }

    private fun sendOnChannel2MediaStyle() {
        var str1: String = binding.title.text.toString()
        var str2: String = binding.message.text.toString()

        var artwork = BitmapFactory.decodeResource(resources, R.drawable.cat)


        val builder: Notification = NotificationCompat.Builder(this, CHANNEL_2_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(str1)
            .setContentText(str2)
            .addAction(R.drawable.ic_previous,"Previous",null)
            .addAction(R.drawable.ic_pause,"pause",null)
            .addAction(R.drawable.ic_next,"next",null)
            .setLargeIcon(artwork)
            .setStyle(
                androidx.media.app.NotificationCompat.MediaStyle()
            )
            .setSubText("Sub text")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .build()

        notificationManager.notify(2, builder)
    }



}