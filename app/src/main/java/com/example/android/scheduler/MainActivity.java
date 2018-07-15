/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.scheduler;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


/**
 * El ejemplo muestra como programar la activación de una alarma que produce el lanazamiento
 * de un servicio. Esto es útil cuando queramos programar una alarma que inicie operaciones
 * de larga ejecución, como por ejemplo la consulta diaria de previsiones meteorológicas.
 *
 * Este ejemplo en particular obtiene contenido de la página inicial de google una vez al día y busca
 * la cadena de texto "doodle". Si la encuentra, indica que la página web de google contiene un
 * dibujo personalizado en lugar del logo estandard de google
 *.
 */
public class MainActivity extends Activity {
    SampleAlarmReceiver alarm = new SampleAlarmReceiver();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Menu options para actiar o cancelar la alarma.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Cuando el usuario pulsa START ALARM, activa la alarma.
            case R.id.start_action:
                alarm.setAlarm(this);
                return true;
            // Cuando el usuario pulsa CANCEL ALARM, cancela la alarma.
            case R.id.cancel_action:
                alarm.cancelAlarm(this);
                return true;
        }
        return false;
    }
}
