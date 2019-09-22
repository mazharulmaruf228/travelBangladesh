package com.maruf.travelbangladesh;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.maruf.travelbangladesh.activity.MainActivity2;
import com.maruf.travelbangladesh.adapter.VideoAdapter;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;




public class SaintMartin extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener{
    int writingButtonCount = 0;
    int videoButtonCount = 0;

    SliderLayout sliderLayout;
    Animation fade_out;
    ScrollView fullscroll;

    ListView listview;
    ImageView writingButton,galleryButton,videoButton;

    ProgressBar progressBar;

    LinearLayout linLayScroll;


    String writerURL = "";
    String imageURL= "";
    String videoURL= "";


    HashMap<String,String> myMap;
    ArrayList<HashMap<String,String>> arrayList= new ArrayList<HashMap<String, String>>();



    private InterstitialAd mInterstitialAd;



    //for video
    RelativeLayout videoLayout;
    ListView listviewvideo;
    YouTubePlayerView youTubeView;
    YouTubePlayer ytPlayer;

    HashMap<String,String> myMapvideo;
    ArrayList<HashMap<String,String>> arrayListvideo= new ArrayList<HashMap<String, String>>();
    private static final String YoutubeDeveloperKey ="AIzaSyDmjaet2edX0f-VCFBYGVx6y94INt2fV_k";
            //"AIzaSyDhEeq_FYAdCzMMSigmMcRwF_nQEhUXS-0";




    Random rand = new Random();
    int randNum = rand.nextInt(5);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saint_martin);



        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-4200317807971621~1134755258");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4200317807971621/9263816276");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });




        linLayScroll = findViewById(R.id.linLayScroll);







        imageURL = Config.IMAGE_URL;
        writerURL = Config.WRITER_URL;
        videoURL = Config.VIDEO_URL;

        fullscroll = (ScrollView)findViewById(R.id.fullscroll);
//        fade_out = AnimationUtils.loadAnimation(SaintMartin.this,R.anim.fade_out);
//        fullscroll.setAnimation(fade_out);


        View myView  = null;
        if (Config.POSITION ==1){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             myView = inflater.inflate(R.layout.lay_01_stmartin, null);
             linLayScroll.addView(myView);



        }  else if (Config.POSITION ==2){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_02_sajek, null);
            linLayScroll.addView(myView);
        }  else if (Config.POSITION ==3){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_03_ratargul, null);
            linLayScroll.addView(myView);
        }  else if (Config.POSITION ==4){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_04_panam, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==5){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_05_boga, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==6){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_06_coxs, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==7){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_07_jaflong, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==8){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_08_lalakhal, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==9){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_09_paharpur, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==10){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_10_shundarban, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==11){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_11_chalan, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==12){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_12_birishiri, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==13){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_13_kuakata, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==14){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_14_tanguar, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==15){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_15_bichnakandi, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==16){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_16_hamham, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==17){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_17_moinot, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==18){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_18_amiakhum, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==19){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_19_khoiachora, null);
            linLayScroll.addView(myView);
        }else if (Config.POSITION ==20){
            LayoutInflater inflater =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            myView = inflater.inflate(R.layout.lay_20_keokradong, null);
            linLayScroll.addView(myView);
        }








        if (myView !=null){
            sliderLayout = myView.findViewById(R.id.imageSlider);
            sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
            sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :
            setSliderViews();
        }







        writingButton = (ImageView) findViewById(R.id.writingButton);
        galleryButton = (ImageView) findViewById(R.id.gallery_button);
        videoButton = (ImageView) findViewById(R.id.video_button) ;

        writingButton.setImageResource(R.drawable.writinginactive);
        galleryButton.setImageResource(R.drawable.galleryinactive);
        videoButton.setImageResource(R.drawable.videoinactive);

        listview = (ListView) findViewById(R.id.listview);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        videoLayout = findViewById(R.id.videolayout);
        youTubeView = findViewById(R.id.youtube_view);
        youTubeView.initialize(YoutubeDeveloperKey, this);
        listviewvideo = findViewById(R.id.listviewvideo);






        writingButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {



                if(randNum==2) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                }
                randNum=rand.nextInt(5);
                videoButtonCount=0;
                arrayListvideo.clear();

                writingButton.setSelected(!writingButton.isPressed());

                if (writingButton.isPressed()) {

                    writingButton.setImageResource(R.drawable.writingactive);
                    galleryButton.setImageResource(R.drawable.galleryinactive);
                    videoButton.setImageResource(R.drawable.videoinactive);
                }

                fullscroll.setVisibility(View.GONE);
                videoLayout.setVisibility(View.GONE);


                //ytPlayer.release();


                listview.setVisibility(View.VISIBLE);

                if(writingButtonCount==0){
                    progressBar.setVisibility(View.VISIBLE);
                    JSONArrayRequest();
                    writingButtonCount=1;
                }

            }
        });

        //for gallery

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                writingButtonCount=0;
                videoButtonCount=0;
                arrayListvideo.clear();
                arrayList.clear();

                galleryButton.setSelected(!galleryButton.isPressed());

                if (galleryButton.isPressed()) {
                    galleryButton.setImageResource(R.drawable.galleryactive);
                    writingButton.setImageResource(R.drawable.writinginactive);
                    videoButton.setImageResource(R.drawable.videoinactive);
                }

                    Intent myIntent = new Intent(SaintMartin.this, MainActivity2.class);
                   myIntent.putExtra("key", imageURL);
                  startActivity(myIntent);



            }
        });



        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(randNum==3) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                }
                randNum=rand.nextInt(5);

                writingButtonCount=0;
                arrayList.clear();

                if (videoButton.isPressed()) {
                    videoButton.setImageResource(R.drawable.videoactive);
                    writingButton.setImageResource(R.drawable.writinginactive);
                    galleryButton.setImageResource(R.drawable.galleryinactive);
                }


                fullscroll.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                listview.setVisibility(View.GONE);

                youTubeView.setVisibility(View.GONE);
                videoLayout.setVisibility(View.VISIBLE);
                listviewvideo.setVisibility(View.VISIBLE);



                if(videoButtonCount==0) {
                    progressBar.setVisibility(View.VISIBLE);
                    JSONArrayRequestVideo();
                    videoButtonCount = 1;
                }



            }
        });


    }

    public void JSONArrayRequest(){

        RequestQueue queue = Volley.newRequestQueue(SaintMartin.this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,
                writerURL,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);
                        try {

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject writer = response.getJSONObject(i);
                                //Log.d("Response", user.getString("username"));

                                String id = writer.getString("id");
                                String title = writer.getString("title");
                                String name= writer.getString("name");
                                String date = writer.getString("date");
                                String description = writer.getString("description");


                                myMap = new HashMap<String, String>();
                                myMap.put("id", id);
                                myMap.put("title", title);
                                myMap.put("name", name);
                                myMap.put("date",date);
                                myMap.put("description",description);

                                arrayList.add(myMap);

                            }
                            MyAdapter adapter = new MyAdapter();
                            listview.setAdapter(adapter);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", error.getMessage());
            }
        });
        queue.add(arrayRequest);
    }

    public void JSONArrayRequestVideo(){

        RequestQueue queue = Volley.newRequestQueue(SaintMartin.this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,
                videoURL,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        progressBar.setVisibility(View.GONE);
                        try {

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject videos = response.getJSONObject(i);
                                //Log.d("Response", user.getString("username"));

                                String id = videos.getString("id");
                                String title = videos.getString("title");
                                String url= videos.getString("url");
                                String thumbnailURL = videos.getString("thumbnailURL");



                                myMapvideo = new HashMap<String, String>();
                                myMapvideo.put("id", id);
                                myMapvideo.put("title", title);
                                myMapvideo.put("url", url);
                                myMapvideo.put("thumbnailURL", thumbnailURL);

                                arrayListvideo.add(myMapvideo);

                            }
                            MyAdapterVideo adapter = new MyAdapterVideo();
                            listviewvideo.setAdapter(adapter);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", error.getMessage());
            }
        });
        queue.add(arrayRequest);
    }



    public class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater)SaintMartin.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.reviewers_profile,viewGroup,false);

            LinearLayout tvlayout= (LinearLayout) view.findViewById(R.id.tvlayout);
            TextView tvTitle = (TextView) view.findViewById(R.id.tvtitle);
            TextView tvWriter = (TextView) view.findViewById(R.id.tvwriter);
            TextView tvDate = (TextView) view.findViewById(R.id.tvdate);


            final HashMap<String,String> myMap2= arrayList.get(position);
            String id =myMap2.get("id");
            final String title= myMap2.get("title");
            final String name = myMap2.get("name");
            final String date = myMap2.get("date");
            //String description = myMap2.get("description");


            tvTitle.setText(title);
            tvWriter.setText(name);
            tvDate.setText(date);
            tvlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent= new Intent(SaintMartin.this,ReviewsHandler.class);
                    myIntent.putExtra("title",title);
                    myIntent.putExtra("writer",name);
                    myIntent.putExtra("date",date);
                    myIntent.putExtra("description",myMap2.get("description"));
                    startActivity(myIntent);
                }
            });

            return view;
        }
    }




    public class MyAdapterVideo extends BaseAdapter{
        @Override
        public int getCount() {
            return arrayListvideo.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = (LayoutInflater)SaintMartin.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.video_template,viewGroup,false);

            final LinearLayout tvlayout= (LinearLayout) view.findViewById(R.id.tvlayout);
            final TextView tvTitle = (TextView) view.findViewById(R.id.tvtitle);
            ImageView tvtemplate = (ImageView) view.findViewById(R.id.tvtemplate);

            final HashMap<String,String> myMap2video= arrayListvideo.get(position);
            String id =myMap2video.get("id");
            String title= myMap2video.get("title");
            final String url = myMap2video.get("url");
            String thumbnailURL = myMap2video.get("thumbnailURL");

            tvTitle.setText(title);
            Picasso.with(SaintMartin.this).load(thumbnailURL).into(tvtemplate);

            tvlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fullscroll.setVisibility(View.GONE);
                    listview.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);

                    listviewvideo.setVisibility(View.VISIBLE);
                    youTubeView.setVisibility(View.VISIBLE);
                    ytPlayer.loadVideo(url);

                    tvlayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                    tvTitle.setTextColor(getResources().getColor(android.R.color.white));
                }
            });

            return view;
        }
    }


    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:

                    if (Config.POSITION==1) sliderView.setImageDrawable(R.drawable.stmartin_a);
                    else if (Config.POSITION==2) sliderView.setImageDrawable(R.drawable.shajek_a);
                    else if (Config.POSITION==3) sliderView.setImageDrawable(R.drawable.ratargul_a);
                    else if (Config.POSITION==4) sliderView.setImageDrawable(R.drawable.panam_b);
                    else if (Config.POSITION==5) sliderView.setImageDrawable(R.drawable.boga_a);
                    else if (Config.POSITION==6) sliderView.setImageDrawable(R.drawable.coxs_a);
                    else if (Config.POSITION==7) sliderView.setImageDrawable(R.drawable.jaflong_a);
                    else if (Config.POSITION==8) sliderView.setImageDrawable(R.drawable.lalakhal_a);
                    else if (Config.POSITION==9) sliderView.setImageDrawable(R.drawable.paharpur_a);
                    else if (Config.POSITION==10) sliderView.setImageDrawable(R.drawable.shundar_a);
                    else if (Config.POSITION==11) sliderView.setImageDrawable(R.drawable.chalanbil_a);
                    else if (Config.POSITION==12) sliderView.setImageDrawable(R.drawable.birishiri_a);
                    else if (Config.POSITION==13) sliderView.setImageDrawable(R.drawable.kuakata_a);
                    else if (Config.POSITION==14) sliderView.setImageDrawable(R.drawable.tanguar_a);
                    else if (Config.POSITION==15) sliderView.setImageDrawable(R.drawable.bichanakandi_a);
                    else if (Config.POSITION==16) sliderView.setImageDrawable(R.drawable.hamham_a);
                    else if (Config.POSITION==17) sliderView.setImageDrawable(R.drawable.moinot_a);
                    else if (Config.POSITION==18) sliderView.setImageDrawable(R.drawable.nafakhum_a);
                    else if (Config.POSITION==19) sliderView.setImageDrawable(R.drawable.khoiachora_a);
                    else if (Config.POSITION==20) sliderView.setImageDrawable(R.drawable.keokradong_a);




                   // sliderView.setImageUrl("https://drive.google.com/open?id=11UBeMxcvrdvnCIwRQLCaBViJHpTUpUNy");
                    break;
                case 1:
                    if (Config.POSITION==1) sliderView.setImageDrawable(R.drawable.stmartin_b);
                    else if (Config.POSITION==2) sliderView.setImageDrawable(R.drawable.shajek_b);
                    else if (Config.POSITION==3) sliderView.setImageDrawable(R.drawable.ratargul_b);
                    else if (Config.POSITION==4) sliderView.setImageDrawable(R.drawable.panam_i);
                    else if (Config.POSITION==5) sliderView.setImageDrawable(R.drawable.boga_b);
                    else if (Config.POSITION==6) sliderView.setImageDrawable(R.drawable.coxs_b);
                    else if (Config.POSITION==7) sliderView.setImageDrawable(R.drawable.jaflong_b);
                    else if (Config.POSITION==8) sliderView.setImageDrawable(R.drawable.lalakhal_b);
                    else if (Config.POSITION==9) sliderView.setImageDrawable(R.drawable.paharpur_b);
                    else if (Config.POSITION==10) sliderView.setImageDrawable(R.drawable.shundar_b);
                    else if (Config.POSITION==11) sliderView.setImageDrawable(R.drawable.chalanbil_b);
                    else if (Config.POSITION==12) sliderView.setImageDrawable(R.drawable.birishiri_b);
                    else if (Config.POSITION==13) sliderView.setImageDrawable(R.drawable.kuakata_b);
                    else if (Config.POSITION==14) sliderView.setImageDrawable(R.drawable.tanguar_b);
                    else if (Config.POSITION==15) sliderView.setImageDrawable(R.drawable.bichanakandi_b);
                    else if (Config.POSITION==16) sliderView.setImageDrawable(R.drawable.hamham_b);
                    else if (Config.POSITION==17) sliderView.setImageDrawable(R.drawable.moinot_b);
                    else if (Config.POSITION==18) sliderView.setImageDrawable(R.drawable.nafakhum_d);
                    else if (Config.POSITION==19) sliderView.setImageDrawable(R.drawable.khoiachora_b);
                    else if (Config.POSITION==20) sliderView.setImageDrawable(R.drawable.keokradong_b);

                    //sliderView.setImageUrl("https://drive.google.com/open?id=1fIyVQLjfaTJI6tAzZMfcPvu_ezn8spmg");
                    break;
                case 2:
                    if (Config.POSITION==1) sliderView.setImageDrawable(R.drawable.stmartin_c);
                    else if (Config.POSITION==2) sliderView.setImageDrawable(R.drawable.shajek_c);
                    else if (Config.POSITION==3) sliderView.setImageDrawable(R.drawable.ratargul_c);
                    else if (Config.POSITION==4) sliderView.setImageDrawable(R.drawable.panam_j);
                    else if (Config.POSITION==5) sliderView.setImageDrawable(R.drawable.boga_d);
                    else if (Config.POSITION==6) sliderView.setImageDrawable(R.drawable.coxs_c);
                    else if (Config.POSITION==7) sliderView.setImageDrawable(R.drawable.jaflong_c);
                    else if (Config.POSITION==8) sliderView.setImageDrawable(R.drawable.lalakhal_d);
                    else if (Config.POSITION==9) sliderView.setImageDrawable(R.drawable.paharpur_c);
                    else if (Config.POSITION==10) sliderView.setImageDrawable(R.drawable.shundar_c);
                    else if (Config.POSITION==11) sliderView.setImageDrawable(R.drawable.chalanbil_c);
                    else if (Config.POSITION==12) sliderView.setImageDrawable(R.drawable.birishiri_c);
                    else if (Config.POSITION==13) sliderView.setImageDrawable(R.drawable.kuakata_c);
                    else if (Config.POSITION==14) sliderView.setImageDrawable(R.drawable.tanguar_c);
                    else if (Config.POSITION==15) sliderView.setImageDrawable(R.drawable.bichanakandi_c);
                    else if (Config.POSITION==16) sliderView.setImageDrawable(R.drawable.hamham_c);
                    else if (Config.POSITION==17) sliderView.setImageDrawable(R.drawable.moinot_c);
                    else if (Config.POSITION==18) sliderView.setImageDrawable(R.drawable.amiakhum_a);
                    else if (Config.POSITION==19) sliderView.setImageDrawable(R.drawable.napittachora_c);
                    else if (Config.POSITION==20) sliderView.setImageDrawable(R.drawable.sakahafong_b);
                    //sliderView.setImageUrl("https://drive.google.com/open?id=1IethPqJu8Ma3vqm51_pmkaFpVs-LiqJA");
                    break;
                case 3:
                    if (Config.POSITION==1) sliderView.setImageDrawable(R.drawable.stmartin_d);
                    else if (Config.POSITION==2) sliderView.setImageDrawable(R.drawable.shajek_d);
                    else if (Config.POSITION==3) sliderView.setImageDrawable(R.drawable.ratargul_d);
                    else if (Config.POSITION==4) sliderView.setImageDrawable(R.drawable.panam_l);
                    else if (Config.POSITION==5) sliderView.setImageDrawable(R.drawable.boga_e);
                    else if (Config.POSITION==6) sliderView.setImageDrawable(R.drawable.coxs_d);
                    else if (Config.POSITION==7) sliderView.setImageDrawable(R.drawable.jaflong_d);
                    else if (Config.POSITION==8) sliderView.setImageDrawable(R.drawable.lalakhal_f);
                    else if (Config.POSITION==9) sliderView.setImageDrawable(R.drawable.paharpur_d);
                    else if (Config.POSITION==10) sliderView.setImageDrawable(R.drawable.shundar_u);
                    else if (Config.POSITION==11) sliderView.setImageDrawable(R.drawable.chalanbil_d);
                    else if (Config.POSITION==12) sliderView.setImageDrawable(R.drawable.birishiri_f);
                    else if (Config.POSITION==13) sliderView.setImageDrawable(R.drawable.kuakata_d);
                    else if (Config.POSITION==14) sliderView.setImageDrawable(R.drawable.tanguar_d);
                    else if (Config.POSITION==15) sliderView.setImageDrawable(R.drawable.bichanakandi_d);
                    else if (Config.POSITION==16) sliderView.setImageDrawable(R.drawable.madhobpur_a);
                    else if (Config.POSITION==17) sliderView.setImageDrawable(R.drawable.moinot_d);
                    else if (Config.POSITION==18) sliderView.setImageDrawable(R.drawable.bandarban_c);
                    else if (Config.POSITION==19) sliderView.setImageDrawable(R.drawable.napittachora_d);
                    else if (Config.POSITION==20) sliderView.setImageDrawable(R.drawable.sakahafong_d);
                    //sliderView.setImageUrl("https://drive.google.com/open?id=1CwIKvYT2YSEDxY7GY9v3G_jc0UHetiqW");
                    break;



            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        ytPlayer = youTubePlayer;
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, 1).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }

    }

}

