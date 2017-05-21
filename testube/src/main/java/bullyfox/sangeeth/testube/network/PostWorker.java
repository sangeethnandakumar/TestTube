package bullyfox.sangeeth.testube.network;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import bullyfox.sangeeth.testube.component.DataRack;
import bullyfox.sangeeth.testube.options.PostMode;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * Created by Sangeeth Nandakumar on 21-05-2017.
 */

class PostWorker extends AsyncTask<String,Integer,String>
{
    Context context;
    String url;
    Activity myactivity;
    OnPostStatusListner listner;
    List<DataRack> dataRacks;
    PostMode mode;
    File file;
    String filename;

    public interface OnPostStatusListner
    {
        void onPostSuccess(String responce);
        void onPostFailed();
    }

    public void setOnPostStatusListner(OnPostStatusListner listner)
    {
        this.listner = listner;
    }

    public PostWorker(Context context,Activity myactivity,String url,List<DataRack> dataRacks) {
        super();
        this.context=context;
        this.myactivity=myactivity;
        this.url=url;
        this.dataRacks=dataRacks;
        mode=PostMode.DATARACK;
    }

    public PostWorker(Context context,Activity myactivity,String url,File file,String filename) {
        super();
        this.context=context;
        this.myactivity=myactivity;
        this.url=url;
        this.file=file;
        this.filename=filename;
        mode=PostMode.FILE;
    }

    @Override
    protected String doInBackground(String... strings)
    {
                try
                {
                    OkHttpClient client = new OkHttpClient();
                    MultipartBody.Builder body = new MultipartBody.Builder();

                    if (mode==PostMode.DATARACK)
                    {
                        body.setType(MultipartBody.FORM);
                        for (int i = 0; i < dataRacks.size(); i++)
                        {
                            body.addFormDataPart(dataRacks.get(i).getName(), dataRacks.get(i).getValue());
                        }
                    }
                    else if (mode==PostMode.FILE)
                    {
                        body.setType(MultipartBody.FORM)
                                .addFormDataPart("file", filename, RequestBody.create(MediaType.parse("image/gif"), file));
                    }

                    RequestBody requestBody = body.build();

                    okhttp3.Request request = new okhttp3.Request.Builder()
                            .url(url)
                            .method("POST", RequestBody.create(null, new byte[0]))
                            .post(requestBody)
                            .build();
                    okhttp3.Response response = client.newCall(request).execute();
                    final String res=response.body().string();
                    myactivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listner.onPostSuccess(res);
                        }
                    });
                }
                catch (final Exception e)
                {
                    myactivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(myactivity, e.toString(), Toast.LENGTH_SHORT).show();
                            listner.onPostFailed();
                        }
                    });
                }
        return null;
    }
}