package com.example.quickmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void sendMessage(View view) {
        int toId=((RadioGroup)findViewById(R.id.radioGroup1)).getCheckedRadioButtonId();
        int msgId=((RadioGroup)findViewById(R.id.radioGroup2)).getCheckedRadioButtonId();

        String toName=((RadioButton)findViewById(toId)).getText().toString();
        String message=((RadioButton)findViewById(msgId)).getText().toString();


      //  Log.v("TO:",toName);
     //   Log.v("Message:",message);

        String email="";
        switch (toName){
            case "Irwin":
                email="irwin@example.com";
                break;
            case "Evans":
                email="evans@example.com";
                break;
            case  "Caroline":
                email="caroline@example.com";
                break;
        }

        //Log.v("Email:",email);

  Uri uri= Uri.parse("mailto:"+email);
        Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Sent from QuickMail App.");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(intent);

    }
}