package com.online.ghuri;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

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
 * Created by saad on 7/25/16.
 */


public class TourDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    ActionBarDrawerToggle toggle;
    //  SQLiteConnector Db;
    List<String> catList;
    List<Integer> smsNumberList = new ArrayList();
    private GoogleMap googleMap;
    List<room> roomList;
    // SQLiteConnector DB;

    private RecyclerView horizontal_recycler_view;
    private ArrayList<String> horizontalList, verticalList;
    private static String url1 = "http://169.50.66.88/bdtourbackend/fetch_tour_by_id.php?tourlId=";
    private static String url;
    // private  VerticalAdapter verticalAdapter;

    String title, description, featured_image_url, rateMin, address, latitudes, longitudes, hotelPolicy, additionalInfo;
    ImageView images;
    TextView descriptions, dates, titiles;
    Button registerButton;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_details);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.tabanim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setIcon(R.drawable.user);

        images = (ImageView) findViewById(R.id.circle2);
        descriptions = (TextView) findViewById(R.id.description);
        registerButton = (Button) findViewById(R.id.register);
        dates = (TextView) findViewById(R.id.date);
        titiles = (TextView) findViewById(R.id.title);

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        roomList=new ArrayList<>();

        //  description= (TextView)findViewById(R.id.description);

        Intent intent = getIntent();

        String id = intent.getStringExtra("id");
        System.out.println("ali"+url);
        url=url1+id;

        initCollapsingToolbar();
        new GetData().execute(url);



        ////







   /*     images.setImageResource(getResources().getIdentifier("album1", "drawable", getPackageName()));
        descriptions.setText("sda");
        dates.setText("sds");
        titiles.setText("dsad");
        initilizeMap();*/

        /////
        // latitude and longitude

        //

       /* registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailsActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
*/
// create marker

// adding marker




        descriptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(DetailsActivity.this, TextDetailsActivity.class);
                //  intent.putExtra("text",description);
                //startActivity(intent);
            }
        });

        try {
            Glide.with(this).load(R.drawable.album1).into((ImageView) findViewById(R.id.circle2));
        } catch (Exception e) {
            e.printStackTrace();
        }







    }

       /* final GestureDetector mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {

            public boolean onQueryTextSubmit(String arg0) {
                // TODO Auto-generated method stub

                //adapter.filter(arg0);

                return true;
            }

            public boolean onQueryTextChange(String arg0) {
                // TODO Auto-generated method stub

                //adapter.filter(arg0);
                return true;
            }
        });
        return true;

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
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

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.tabanim_appbar);
        // appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }




    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }


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
            //JSONObject json = null;
            JSONArray room = null;

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



                    title = jsonRootObject.getString("title");
                    featured_image_url = jsonRootObject.getString("featured_image_url");
                    rateMin = jsonRootObject.getString("rateMin");
                    address = jsonRootObject.getString("address");
                    latitudes = jsonRootObject.getString("latitude");
                    longitudes = jsonRootObject.getString("longitude");
                    hotelPolicy = jsonRootObject.getString("phone");
                    additionalInfo = jsonRootObject.getString("email");


                    //  String hotelImage=jsonRootObject.getString("hotelImage");
                    // String hotelPolicy=jsonRootObject.getString("hotelPolicy");






                    // System.out.println("getdata::::::" + contacts);

                    //  System.out.println("contactssss::::::" + contacts.length());


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

            Picasso.with(TourDetailsActivity.this).load(featured_image_url).into(images);

            latitude = Double.parseDouble(latitudes);

            longitude = Double.parseDouble(longitudes);

            descriptions.setText(description);
            dates.setText(address);
            titiles.setText(title);

            initilizeMap();



            MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Hello Maps ");

            googleMap.addMarker(marker);

            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    new LatLng(latitude, longitude)).zoom(12).build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {

                    Intent intent=new Intent(TourDetailsActivity.this,MapDetailsActivity.class);
                    intent.putExtra("lat",latitude);
                    intent.putExtra("lon",longitude);
                    startActivity(intent);

                }
            });





        }

    }
}



