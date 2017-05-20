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
2. In app/module level Gradle, add
```gradle
        dependencies {
	        compile 'com.github.sangeethnandakumar:TestTube:[LATEST_VERSION]' 
	}
```
3. **LATEST_VERSION (Use this version on dependency)** : [![](https://jitpack.io/v/sangeethnandakumar/TestTube.svg)](https://jitpack.io/#sangeethnandakumar/TestTube)

Library Version | Improvements | Dependency
------------ | ------------- | -------------
Prior to v2.0.1 | Not available on GitHub | Not available on GitHub
v2.0.1 | First update on GitHub. Added support for Standard ListVIew item | com.github.sangeethnandakumar:TestTube:v2.0.1
v2.0.2/6 | Minor bug fixes and improvements | Depreciated
v2.1.0 | First minor update. Added support for Standard GridView item, Standard GridView item layering on LINEAR/CARD, Added Permit class to easly ask Android runtime permissions, Added WebServer class to easly request and download the website (source)  | com.github.sangeethnandakumar:TestTube:v2.1.0

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
        SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),simpleItems, AdapterType.LISTVIEW, AdapterLayering.LINEAR);
```
a) You can change the AdapterLayering to CARD if you need it
```java
        SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),simpleItems, AdapterType.LISTVIEW, AdapterLayering.CARD);
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
	
        DualAdapter dualAdapter=new DualAdapter(getApplicationContext(),dualItems,AdapterType.LISTVIEW,AdapterLayering.CARD);
	
	list.setAdapter(dualAdapter);
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
	
        TripleAdapter tripleAdapter=new TripleAdapter(getApplicationContext(),tripleItems,AdapterType.LISTVIEW,AdapterLayering.LINEAR);
	
	list.setAdapter(tripleAdapter);
```
NOTE : Images from resources and web are also compatable here

## SIMPLE/DUAL/TRIPLE STANDARD GRIDVIEW (adapter)
Like Simple/Dual/Tripple Standard listview before, Simple change this to make into a GridView
1. Previous statements are same except here
```java
        DualAdapter dualAdapter=new DualAdapter(getApplicationContext(),dualItems,AdapterType.GRIDVIEW,AdapterLayering.CARD);
	grid.setAdapter(dualAdapter);
```
## ASKING RUNTIME PERMISSIONS (permissions)
Android runtime permissions are no longer RoCketScience
1. Initialise the Permit object, passing your current activity
```java
	Permit permit=new Permit(MainActivity.this);
```
2. Simply listen to the permission events using event listner
```java
                permit.setOnPermitStatusListner(new Permit.OnPermitStatusListner()
                {
                    @Override
                    public void onAllPermitsGranded()
                    {
                        // ALL PERMITS ACCEPTED
                    }

                    @Override
                    public void onSomePermitsDenied(ArrayList<String> deniedPermits)
                    {
                       // SOME PERMITS ACCEPTED
                    }

                    @Override
                    public void onAllPermitsDenied()
                    {
                        // ALL PERMITS DENIED
                    }
                });
```
3. Now just ask for what permissions you need. Yes, It's over
```java
                permit.askPermitsFor(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.READ_CONTACTS);
```
## YOUR APPLICATION SETTINGS (managers)
1. Wan't to store/retrive your application settings? Simple initialise the AppSettings class with any context
```java
	AppSettings settings=new AppSettings(getApplicationContext());
```
2. Store what all stuffs you want like (KEY-VALUE) style
```java
                settings.saveSettings("username","sangeeth");
                settings.saveSettings("password","sangeeth@123");
                settings.saveSettings("points","250");
                settings.saveSettings("level","5");
                settings.saveSettings("gender","male");
```
3. Retrive what all stored
```java
                String username=settings.retriveSettings("username");
                Toast.makeText(MainActivity.this, "Username is - " + username, Toast.LENGTH_SHORT).show();
```
NOTE : The settings stores here will persist even the app is closed. (Until uninstalled)

## AUTOSTACK FOR YOUR PAGE MANAGEMENTS (managers)
Its simply a string stack. When you are on a page, then push that PAGE_KEY. When user press BACK button, pop out the PAGE_KEY and check. If nothing to pop out, exit the app. Don't undersatand? It's simple like catching a frog from your pond.
1. Just initialise the AutoStack
```java
	AutoStack stack=new AutoStack();
```
2. Push while you traverse each pages of something (Assume a book)
```java
                // Assume user is presented with a menu
                // As he enters each menu another menu is appearing (Like a directory)

                // User at page SPACE (SPACE)
                page.push("space");
                // User clicks on EARTH (SPACE/EARTH)
                page.push("earth");
                // User clicks on ASIA (SPACE/EARTH/ASIA)
                page.push("asia");
                // User clicks on INDIA (SPACE/EARTH/ASIA/INDIA)
                page.push("india");
```
3. Override the onBackPressed() methord of your activity
```java
    @Override
    public void onBackPressed()
    {
        if (page.isEmpty())
        {
            super.onBackPressed();
        }
        else
        {
            switch (page.pop())
            {
                case "india" :
                    showAsiaMenu();
                    break;
                case "asia" :
                    showEarthMenu();
                    break;
                case "space" :
                    showSpaceMenu();
                    break;
            }
        }
    }
```
NOTE : STACK space used is not persistant and will be cleared when app restarts or context switched
