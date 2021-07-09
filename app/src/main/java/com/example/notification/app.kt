package com.example.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class app : Application() {

   companion object{
       val CHANNEL_1_ID : String = "channel1"
       val CHANNEL_2_ID : String = "channel2"
       val GroupCHANNEL_ID : String = "Groupchannel"
       val GroupCHANNEL_ID2 : String = "Groupchannel2"
       val CHANNEL_3_ID : String = "channel3"
       val CHANNEL_4_ID : String = "channel4"
   }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        // we have to check if the api is 26 or higher
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {

            //create notification group
                var group1: NotificationChannelGroup = NotificationChannelGroup(GroupCHANNEL_ID,"group1")
                var group2: NotificationChannelGroup = NotificationChannelGroup(GroupCHANNEL_ID2,"group2")



            // first we assign the notification id
            // second we assign the notification name
            val nameOfChannel = "test1"
            val descriptionChannel = "this is a test channel1"

            // third we assign the importance to determine how much notification should interrupt the user ..
            // IMPORTANCE high makes a sound // medium makes no sound // low makes no sound and do not gives indication that it's been received

            val channel = NotificationChannel(CHANNEL_1_ID,nameOfChannel,NotificationManager.IMPORTANCE_HIGH).apply {
                description = descriptionChannel // here we use "apply" because in java we should make channel.setDescription(descriptionChannel)
                                                // and if we should assign many things it will duplicates object
                group = GroupCHANNEL_ID
            }

            // handle the second channel
            val nameOfChannel2 = "test2"
            val descriptionChannel2 = "this is a test channel2"

            val channel2 = NotificationChannel(CHANNEL_2_ID,nameOfChannel2,NotificationManager.IMPORTANCE_LOW).apply {
                description = descriptionChannel2
                group = GroupCHANNEL_ID
            }

            // channel 3
            // handle the second channel
            val nameOfChannel3 = "test3"
            val descriptionChannel3 = "this is a test channel3"

            val channel3 = NotificationChannel(CHANNEL_3_ID,nameOfChannel3,NotificationManager.IMPORTANCE_LOW).apply {
                description = descriptionChannel3
                group = GroupCHANNEL_ID2
            }

            //channel 4
            // handle the second channel
            val nameOfChannel4 = "test4"
            val descriptionChannel4 = "this is a test channel4"

            val channel4 = NotificationChannel(CHANNEL_4_ID,nameOfChannel4,NotificationManager.IMPORTANCE_HIGH).apply {
                description = descriptionChannel4
            }


            // Register the channel with the system
            val manager : NotificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannelGroup(group1)
            manager.createNotificationChannelGroup(group2)
            manager.createNotificationChannel(channel)
            manager.createNotificationChannel(channel2)
            manager.createNotificationChannel(channel3)
            manager.createNotificationChannel(channel4)



        }
    }
}