package bullyfox.sangeeth.testube.network;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sangeeth Nandakumar on 20-05-2017.
 */

public class WebDoc {
    Context context;
    String weburl;
    OnDocumentStatusListner listner;

    public WebDoc(Context context, String weburl) {
        this.context = context;
        this.weburl = weburl;
    }

    public interface OnDocumentStatusListner
    {
        void onDownloadAvailable(FileDownloader downloader);
        void onDownloadNotAvailable();
    }

    public void setOnDocumentStatusListner(OnDocumentStatusListner listner)
    {
        this.listner=listner;
    }

    public void startConversion()
    {
        WebServer server=new WebServer(context);
        server.setOnServerStatusListner(new WebServer.OnServerStatusListner() {
            @Override
            public void onServerResponded(String responce) {
                if (responce.equals("success"))
                {
                    FileDownloader downloader=new FileDownloader(context,"http://sangeethnandakumar.esy.es/PROJECTS/PUBLIC_SERVICE/dump.pdf");
                    listner.onDownloadAvailable(downloader);
                }
                else
                {
                    listner.onDownloadNotAvailable();
                }
            }

            @Override
            public void onServerRevoked() {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        server.connectWithGET("http://sangeethnandakumar.esy.es/PROJECTS/PUBLIC_SERVICE/web2pdf.php?webpage="+weburl);
    }

}
