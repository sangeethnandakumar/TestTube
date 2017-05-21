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
        allprojects
	{
		repositories 
		{
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
2. In app/module level Gradle, add
```gradle
        dependencies 
	{
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
3. Create a SimpleAdapter
```java
        SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),simpleItems, AdapterType.LISTVIEW, AdapterLayering.LINEAR);
```
4. Just attach the Adapter to your listview and its over
```java
        list.setAdapter(simpleAdapter);
```
### You done everything.!!!, For further minimal customizing
a) Add optional resource image if you want it
```java
        simpleItems.add(new SimpleItem("Lotus Flower",R.drawable.lotus));
        simpleItems.add(new SimpleItem("Lilly Flower",R.drawable.lilly));
        simpleItems.add(new SimpleItem("Rose Flower",R.drawable.rose));
```
b) Add optional web image if you want it (requires internet)
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
### Another way
a) You can change the AdapterLayering to CARD if you need it
```java
        SimpleAdapter simpleAdapter=new SimpleAdapter(getApplicationContext(),simpleItems, AdapterType.LISTVIEW, AdapterLayering.CARD);
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
## PERMANANT SETTINGS FOR YOUR APP (managers)
![App Settings Demo](https://github.com/sangeethnandakumar/TestTube/blob/master/AppSettings.gif)

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

## GOOGLE DISTANCE MATRIX FOR YOUR ADDRESSES (extended)
New feature that brings you the address of locations, distance to travel on road along with units and time to travel along with units from Google Servers in its most simplest way

0. Look at the GoogleDistanceMatrix class initialisation syntax
```java
	GoogleDistanceMatrix gdm=new GoogleDistanceMatrix("<YOUR_GOOGLE_KEY>","<ORIGIN_LATTITUDE>","<ORIGIN_LONGITUDE>","<DESTINATION_LATTITUDE>","<DESTINATION_LONGITUDE>",<ANY CONTEXT>);

```
1. Now initialise it as depected
```java
	//Initialise key. You will get this key from here : https://developers.google.com/maps/documentation/distance-matrix/get-api-key
	String key = "ABcdEfGHIJ7L4YhXw01INDIAHbVlgIhjmouSeVc";
	
	//Set origin to 
	String origin_lat="36.752071";
	String origin_lng="-119.823064";
	// Set destination to 
	String dest_lat="36.773276";
	String dest_lng="-119.845252";
	
	GoogleDistanceMatrix gdm = new GoogleDistanceMatrix(key,origin_lat,origin_lng,dest_lat,dest_lng,getApplicationContext());

```
2. Simplicity starts right now. Attach that listner
```java
	gdm.setOnGDMStatusListner(new GoogleDistanceMatrix.OnGDMStatusListner()
	{
		@Override
		public void onGDMAvailable(GoogleDistanceMatrix gdm)
		{
			//Quickly collect details
                        String origin_address = gdm.getOrgin_address();
                        String dest_address = gdm.getDest_address();
                        String distance = gdm.getDistance();
                        String duration = gdm.getDuration();
                }
		
                @Override
                public void onGDMFailed()
                {
                       //Failed due to some resons
                }
         });
```
3. Now send that request to GoogleServers via Our server (Complex codes are implimented on our server to keep you smiling). Now just request.!
```java
	gdm.getDistanceMatrix();
```
NOTE : Details will be arrived at the listners as soon us our server sends it back

## DOWNLOAD A FILE (network)
![File Downloading Demo](https://github.com/sangeethnandakumar/TestTube/blob/master/FileDownloader.gif)

Thinking for an ultimate simple way to download an file from an URL? With multithreading and simultanious download features, Here comes the new FileDownloader class
0. Look at the initialisation syntax
```java
	FileDownloader downloader=new FileDownloader(<ANY_CONTEXT>,"<DOWNLOAD_FOLDERNAME>","<DOWNLOAD_FILENAME>");
```
1. Now initialise the object like before
```java
	FileDownloader downloader=new FileDownloader(getApplicationContext(),"/storage/emulated/0/GLOBAL","myfile.pdf");
```
2. Keep track of downloader with these event listners
```java
                downloader.setOnDownloadStatusListner(new FileDownloader.OnDownloadStatusListner() {
                    @Override
                    public void onStarted()
                    {
                    }

                    @Override
                    public void onConnecting()
                    {
                    }

                    @Override
                    public void onConnected(long total, boolean isRangeSupport)
                    {
                    }

                    @Override
                    public void onDownloading(long finished, long total, int progress)
                    {
                    }

                    @Override
                    public void onCompleted()
                    {
                    }

                    @Override
                    public void onFailed(String message)
                    {
                    }

                    @Override
                    public void onPaused()
                    {
                    }

                    @Override
                    public void onCancelled()
                    {
                    }
                });

```
3. This is the last step to download. So simple...
```java
	downloader.downloadFile("https://www.ece.jhu.edu/~cooper/courses/214/signalsandsystemsnotes.pdf");
```
NOTE : The construction and devolopment of this class is in BETA. Unfortunatelly, Pause and Cancel is not working as of now. You can use without any other problems. Pause and Cancel support will be added soon.

## HTTP GET REQUEST (network)
![Http GET Demo](https://github.com/sangeethnandakumar/TestTube/blob/master/HttpGET.gif)

Http GET methord requests a server with inline parameters on its URL. DOn't use Http GET to transfer passwords!. Http GET is best for visible parameters and easy to debug
1. Initialise a WebServer instance and start its listners
```java
		WebServer server=new WebServer(getApplicationContext());
                
                server.setOnServerStatusListner(new WebServer.OnServerStatusListner() {
                    @Override
                    public void onServerResponded(String responce) {
                        
                    }

                    @Override
                    public void onServerRevoked() {

                    }
                });
````
2. Now just call the server with GET parameters
```java
		server.connectWithGET("https://www.google.com/test.php?name=Sangeeth&loc=India");
````


## HTTP POST REQUEST (network)
![Http GET Demo](https://github.com/sangeethnandakumar/TestTube/blob/master/HttpPOST.gif)

Http POST methord requests a server with unvisible parameters. Usefull to transport passwords.
1. Initialise a WebServer instance and start its listners
```java
		WebServer server=new WebServer(getApplicationContext());
                
                server.setOnServerStatusListner(new WebServer.OnServerStatusListner() {
                    @Override
                    public void onServerResponded(String responce) {
                        
                    }

                    @Override
                    public void onServerRevoked() {

                    }
                });
````
3. Create a list of DataRack for your key-value pairs
```java
                List<DataRack> racks=new ArrayList<DataRack>();
                racks.add(new DataRack("name","Simon"));
                racks.add(new DataRack("age","40"));
                racks.add(new DataRack("location","Canada"));
````
2. Now just call the server with POST rack along caller activity
```java
                server.connectWithPOST(MainActivity.this,"http://sangeethnandakumar.esy.es/PROJECTS/PUBLIC_SERVICE/posttest.php",racks);
````
