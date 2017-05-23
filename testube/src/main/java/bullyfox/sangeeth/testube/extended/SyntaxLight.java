package bullyfox.sangeeth.testube.extended;

import android.content.Context;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import bullyfox.sangeeth.testube.network.WebServer;

/**
 * Created by Sangeeth Nandakumar on 23-05-2017.
 */

public class SyntaxLight {
    Context context;
    String language;
    String code;
    OnCodeStatusListner listner;

    public interface OnCodeStatusListner
    {
        void parsedToHTML(String html);
        void parseError();
    }

    public void setOnCodeStatusListner(OnCodeStatusListner listner)
    {
        this.listner=listner;
    }

    public SyntaxLight(Context context, String language, String code) {
        this.context=context;
        this.language = language;
        this.code = code;
    }

    public void highlightCode()
    {
        try
        {
        WebServer server = new WebServer(context);
        server.setOnServerStatusListner(new WebServer.OnServerStatusListner() {
            @Override
            public void onServerResponded(String responce) {
                listner.parsedToHTML(responce);
            }

            @Override
            public void onServerRevoked() {
                listner.parseError();
            }
        });
            String encode= URLEncoder.encode(code);
            String inlink="http://markup.su/api/highlighter/?language="+language.toUpperCase()+"&source="+encode+"&theme=Sunburst";
            Toast.makeText(context, inlink, Toast.LENGTH_SHORT).show();
            server.connectWithGET(inlink);
        }
        catch (Exception e)
        {
        }
    }
}
