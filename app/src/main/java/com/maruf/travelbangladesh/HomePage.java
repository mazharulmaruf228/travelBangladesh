package com.maruf.travelbangladesh;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class HomePage extends AppCompatActivity {




    CardView stmartin,shajek,ratargul,panamNagar,boga,coxsBazar,jaflong,lalakhal,paharpur,shundarban,chalonbil,birishiri,kuakata,tanguar,bichnakandi,hamham,moinot,amiakhum,khoiachora,keokradong;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        stmartin= (CardView) findViewById(R.id.stMartin);
        shajek= (CardView) findViewById(R.id.shajek);
        ratargul= (CardView) findViewById(R.id.ratargul);
        panamNagar= (CardView) findViewById(R.id.panamCity);
        boga = (CardView) findViewById(R.id.boga);
        coxsBazar= (CardView) findViewById(R.id.coxsBazar);
        jaflong= (CardView) findViewById(R.id.jaflong);
        lalakhal= (CardView) findViewById(R.id.lalakhal);
        paharpur= (CardView) findViewById(R.id.paharpur);
        shundarban= (CardView) findViewById(R.id.shundarban);
        chalonbil = (CardView) findViewById(R.id.chalonbill);
        birishiri= (CardView) findViewById(R.id.birishiri);
        kuakata= (CardView) findViewById(R.id.kuakata);
        tanguar= (CardView) findViewById(R.id.tanguar);
        bichnakandi= (CardView) findViewById(R.id.bichnakandi);
        hamham= (CardView) findViewById(R.id.hamham);
        moinot = (CardView) findViewById(R.id.moinot);
        amiakhum= (CardView) findViewById(R.id.amiakhum);
        khoiachora = (CardView) findViewById(R.id.khoiachora);
        keokradong= (CardView) findViewById(R.id.keokradong);



        stmartin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Config.POSITION =1;
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/stmartinpic_json.json";
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/stmartin_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/stmartinvideo_json.json";

                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);



            }
        });



        shajek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =2;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/shajek_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/shajekpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/shajekvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);




            }
        });
        ratargul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =3;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/ratargul_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/ratargulpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/ratargulvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        panamNagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =4;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/panam_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/panampic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/panamvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        boga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =5;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/boga_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/bogapic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/bogavideo_json.json";



                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);

            }
        });
        coxsBazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =6;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/coxs_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/coxspic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/coxsvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);






            }
        });


        jaflong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Config.POSITION =7;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/jaflong_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/jaflongpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/jaflongvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);



            }
        });



        lalakhal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Config.POSITION =8;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/lalakhal_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/lalakhalpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/lalakhalvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        paharpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =9;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/paharpur_json.json";

                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/paharpurpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/paharpurvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        shundarban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =10;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/shundarban_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/shundarbanpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/shundarbanvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);

            }
        });
        chalonbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =11;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/chalanbil_json.json";

                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/chalanbilpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/chalanbilvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        birishiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =12;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/birishiri_json.json";

                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/birishiripic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/birishirivideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });

        kuakata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =13;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/kuakata_json.json";

                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/kuakatapic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/kuakatavideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);



            }
        });



        tanguar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =14;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/tanguar_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/tanguarpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/tanguarvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);


            }
        });
        bichnakandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =15;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/bichanakandi_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/bichanakandipic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/bichanakandivideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        hamham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =16;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/hamham_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/hamhampic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/hamhamvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        moinot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =17;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/moinot_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/moinotpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/moinotvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        amiakhum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =18;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/nafakhum_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/nafakhumpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/nafakhumvideo_json.json";


                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);


            }
        });
        khoiachora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =19;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/khoiachora_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/khoiachorapic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/khoiachoravideo_json.json";

                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
        keokradong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.POSITION =20;
                Config.WRITER_URL = "https://mazharulmaruf228.000webhostapp.com/app/writing_json/keokradong_json.json";
                Config.IMAGE_URL = "https://mazharulmaruf228.000webhostapp.com/app/photo_json/keokradongpic_json.json";
                Config.VIDEO_URL = "https://mazharulmaruf228.000webhostapp.com/app/video_json/keokradongvideo_json.json";

                Intent myIntent= new Intent(HomePage.this,SaintMartin.class);
                startActivity(myIntent);
            }
        });
    }








}
