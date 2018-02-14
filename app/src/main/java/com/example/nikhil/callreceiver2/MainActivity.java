package com.example.nikhil.callreceiver2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager telephonyManager =
                (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        PhoneStateListener callStateListener = new PhoneStateListener() {
            public void onCallStateChanged(int state, String incomingNumber)
            {
                if(state==TelephonyManager.CALL_STATE_RINGING){
                    if (incomingNumber.isEmpty())
                    {
                        Log.d(TAG,"Empty");
                        Toast.makeText(getApplicationContext(),"No Number",Toast.LENGTH_LONG).show();

                    }else
                        {
                            Log.d(TAG,incomingNumber);
                            Toast.makeText(getApplicationContext(),incomingNumber,Toast.LENGTH_LONG).show();
                        }
                    String states = TelephonyManager.EXTRA_STATE;
                    String num = incomingNumber;
                    Log.d(TAG,states);
                    Toast.makeText(getApplicationContext(),"Phone Is Riging "+ num +"dones",
                            Toast.LENGTH_LONG).show();
                }
                if(state==TelephonyManager.CALL_STATE_OFFHOOK){
                    Toast.makeText(getApplicationContext(),"Phone is Currently in A call",
                            Toast.LENGTH_LONG).show();
                }

                if(state==TelephonyManager.CALL_STATE_IDLE){
                    Toast.makeText(getApplicationContext(),"phone is neither ringing nor in a call",
                            Toast.LENGTH_LONG).show();
                }
            }
        };
        telephonyManager.listen(callStateListener,PhoneStateListener.LISTEN_CALL_STATE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
