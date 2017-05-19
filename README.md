# Introducing TestTube
The TestTube library project for easy Android implimentations

[![](https://jitpack.io/v/sangeethnandakumar/TestTube.svg)](https://jitpack.io/#sangeethnandakumar/TestTube)
[![Travis branch](https://img.shields.io/badge/devolopment-android%20studio-brightgreen.svg)]()
[![Travis branch](https://img.shields.io/badge/package-bullyfox.sangeeth.testube-blue.svg)]()
[![Travis branch](https://img.shields.io/badge/year-2017-red.svg)]()

![TestTube Logo](https://github.com/sangeethnandakumar/TestTube/blob/master/logo.png)

# Include the Gradle Dependency
1. On project level Gradle, add
```gradle
        allprojects {
	        repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
2. Add app/module level Gradle, add
```gradle
        dependencies {
	        compile 'com.github.sangeethnandakumar:TestTube:[LATEST_VERSION]' 
	}
```
3. **LATEST_VERSION (Use this version on dependency)** : [![](https://jitpack.io/v/sangeethnandakumar/TestTube.svg)](https://jitpack.io/#sangeethnandakumar/TestTube)

Library Version | Improvements | Dependency
------------ | ------------- | -------------
Prior to v2.0.1 | Not available on GitHub | Not available on GitHub
v2.0.1 | FTP connections now made easy. Another WebServer class devoloped to easly connect and download a webpage source code | com.github.sangeethnandakumar:TestTube:v2.0.1

Important:

[![Travis branch](https://img.shields.io/badge/compiled%20sdk-25-brightgreen.svg)]()
[![Travis branch](https://img.shields.io/badge/min%20sdk-18-brightgreen.svg)]()
[![Travis branch](https://img.shields.io/badge/target%20sdk-25-brightgreen.svg)]()
[![Travis branch](https://img.shields.io/badge/min%20android%20OS-Android%204.3%20Jellybean-brightgreen.svg)]()


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
