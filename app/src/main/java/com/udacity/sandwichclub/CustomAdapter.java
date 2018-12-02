package com.udacity.sandwichclub;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    String[] sandwiches;

    public CustomAdapter(Context context, String[] sandwiches) {
        this.mContext = context;
        this.sandwiches = sandwiches;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("ViewHolder") View v = inflater.inflate(R.layout.list_item, viewGroup, false);

        ImageView arrrow = v.findViewById(R.id.arrow);
        TextView title = v.findViewById(R.id.item_txt);
        String json = sandwiches[i];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        arrrow.setImageResource(R.drawable.ic_arrow_forward_orange_24dp);
        title.setText(sandwich.getMainName());

        return v;
    }
}
