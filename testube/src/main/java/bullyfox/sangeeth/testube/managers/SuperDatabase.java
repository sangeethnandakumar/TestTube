package bullyfox.sangeeth.testube.managers;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import bullyfox.sangeeth.testube.options.AssetDatabaseMode;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Sangeeth Nandakumar on 22-05-2017.
 */

public class SuperDatabase{
    Context context;
    String databaseName;
    SQLiteDatabase mydatabase;

    public SuperDatabase(Context context, String newDatabaseName, String databaseSchema)
    {
        this.databaseName=newDatabaseName;
        mydatabase = context.openOrCreateDatabase(this.databaseName,MODE_PRIVATE,null);
        mydatabase.execSQL(databaseSchema);
    }

    public SuperDatabase(Context context, String existingDatabaseName, AssetDatabaseMode mode)
    {
        this.databaseName=existingDatabaseName;
        if (mode==AssetDatabaseMode.COPY_TO_SYSTEM) {
            try {
                InputStream myInput = context.getAssets().open(existingDatabaseName);
                OutputStream myOutput = new FileOutputStream("/data/data/" + context.getPackageName() + "/databases/" + existingDatabaseName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
            catch (Exception e) {}
        }
        mydatabase = context.openOrCreateDatabase(this.databaseName,MODE_PRIVATE,null);
    }

    public void sqlInject(String sqlQuery)
    {
        mydatabase.execSQL(sqlQuery);
    }

    public ArrayList<String> sqlEjectCSV(String sqlQuery)
    {
        String temp="";
        ArrayList<String> out=new ArrayList<>();
        Cursor resultSet = mydatabase.rawQuery(sqlQuery,null);
        resultSet.moveToFirst();
        for (int i=0;i<resultSet.getCount();i++)
        {
            for (int j=0;j<resultSet.getColumnCount();j++)
            {
                temp+=resultSet.getString(j);
                if (j<resultSet.getColumnCount()-1)
                {
                    temp+=",";
                }
            }
            out.add(temp);
            resultSet.moveToNext();
            temp="";
        }
        return out;
    }

    public String sqlEjectJSON(String sqlQuery)
    {
        String  json="{\"rows\": [";
        Cursor resultSet = mydatabase.rawQuery(sqlQuery,null);
        resultSet.moveToFirst();
        for (int i=0;i<resultSet.getCount();i++)
        {
            json+="{";
            for (int j=0;j<resultSet.getColumnCount();j++)
            {
                json+="\""+resultSet.getColumnName(j)+"\":\""+resultSet.getString(j)+"\"";
                if (j<resultSet.getColumnCount()-1)
                {
                    json+=",";
                }
            }
            resultSet.moveToNext();
            json+="}";
            if (i<resultSet.getCount()-1)
            {
                json+=",";
            }
        }
        json+="]}";
        return  json;
    }

    public String sqlEjectXML(String sqlQuery)
    {
        String  json="<?xml version=\"1.0\" encoding=\"UTF-8\"?><rows>";
        Cursor resultSet = mydatabase.rawQuery(sqlQuery,null);
        resultSet.moveToFirst();
        for (int i=0;i<resultSet.getCount();i++)
        {
            json+="<row ";
            for (int j=0;j<resultSet.getColumnCount();j++)
            {
                json+=resultSet.getColumnName(j)+"=\""+resultSet.getString(j)+"\"";
                if (j<resultSet.getColumnCount()-1)
                {
                    json+=" ";
                }
            }
            resultSet.moveToNext();
            json+="/>";
        }
        json+="</rows>";
        return  json;
    }
}