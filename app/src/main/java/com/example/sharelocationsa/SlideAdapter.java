package com.example.sharelocationsa;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_5,
            R.drawable.image_6,
            R.drawable.locasmy,
            R.drawable.shax,
            R.drawable.ssxc,
            R.drawable.fndloc1

    };
    // list of titles
    public String[] lst_title = {
            "Mobile data on",
            "Wi-Fi on ",
            "Location Enabale",
            "My location ",
            "Share Location",
            "My Address",
            "Send Location",
            "Receive location",
            "show location"

    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Mobile data or Wi-fi any one mode data enable",
            "Wi-fi or mobile data any one mode data enable",
            "Location (GPS) Device mode enable ",
            "My location check , click the button functin and location  details information",
            "Share Location Direct Sms send and Messanger send option  choose you option and send your location share",
            "My Address Information show ",
            "location link sending ",
            "Receive location link ",
            "Link open show  location "
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
           Color.rgb(91, 44, 111  ),
            Color.rgb	(0,0,128),
            Color.rgb(0,191,255),
            Color.rgb(128,128,0),
            Color.rgb(50,205,50),
            Color.rgb	(0,0,128),
            Color.rgb	(0,0,128),
            Color.rgb	(0,0,128),
            Color.rgb	(0,0,128)

    };



    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
