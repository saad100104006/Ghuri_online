package com.online.ghuri;/*
package com.online.ghuri;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Suleiman on 14-04-2015.
 *//*

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.VersionViewHolder> {
    List<Hotel> versionModels;
    Boolean isHomeList = false;

    public static List<Hotel> homeActivitiesList = new ArrayList<Hotel>();
    //public static List<String> homeActivitiesSubList = new ArrayList<String>();
    Context context;
    OnItemClickListener clickListener;


    public void setHomeActivitiesList(Context context) {
        String[] listArray = context.getResources().getStringArray(R.array.home_activities);
        String[] subTitleArray = context.getResources().getStringArray(R.array.home_activities_subtitle);
        for (int i = 0; i < listArray.length; ++i) {
            homeActivitiesList.add(listArray[i]);
           // homeActivitiesSubList.add(subTitleArray[i]);
        }
    }

    public SimpleRecyclerAdapter(Context context) {
        isHomeList = true;
        this.context = context;
        setHomeActivitiesList(context);
    }


    public SimpleRecyclerAdapter(List<Hotel> versionModels) {
        isHomeList = false;
        this.versionModels = versionModels;

    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerlist_item, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VersionViewHolder versionViewHolder, int i) {
        if (isHomeList) {
             versionViewHolder.title.setText(homeActivitiesList.get(i));
            versionViewHolder.location.setText(homeActivitiesSubList.get(i));
        } else {
            //  versionViewHolder.title.setText(versionModels.get(i));
        }
    }

    @Override
    public int getItemCount() {
        if (isHomeList)
            return homeActivitiesList == null ? 0 : homeActivitiesList.size();
        else
            return versionModels == null ? 0 : versionModels.size();
    }


    class VersionViewHolder extends RecyclerView.ViewHolder {
        CardView cardItemLayout;


        TextView title;
        TextView location;
        TextView rateMin;
        //TextView subTitle;

        public VersionViewHolder(View itemView) {
            super(itemView);

            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.text1);
            location = (TextView) itemView.findViewById(R.id.text3);
            rateMin = (TextView) itemView.findViewById(R.id.text4);

        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
*/


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saad on 6/13/16.
 */


/**
 * Created by Suleiman on 14-04-2015.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.VersionViewHolder> {
    List<String> versionModels;


    private List<Hotel> smsList;
    private List<Hotel> arrayList;
    Context context;
    AdapterView.OnItemClickListener clickListener;
    ImageLoader imageLoader;


    public SimpleRecyclerAdapter(Context context, List<Hotel> smsList) {

        this.context = context;
        this.smsList = smsList;
        this.arrayList = new ArrayList<Hotel>();
        arrayList.addAll(smsList);
        imageLoader=new ImageLoader(context);

    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerlist_item, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VersionViewHolder versionViewHolder, int i) {

        Hotel hotel = smsList.get(i);


        versionViewHolder.title.setText(hotel.getTitle());
        versionViewHolder.location.setText(hotel.getDisplayLocation());
        versionViewHolder.rateMin.setText(hotel.getRateMin());



        ImageView image = versionViewHolder.images;

       Picasso.with(context).load(hotel.getFeatured_image_url()).into(image);




    }

    @Override
    public int getItemCount() {

        return smsList.size();
    }


    class VersionViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView location;
        TextView rateMin;
        ImageView images;
        CardView cardItemLayout;
        //TextView subTitle;

        public VersionViewHolder(View itemView) {
            super(itemView);


            images = (ImageView) itemView.findViewById(R.id.img1);
            cardItemLayout = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.text1);
            location = (TextView) itemView.findViewById(R.id.text3);
            rateMin = (TextView) itemView.findViewById(R.id.text4);
        }

   /* public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        smsList.clear();
        if (charText.length() == 0) {
            smsList.addAll(arrayList);
        } else {
            for (SMS wp : arrayList) {
                if (wp.getSms().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    smsList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }*/

   /* public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }*/

    }
}


