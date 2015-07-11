package pe.test.clase3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public final static String MENU_BUTTON_PRESSED_ACTION = "pe.test.clase3.MENU_BUTTON_PRESSED";
    public final static String MENU_BUTTON_PRESSED_EXTRA = "pe.test.clase3.BUTTON_NAME_EXTRA";

    MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBroadcastReceiver = new MyBroadcastReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myBroadcastReceiver);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //una buena practica es usar un action en una constante
        //un broadcast recibe un intent
        //Se recibe el string que seria el title del item(accion de apretar el boton)
        //crea objeto de manera anomima sin referencia
        sendBroadcast(new Intent(MENU_BUTTON_PRESSED_ACTION).putExtra(MENU_BUTTON_PRESSED_EXTRA, item.getTitle().toString()));
        return true;

        //para llamar al broadcast receiver en la misma aplicacion
        //sendBroadcast(new Intent(this , MyBroadcastReceiver.class));

    }

    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message = "";
            switch (intent.getAction()) {
                case Intent.ACTION_POWER_CONNECTED:
                    message = getString(R.string.power_connected);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    message = getString(R.string.power_disconnected);
                    break;

            }
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }

}


