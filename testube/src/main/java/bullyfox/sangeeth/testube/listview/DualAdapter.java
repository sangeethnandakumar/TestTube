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
import bullyfox.sangeeth.testube.component.DualItem;
import bullyfox.sangeeth.testube.component.SimpleItem;
import bullyfox.sangeeth.testube.options.AdapterImageMode;
import bullyfox.sangeeth.testube.options.AdapterType;

/**
 * Created by Sangeeth Nandakumar on 19-05-2017.
 */

public class DualAdapter extends BaseAdapter {
    Context context;
    List<DualItem> dualItems;
    AdapterType adapterType;


    public DualAdapter(Context context, List<DualItem> dualItems, AdapterType adapterType) {
        this.context = context;
        this.dualItems = dualItems;
        this.adapterType = adapterType;
    }


    @Override
    public int getCount() {
        return dualItems.size();
    }

    @Override
    public Object getItem(int i) {
        return dualItems.get(i);
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
            v=View.inflate(context, R.layout.listitem_t2,null);
            TextView maintext=(TextView)v.findViewById(R.id.listitem_t2_maintext);
            TextView subtext=(TextView)v.findViewById(R.id.listitem_t2_subtext);
            maintext.setText(dualItems.get(i).getMaintext());
            subtext.setText(dualItems.get(i).getSubtext());
            ImageView image=(ImageView)v.findViewById(R.id.listitem_t2_image);
            if (dualItems.get(i).getImagemode()== AdapterImageMode.RESOURCE)
            {
                image.setVisibility(View.VISIBLE);
                image.setImageResource(dualItems.get(i).getImageres());
            }
            else if (dualItems.get(i).getImagemode()==AdapterImageMode.WEB)
            {
                image.setVisibility(View.VISIBLE);
                Picasso.with(context).load(dualItems.get(i).getWebres()).into(image);
            }
            else if (dualItems.get(i).getImagemode()==AdapterImageMode.NONE)
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
