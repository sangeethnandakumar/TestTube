package bullyfox.sangeeth.testube.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sangeeth Nandakumar on 20-05-2017.
 */

public class AppSettings
{
    Context context;
    SharedPreferences settings;

    public AppSettings(Context context)
    {
        this.context = context;
        settings = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void saveSettings(String key,String value)
    {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String retriveSettings(String key)
    {
        return settings.getString(key,"");
    }
}

