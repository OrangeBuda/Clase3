package pe.test.clase3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
    public final static String MENU_BUTTON_PRESSED_ACTION = "pe.test.clase3.MENU_BUTTON_PRESSED";
    public final static String MENU_BUTTON_PRESSED_EXTRA = "pe.test.clase3.BUTTON_NAME_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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




    }
}
