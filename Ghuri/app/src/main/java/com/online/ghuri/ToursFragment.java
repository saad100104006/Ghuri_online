package com.online.ghuri;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saad on 9/27/16.
 */
public class ToursFragment extends Fragment {
    int color;
    public List<Hotel> hotelList = new ArrayList<Hotel>();
    SimpleRecyclerAdapter adapter;
    RecyclerView recyclerView;
    private ArrayList<Hotel> data;
    private static String url="http://169.50.66.88/bdtourbackend/wp_search_tours.php";


    public ToursFragment() {
    }

    @SuppressLint("ValidFragment")
    public ToursFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);

        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
        frameLayout.setBackgroundColor(color);
        //TextView text=(TextView) view.findViewById(R.id.listitem_name);


        new GetData().execute(url);


        recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent i=new Intent(getActivity(),DetailsActivity.class);
                i.putExtra("id", hotelList.get(position).getId());

                Toast.makeText(getActivity().getApplicationContext(), hotelList.get(position).getId(), Toast.LENGTH_SHORT).show();
                startActivity(i);


                //  Movie movie = movieList.get(position);
                // Toast.makeText(getActivity().getApplicationContext(), "saad" + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

     /*   adapter = new SimpleRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);*/


        return view;
    }


    private class GetData extends AsyncTask<String, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Boolean doInBackground(String... uRls) {
            // Creating service handler class instance
            //  ServiceHandler sh = new ServiceHandler();

            //    currentPage = Integer.parseInt(params[1]);

            Log.e("test", "test");
            //   adBriefviewItems.clear();
            JSONArray contacts = null;
            //JSONArray contacts2 = null;

            try {

                Log.e("test", "try");
                HttpGet httpGet = new HttpGet(uRls[0]);
                HttpClient httpClient = new DefaultHttpClient();
                HttpResponse httpResponse = httpClient.execute(httpGet);

                int status = httpResponse.getStatusLine().getStatusCode();

                if (status == 200) {
                    Log.e("test", "sts");
                    HttpEntity httpEntity = httpResponse.getEntity();
                    Log.e("test", httpEntity.toString());
                    String data = EntityUtils.toString(httpEntity);

                    JSONObject jsonRootObject = new JSONObject(data);
                    Log.e("test", jsonRootObject.toString());

                    contacts = jsonRootObject.getJSONArray("toursData");
                    System.out.println("getsaad::::::" + contacts);

                    System.out.println("contactssss::::::" + contacts.length());


                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString("id");
                        String title = c.getString("title");
                        String displayLocation = c.getString("displayLocation");
                        String distance = c.getString("distance");
                        String featured_image_url = c.getString("featured_image_url");



                        Hotel hotel = new Hotel();
                        hotel.setId(id);
                        hotel.setTitle(title);
                        hotel.setDisplayLocation(displayLocation);
                        hotel.setDistance(distance);
                        hotel.setFeatured_image_url(featured_image_url);

                        hotelList.add(hotel);

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            //pDialog.setVisibility(View.INVISIBLE);
            //   prog.setVisibility(View.GONE);


            //   prog.setVisibility(View.GONE);


            adapter = new SimpleRecyclerAdapter(getActivity(),hotelList);
            recyclerView.setAdapter(adapter);


        }

    }


    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, ClickListener clickListener1) {
            clickListener = clickListener1;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}
