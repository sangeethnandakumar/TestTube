package bullyfox.sangeeth.testube.network;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.File;
import java.net.URL;
import java.util.List;

import bullyfox.sangeeth.testube.component.DataRack;
import cz.msebera.android.httpclient.Header;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * Created by Sangeeth Nandakumar on 18-05-2017.
 */

public class WebServer
{
    private Context context;
    String posturl;

    public interface OnServerStatusListner
    {
        public void onServerResponded(String responce);
        public void onServerRevoked();
    }

    private OnServerStatusListner listner;

    public void setOnServerStatusListner(OnServerStatusListner myststus)
    {
        listner=myststus;
    }

    public WebServer(Context context)
    {
        this.context = context;
    }

    public void connectWithGET(String url)
    {
        //Create a request queue
        RequestQueue queue= Volley.newRequestQueue(context);
        //Tunnel the request
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                //When request success
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        listner.onServerResponded(response);
                    }
                },
                //When request fails
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        listner.onServerRevoked();
                    }
                });
        //Add the request to queue
        queue.add(stringRequest);
    }

    public void connectWithPOST(Activity myactivity, String url, List<DataRack> dataRacks)
    {
        PostWorker worker=new PostWorker(context,myactivity,url,dataRacks);
        worker.setOnPostStatusListner(new PostWorker.OnPostStatusListner() {
            @Override
            public void onPostSuccess(String responce) {
                listner.onServerResponded(responce);
            }

            @Override
            public void onPostFailed() {
                listner.onServerRevoked();
            }
        });
        worker.execute(url);
    }

    public void connectWithPOST(Activity myactivity, String url, String fileparameter,String filepath)
    {
        SyncHttpClient client = new SyncHttpClient();
        RequestParams params = new RequestParams();
        try{params.put(fileparameter, new File(filepath));}catch (Exception e){};

        client.post(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                listner.onServerRevoked();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                listner.onServerResponded(responseString);
            }
        });
    }



}
