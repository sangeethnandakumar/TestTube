package bullyfox.sangeeth.testube.extended;

import android.content.Context;

import bullyfox.sangeeth.testube.network.WebServer;

/**
 * Created by Sangeeth Nandakumar on 20-05-2017.
 */

public class GoogleDistanceMatrix
{
    String key="NOTHING";
    String olat,olng;
    String dlat,dlng;
    String orgin_address;
    String dest_address;
    String distance;
    String duration;
    Context context;
    OnGDMStatusListner listner;

    public interface OnGDMStatusListner
    {
        public void onGDMAvailable(GoogleDistanceMatrix gdm);
        public void onGDMFailed();
    }

    public GoogleDistanceMatrix(String key,String olat, String olng, String dlat, String dlng, Context context) {
        this.key=key;
        this.olat = olat;
        this.olng = olng;
        this.dlat = dlat;
        this.dlng = dlng;
        this.context = context;
    }

    public GoogleDistanceMatrix() {
    }


    public void setOnGDMStatusListner(OnGDMStatusListner myststus)
    {
        listner=myststus;
    }

    public void getDistanceMatrix()
    {
        WebServer server=new WebServer(context);
        server.setOnServerStatusListner(new WebServer.OnServerStatusListner() {
            @Override
            public void onServerResponded(String responce)
            {
                try
                {
                    GoogleDistanceMatrix gdm=new GoogleDistanceMatrix();
                    String[] details=responce.split("_____");
                    gdm.dest_address=details[0];
                    gdm.orgin_address=details[1];
                    gdm.distance=details[2];
                    gdm.duration=details[3];
                    listner.onGDMAvailable(gdm);
                }
                catch (Exception e)
                {
                    listner.onGDMFailed();
                }
            }

            @Override
            public void onServerRevoked()
            {
            }
        });
        server.connectWithGET("http://sangeethnandakumar.esy.es/PROJECTS/PUBLIC_SERVICE/gdm.php?key="+key+"&olat="+olat+"&olng="+olng+"&dlat="+dlat+"&dlng="+dlng);
    }

    public String getOrgin_address() {
        return orgin_address;
    }

    public String getDest_address() {
        return dest_address;
    }

    public String getDistance() {
        return distance;
    }

    public String getDuration() {
        return duration;
    }
}
