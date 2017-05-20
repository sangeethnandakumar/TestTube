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
import bullyfox.sangeeth.testube.component.TripleItem;
import bullyfox.sangeeth.testube.options.AdapterImageMode;
import bullyfox.sangeeth.testube.options.AdapterLayering;
import bullyfox.sangeeth.testube.options.AdapterType;

/**
 * Created by Sangeeth Nandakumar on 19-05-2017.
 */

public class TripleAdapter extends BaseAdapter {
    Context context;
    List<TripleItem> tripleItems;
    AdapterType adapterType;
    AdapterLayering layer;


    public TripleAdapter(Context context, List<TripleItem> tripleItems, AdapterType adapterType, AdapterLayering layer) {
        this.context = context;
        this.tripleItems = tripleItems;
        this.adapterType = adapterType;
        this.layer = layer;
    }

    @Override
    public int getCount() {
        return tripleItems.size();
    }

    @Override
    public Object getItem(int i) {
        return tripleItems.get(i);
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
                v=View.inflate(context, R.layout.listitem_t3,null);
            }
            else if (layer==AdapterLayering.CARD)
            {
                v=View.inflate(context, R.layout.listitem_t3_card,null);
            }
            TextView maintext=(TextView)v.findViewById(R.id.listitem_t3_maintext);
            TextView subtext=(TextView)v.findViewById(R.id.listitem_t3_subtext);
            TextView tagline=(TextView)v.findViewById(R.id.listitem_t3_tagline);
            maintext.setText(tripleItems.get(i).getMaintext());
            subtext.setText(tripleItems.get(i).getSubtext());
            tagline.setText(tripleItems.get(i).getTagline());
            ImageView image=(ImageView)v.findViewById(R.id.listitem_t3_image);
            if (tripleItems.get(i).getImagemode()== AdapterImageMode.RESOURCE)
            {
                image.setVisibility(View.VISIBLE);
                image.setImageResource(tripleItems.get(i).getImageres());
            }
            else if (tripleItems.get(i).getImagemode()==AdapterImageMode.WEB)
            {
                image.setVisibility(View.VISIBLE);
                Picasso.with(context).load(tripleItems.get(i).getWebres()).into(image);
            }
            else if (tripleItems.get(i).getImagemode()==AdapterImageMode.NONE)
            {
                image.setVisibility(View.GONE);
            }
        }
        else if (adapterType==AdapterType.GRIDVIEW)
        {
            if (layer==AdapterLayering.LINEAR)
            {
                v=View.inflate(context, R.layout.griditem_t3,null);
            }
            else if (layer==AdapterLayering.CARD)
            {
                v=View.inflate(context, R.layout.griditem_t3_card,null);
            }
            TextView maintext=(TextView)v.findViewById(R.id.listitem_t3_maintext);
            TextView subtext=(TextView)v.findViewById(R.id.listitem_t3_subtext);
            TextView tagline=(TextView)v.findViewById(R.id.listitem_t3_tagline);
            maintext.setText(tripleItems.get(i).getMaintext());
            subtext.setText(tripleItems.get(i).getSubtext());
            tagline.setText(tripleItems.get(i).getTagline());
            ImageView image=(ImageView)v.findViewById(R.id.listitem_t3_image);
            if (tripleItems.get(i).getImagemode()== AdapterImageMode.RESOURCE)
            {
                image.setVisibility(View.VISIBLE);
                image.setImageResource(tripleItems.get(i).getImageres());
            }
            else if (tripleItems.get(i).getImagemode()==AdapterImageMode.WEB)
            {
                image.setVisibility(View.VISIBLE);
                Picasso.with(context).load(tripleItems.get(i).getWebres()).into(image);
            }
            else if (tripleItems.get(i).getImagemode()==AdapterImageMode.NONE)
            {
                image.setVisibility(View.GONE);
            }
        }
        return v;
    }
}
