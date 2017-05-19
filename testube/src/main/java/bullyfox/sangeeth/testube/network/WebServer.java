package bullyfox.sangeeth.testube.network;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sangeeth Nandakumar on 18-05-2017.
 */

public class WebServer
{
    private Context context;

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

    public void getWebpage(String url)
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

}
