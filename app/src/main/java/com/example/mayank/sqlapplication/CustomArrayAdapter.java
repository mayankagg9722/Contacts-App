package com.example.mayank.sqlapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank on 27-07-2016.
 */
public class CustomArrayAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public CustomArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Handler handler;
        if (view == null) {
            LayoutInflater layoutInflator = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflator.inflate(R.layout.row_layout, parent, false);
            handler = new Handler();
            handler.name = (TextView) view.findViewById(R.id.textname);
            handler.no = (TextView) view.findViewById(R.id.textnumber);
            handler.email = (TextView) view.findViewById(R.id.textemail);
            view.setTag(handler);
        } else {
            handler = (Handler) view.getTag();
        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);
        handler.name.setText(dataProvider.getName().toString());
        handler.no.setText(dataProvider.getNumber().toString());
        handler.email.setText(dataProvider.getEmail().toString());
        return view;
    }

    static class Handler {
        TextView name;
        TextView no;
        TextView email;
    }
}
