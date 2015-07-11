package pe.test.clase3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by macmini14 on 11/7/15.
 */

//al declarar el broadcast receiver hay que registrarlo.
//
public class MyBroadcastReceiver extends BroadcastReceiver {
    //los eventos de broadcast llegan al on receive
    public static final String TAG = "MyBroadcastReceiver";

    @Override
    //ese intent es el broadcast que se está recibiendo

    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            case MainActivity.MENU_BUTTON_PRESSED_ACTION:
                Log.i(TAG, intent.getAction());
                Log.i(TAG, intent.getStringExtra(MainActivity.MENU_BUTTON_PRESSED_EXTRA));
                break;
            case MainActivity.MENU_BUTTON_PRESSED_EXTRA:
                break;
        }

    }
}
