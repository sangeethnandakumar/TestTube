package bullyfox.sangeeth.testube.network;

import android.content.Context;
import android.widget.Toast;

import com.aspsine.multithreaddownload.CallBack;
import com.aspsine.multithreaddownload.DownloadConfiguration;
import com.aspsine.multithreaddownload.DownloadException;
import com.aspsine.multithreaddownload.DownloadManager;
import com.aspsine.multithreaddownload.DownloadRequest;

import java.io.File;

/**
 * Created by Sangeeth Nandakumar on 20-05-2017.
 */

public class FileDownloader {
    Context context;
    String downloadURL;
    String storageLocation;
    String filename;
    OnDownloadStatusListner listner;

    public interface OnDownloadStatusListner
    {
        void onStarted();
        void onConnecting();
        void onConnected(long total, boolean isRangeSupport);
        void onDownloading(long finished, long total, int progress);
        void onCompleted();
        void onFailed(String errormsg);
        void onPaused();
        void onCancelled();
    }

    public void setOnDownloadStatusListner(OnDownloadStatusListner listner)
    {
        this.listner=listner;
    }

    public FileDownloader(Context context, String storageLocation, String filename) {
        this.context = context;
        this.storageLocation = storageLocation;
        this.filename = filename;
    }

    public void downloadFile(String url)
    {
        downloadURL=url;
        DownloadConfiguration configuration = new DownloadConfiguration();
        configuration.setMaxThreadNum(10);
        configuration.setThreadNum(3);
        DownloadManager.getInstance().init(context, configuration);

        final DownloadRequest request = new DownloadRequest.Builder()
                .setName(filename)
                .setUri(downloadURL)
                .setFolder(new File(storageLocation))
                .build();

        DownloadManager.getInstance().download(request, url, new CallBack() {
            @Override
            public void onStarted() {
               listner.onStarted();
            }

            @Override
            public void onConnecting() {
                listner.onConnecting();
            }

            @Override
            public void onConnected(long total, boolean isRangeSupport) {
                listner.onConnected(total,isRangeSupport);
            }

            @Override
            public void onProgress(long finished, long total, int progress) {
                listner.onDownloading(finished,total,progress);
            }

            @Override
            public void onCompleted() {
                listner.onCompleted();
            }

            @Override
            public void onDownloadPaused() {
                listner.onPaused();
            }

            @Override
            public void onDownloadCanceled() {
                listner.onCancelled();
            }

            @Override
            public void onFailed(DownloadException e) {
                listner.onFailed(e.getErrorMessage());
            }
        });
    }

    public void pauseDownload(String url)
    {
        DownloadManager.getInstance().pause(url);
    }

    public void cancelDownload(String url)
    {
        DownloadManager.getInstance().cancel(url);
    }
}
