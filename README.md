
# NOTIFICATIONS

![App Screenshot](https://miro.medium.com/max/875/0*HUEWSYjjJllE9j9E.png)

1 - Small icon:set by using setSmallIcon()

2 - App Name: This is provided by the system.

3 - Timestamp: This is provided by the system but you can override it with setWhen() or hide it with setShowWhen(false).

4 - Large icon: This is optional (usually used only for contact photos; do not use it for your app icon) and set with setLargeIcon().

5 - Title: This is optional and set with setContentTitle().

6 - Text: This is optional and set with setContentText().
_________

if the api more than 26 we should create Notification Channel else we should build notification instead..

#### so what is Notification Channel ...

Notification Channel came with Android 8.0 Oreo , The idea is that apps can group different types of notifications into “channels.” Each channel can then be turned on or off by the user. This all happens in the Android settings.

![App Screenshot](https://www.howtogeek.com/wp-content/uploads/2021/02/2021-02-25_15-35-35.png?trim=1,1&bg-color=000&pad=1,1)

any app is system is displayed using system Service Called Notification
Manager

Service : is a component wich runs in the background without direct interaction
with the user and has no UI

any application wants to interact with service must has its own instance of a Manager.

## Where these managers come from ?
ContextImpl has a reference to something called System Service Registry

ContextImpl is implementing all Context abstract functions and ContextWrapper wraps all functions from Context abstract Class using ContextImpl implementation

all individual managers in existing in System service Registry like notification managers and Alarm Manager

System Service started by Android System itself and is not part of your application , so they two different processes on the system
here comes Binder IPC (Inter process communicate)

Pending Intent : it is Wrapper around regular intent that is desgined to be used by another app






