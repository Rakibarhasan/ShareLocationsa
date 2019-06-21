package com.example.sharelocationsa;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;

public class ExtraPage extends AppCompatActivity {


    Button btnShowNotification1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_page);




        Button language=(Button) findViewById(R.id.language);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtraPage.this,Main3Activity.class);
                startActivity(intent);
            }
        });


        Button abuting=(Button) findViewById(R.id.abut);
        abuting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtraPage.this,about.class);
                startActivity(intent);
            }
        });

        Button manupage=(Button) findViewById(R.id.menupage);
        manupage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtraPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button inter=(Button)findViewById(R.id.internet);
        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExtraPage.this, Internetcheck.class);
                startActivity(intent);

            }
        });



        Button user=(Button) findViewById(R.id.user);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtraPage.this,gallery.class);
                startActivity(intent);
            }
        });

        Button about=(Button) findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtraPage.this,OutdorLocation.class);
                startActivity(intent);
            }
        });

        Button button15=(Button) findViewById(R.id.button15);

        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtraPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button button5=(Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExtraPage.this,Check_netConnection.class);
                startActivity(intent);
            }
        });

        // notification




                btnShowNotification1 = (Button) findViewById(R.id.demo);
                btnShowNotification1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Assign big picture notification
                        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.notific)).build();

                        // Gets an instance of the NotificationManager service
                        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                        //set intents and pending intents to call activity on click of "show activity" action button of notification
                        Intent resultIntent = new Intent(ExtraPage.this, Location.class);
                        Intent resultIntent2 = new Intent(ExtraPage.this, Main2Activity.class);
                        Intent resultIntent3 = new Intent(ExtraPage.this, MainActivity.class);


                        resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        resultIntent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        resultIntent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


                        PendingIntent piResult2 = PendingIntent.getActivity(ExtraPage.this, (int) Calendar.getInstance().getTimeInMillis(), resultIntent2, 0);

                        PendingIntent piResult = PendingIntent.getActivity(ExtraPage.this, (int) Calendar.getInstance().getTimeInMillis(), resultIntent, 0);

                        PendingIntent piResult3 = PendingIntent.getActivity(ExtraPage.this, (int) Calendar.getInstance().getTimeInMillis(), resultIntent3, 0);

                        NotificationCompat.Builder builder =
                                new NotificationCompat.Builder(ExtraPage.this)
                                        .setSmallIcon(R.drawable.bir2)
                                        .setContentTitle("Share Location")
                                        .setContentText("Choose your Option Selected")
                                        .setStyle(bigPictureStyle)
                                        .addAction(R.drawable.ic_my_location_black_24dp, "Location", piResult)
                                        .addAction(R.drawable.ic_share_black_24dp, "Sharing", piResult2)
                                        .addAction(R.drawable.ic_home_black_24dp, "Home", piResult3)

                                        .addAction(R.drawable.ic_android_black_24dp, "", PendingIntent.getActivity(getApplicationContext(), 0, getIntent(), 0, null));

                        //to post your notification to the notification bar
                        notificationManager.notify(0, builder.build());



                    }
                });


    }
    //map
    public void onMapBtnClick(View view) {

        // Case-1
        // To open google map app
        // String uri = "http://maps.google.com/maps?q=";

        // Case-2
        // To open google map with specific location
        //  packageName + latitude + longitude + place title
        // String uri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + mTitle + ")";
        String geoUri = "http://maps.google.com/maps?q=loc:" + 23.17024 + "," + 90.831061 + " (" + ")";

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
        this.startActivity(mapIntent);

    }

}
