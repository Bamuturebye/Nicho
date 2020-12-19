package com.example.nicho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Mine receive= new Mine(){
        @Override
        public void onReceive(Context context, Intent intent) {
            int r=intent.getIntExtra("level",0);
            ProgressBar bar=findViewById(R.id.progressBar2);
            bar.setProgress(r);
            TextView battery =findViewById(R.id.textView7);
            battery.setText(String.format("Battery level:%s%%", Integer.toString(r)));

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receive,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    //@Override
    public void onClick(View view) {
    Intent intent= new Intent(this, DisplayMessageActivity.class);
    startActivity(intent);

    }
//    public void clickHere(View v){
//        EditText name=(EditText)findViewById(R.id.editText);
//        int from = Integer.parseInt(name.getText().toString());
//
//    }

    public void clickHere(View view) {
        EditText txt = (EditText)findViewById(R.id.editText);

        int alert = Integer.parseInt(txt.getText().toString());
        Intent intent = new Intent(this,BroadcastReceiver.class);

        PendingIntent pending = PendingIntent.getBroadcast(this.getApplicationContext(),0, intent,0);
        //The alarm class to generate an alarm
        AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(alert*1000),pending);
        Toast.makeText(this,"Alarm set in"+" "+alert+" "+ "Seconds",Toast.LENGTH_LONG).show();


    }

    public void sendMessage(View view){

        EditText message;
        message = (EditText)findViewById(R.id.textView);
        Toast.makeText(this, "Sending message" + message.getText().toString(),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);

        message.setText("");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuname,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId1 = item.getItemId();
        switch (itemId1) {
            case R.id.muzik:
                startActivity(new Intent(this, Active1.class));
                return true;
            case R.id.gmail:
                Intent my = new Intent(Intent.ACTION_SEND);
                my.setData(Uri.parse("mailto:"));
                String to[]={"techindustry@gmail.com","elinahnabasitu@gmail.com"};
                my.putExtra(Intent.EXTRA_EMAIL,to);
                my.putExtra(Intent.EXTRA_SUBJECT,"Am now going");
                my.putExtra(Intent.EXTRA_TEXT,"Android is cool");
                my.setType("message/rfc822");
                startActivity(my);
                return true;
            case R.id.c:
                startActivity(new Intent(this, Active2.class));
                return true;
            case R.id.view:
                startActivity(new Intent(this, Lists.class));
                return true;
            case R.id.view1:
                startActivity(new Intent(this, Recycler.class));
                return true;
            case R.id.call_Id:
                try {
                    // check for call permissions
                    int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

                    // Here, thisActivity is the current activity
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {

                            // Show an explanation to the user *asynchronously*
                            Toast.makeText(this, "This intends to call", Toast.LENGTH_LONG).show();

                        } else {

                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);

                        }
                    }
                    Intent contact = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0704009000"));
                    startActivity(contact);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return true;

            case R.id.ringTone:
                startActivity(new Intent(this, ForegroundService.class));
                return true;

            case R.id.file:
                startActivity(new Intent(this, WriteRead.class));
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

}
