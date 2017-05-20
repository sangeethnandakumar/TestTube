package bullyfox.sangeeth.testube.permission;

import android.Manifest;
import android.app.Activity;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

/**
 * Created by Sangeeth Nandakumar on 20-05-2017.
 */

public class Permit{
    Activity thisActivity;
    OnPermitStatusListner listner;

    public interface OnPermitStatusListner
    {
        void onAllPermitsGranded();
        void onSomePermitsDenied(ArrayList<String> deniedPermits);
        void onAllPermitsDenied();
    }

    public Permit(Activity thisActivity) {
        this.thisActivity = thisActivity;
    }


    public void askPermitsFor(final String... permits)
    {
        TedPermission permission =  new TedPermission(thisActivity);
        permission.setPermissionListener(new PermissionListener()
        {
            @Override
            public void onPermissionGranted()
            {
                listner.onAllPermitsGranded();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions)
            {
                if (deniedPermissions.size()==permits.length)
                {
                    listner.onAllPermitsDenied();
                }
                else
                {
                    listner.onSomePermitsDenied(deniedPermissions);
                }
            }
        })
                .setPermissions(permits)
                .check();
    }

    public void setOnPermitStatusListner(OnPermitStatusListner listner)
    {
        this.listner=listner;
    }
}
