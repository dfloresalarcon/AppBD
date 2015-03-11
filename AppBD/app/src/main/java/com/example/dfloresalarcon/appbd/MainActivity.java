package com.example.dfloresalarcon.appbd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        // Escribimos 4 registros en nuestra tabla
        MDB.insertarCONTACTO(1, "Pedro", 111111111, "pedro@DB.es");
        MDB.insertarCONTACTO(2, "Sandra", 222222222, "sandra@DB.es");
        MDB.insertarCONTACTO(3, "Maria", 333333333, "maria@DB.es");
        MDB.insertarCONTACTO(4, "Daniel", 444444444, "daniel@DB.es");

        // Recuperamos los 4 registros y los mostramos en el log
        Log.d("TOTAL", Integer.toString(MDB.recuperarCONTACTOS().size()));
        int[] ids = new int[MDB.recuperarCONTACTOS().size()];
        String[] noms = new String[MDB.recuperarCONTACTOS().size()];
        int[] tlfs = new int[MDB.recuperarCONTACTOS().size()];
        String[] emls = new String[MDB.recuperarCONTACTOS().size()];
        for (int i = 0; i < MDB.recuperarCONTACTOS().size(); i++) {
            ids[i] = MDB.recuperarCONTACTOS().get(i).getID();
            noms[i] = MDB.recuperarCONTACTOS().get(i).getNOMBRE();
            tlfs[i] = MDB.recuperarCONTACTOS().get(i).getTELEFONO();
            emls[i] = MDB.recuperarCONTACTOS().get(i).getEMAIL();
            Log.d(""+ids[i], noms[i] + ", " + tlfs[i] + ", " + emls[i]);
        }

        // Modificamos el registro 3
        MDB.modificarCONTACTO(3, "PPPPP", 121212121, "xxxx@xxxx.es");

        // Recuperamos el 3 registro y lo mostramos en el log
        int id = MDB.recuperarCONTACTO(3).getID();
        String nombre = MDB.recuperarCONTACTO(3).getNOMBRE();
        int telefono = MDB.recuperarCONTACTO(3).getTELEFONO();
        String email = MDB.recuperarCONTACTO(3).getEMAIL();
        Log.d(""+id, nombre + ", " + telefono + ", " + email);

        // Borramos el registro 3
        MDB.borrarCONTACTO(3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
