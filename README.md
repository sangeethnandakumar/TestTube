# Introducing TestTube
The TestTube library project for easy Android implimentations

[![](https://jitpack.io/v/sangeethnandakumar/TestTube.svg)](https://jitpack.io/#sangeethnandakumar/TestTube)
[![Travis branch](https://img.shields.io/badge/devolopment-android%20studio-brightgreen.svg)]()
[![Travis branch](https://img.shields.io/badge/package-bullyfox.sangeeth.testube-blue.svg)]()
[![Travis branch](https://img.shields.io/badge/year-2017-red.svg)]()

## GET A WEBPAGE (network)
1. Create a WebServer instance
```java
        WebServer web=new WebServer(getApplicationContext());
```
2. Attach a status lister to our server
```java
        web.setOnServerStatusListner(new WebServer.OnServerStatusListner() {
            @Override
            public void onServerResponded(String responce) {
            
            }

            @Override
            public void onServerRevoked() {

            }
        });
```
3. Now just connect to the server
```java
        web.getWebpage("https://www.google.com");
```
That's it. The responce from the server will be available on the listner as soon as the server responded.
Included libraries : Google Volley
## DOWNLOAD A FILE (network)
That's it. The responce from the server will be available on the listner as soon as the server responded.
Included libraries : Easy FTP
## UPLOAD A FILE (network)
