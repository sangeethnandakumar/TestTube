package bullyfox.sangeeth.testube.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import bullyfox.sangeeth.testube.R;
import bullyfox.sangeeth.testube.component.SimpleItem;
import bullyfox.sangeeth.testube.options.AdapterImageMode;
import bullyfox.sangeeth.testube.options.AdapterLayering;
import bullyfox.sangeeth.testube.options.AdapterType;

/**
 * Created by Sangeeth Nandakumar on 19-05-2017.
 */

public class SimpleAdapter extends BaseAdapter {
    Context context;
    List<SimpleItem> simpleItems;
    AdapterType adapterType;
    AdapterLayering layer;


    public SimpleAdapter(Context context, List<SimpleItem> simpleItems, AdapterType adapterType, AdapterLayering layer) {
        this.context = context;
        this.simpleItems = simpleItems;
        this.adapterType = adapterType;
        this.layer = layer;
    }

    @Override
    public int getCount() {
        return simpleItems.size();
    }

    @Override
    public Object getItem(int i) {
        return simpleItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=null;
        if (adapterType==AdapterType.LISTVIEW)
        {
            if (layer==AdapterLayering.LINEAR)
            {
                v=View.inflate(context, R.layout.listitem_t1,null);
            }
            else if (layer==AdapterLayering.CARD)
            {
                v=View.inflate(context, R.layout.listitem_t1_card,null);
            }
            TextView maintext=(TextView)v.findViewById(R.id.listitem_t1_maintext);
            maintext.setText(simpleItems.get(i).getMaintext());
            ImageView image=(ImageView)v.findViewById(R.id.listitem_t1_image);
            if (simpleItems.get(i).getImagemode()==AdapterImageMode.RESOURCE)
            {
                image.setVisibility(View.VISIBLE);
                image.setImageResource(simpleItems.get(i).getImageres());
            }
            else if (simpleItems.get(i).getImagemode()==AdapterImageMode.WEB)
            {
                image.setVisibility(View.VISIBLE);
                Picasso.with(context).load(simpleItems.get(i).getWebres()).into(image);
            }
            else if (simpleItems.get(i).getImagemode()==AdapterImageMode.NONE)
            {
                image.setVisibility(View.GONE);
            }
        }
        else if (adapterType==AdapterType.GRIDVIEW)
        {
        }
        return v;
    }
}
