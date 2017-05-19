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

#

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

## SIMPLE STANDARD LISTVIEW (adapter)
Its very simple to use a standard list now
1. Declare your listview
```java
        ListView list=(ListView)findViewById(R.id.listview);
```
2. Add your items in a SimpleItem list
```java
        List<SimpleItem> simpleItems=new ArrayList<>();
        simpleItems.add(new SimpleItem("United States"));
        simpleItems.add(new SimpleItem("India"));
        simpleItems.add(new SimpleItem("Russia"));
        simpleItems.add(new SimpleItem("China"));
```
a) Add optional resource image if you want it
```java
        simpleItems.add(new SimpleItem("Lotus Flower",R.drawable.lotus));
        simpleItems.add(new SimpleItem("Lilly Flower",R.drawable.lilly));
        simpleItems.add(new SimpleItem("Rose Flower",R.drawable.rose));
```
b) Add optional web image if you want it
```java
        simpleItems.add(new SimpleItem("Google","https://www.google.com/something.png"));
        simpleItems.add(new SimpleItem("Facebook","https://www.facebook.com/something.png"));
        simpleItems.add(new SimpleItem("YouTube","https://www.youtube.com/something.png"));   
```
c) Feel free to mix all these
```java
        simpleItems.add(new SimpleItem("Simply text"));
        simpleItems.add(new SimpleItem("Resource image",R.drawable.elephant));
        simpleItems.add(new SimpleItem("Web image","https://www.google.com/something.png"));
```
3. Create a SimpleAdapter
```java
        SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),simpleItems, AdapterType.LISTVIEW);
```
4. Just attach the Adapter to your listview and its over
```java
        list.setAdapter(simpleAdapter);
```
## DUAL STANDARD LISTVIEW (adapter)
Like Simple Standard listview before, Use a standard dual list view
1. Previous statements are same except here
```java
        List<DualItem> dualItems=new ArrayList<>();
        dualItems.add(new DualItem("Samsung","User in Korea"));
        dualItems.add(new DualItem("Pixel","User in California"));
        dualItems.add(new DualItem("Sony Xperia","User in Japan"));
        DualAdapter dualAdapter=new DualAdapter(getApplicationContext(),dualItems,AdapterType.LISTVIEW);
	list.setAdapter(simpleAdapter);
```
NOTE : Images from resources and web are also compatable here

## TRIPLE STANDARD LISTVIEW (adapter)
Like Dual Standard listview before, Use a standard triple list view
1. Statements are changed like
```java
        List<TripleItem> tripleItems=new ArrayList<>();
        tripleItems.add(new TripleItem("Billy","Cat","At Kerala"));
        tripleItems.add(new TripleItem("Snoory","Cat","At Banglore"));
        tripleItems.add(new TripleItem("Dingi","Dog","At Mumbai"));
        tripleItems.add(new TripleItem("Pupy","Dog","At Jammu"));
        TripleAdapter tripleAdapter=new TripleAdapter(getApplicationContext(),tripleItems,AdapterType.LISTVIEW);
```
NOTE : Images from resources and web are also compatable here
