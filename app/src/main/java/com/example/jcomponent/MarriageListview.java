package com.example.jcomponent;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MarriageListview extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final Integer[] imgid;

    public MarriageListview(Activity context, String[] maintitle,String[] subtitle, Integer[] imgid) {
        super(context, R.layout.activity_marriage_listview, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.imgid=imgid;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_marriage_listview, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title1);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);
        subtitleText.setText(subtitle[position]);

        return rowView;

    };
}