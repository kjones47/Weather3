package com.example.android.weather3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    boolean faren = true;
    String message;
    boolean edited = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // boolean faren = true;
        final EditText editText = findViewById(R.id.editText);

        final TextView unit = findViewById(R.id.unit);

        final Button convert = findViewById(R.id.button);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!faren){
                    String input = editText.getEditableText().toString();
                    int temp = Integer.valueOf(input);
                    int tempF =  temp * 9 / 5 + 32;
                    editText.setText( tempF, TextView.BufferType.EDITABLE);
                    unit.setText("F");
                    faren = true;
                    convert.setText("Convert to Celcius");
                }else {
                    String input = editText.getEditableText().toString();
                    int temp = Integer.valueOf(input);
                    int tempC =(temp-32) * 5 /9;
                    editText.setText(tempC, TextView.BufferType.EDITABLE);
                    unit.setText("C");
                    faren = false;
                    convert.setText("Convert to Farenheit");
                }
                edited = true;
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edited) {
                    message = "Enter a temperature";
                } else {
                    String input = editText.getEditableText().toString();
                    int temp = Integer.valueOf(input);
                    if (faren) {
                        if (temp > 75) {
                            message = "It's blazing hot.";
                        } else if (temp > 65) {
                            message = "Its a nice day out.";
                        } else if (temp > 55) {
                            message = "Bring a jacket today!";
                        } else {
                            message = "You may freeze to death.";
                        }
                    } else {
                        if (temp > 24) {
                            message = "It's blazing hot.";
                        } else if (temp > 18) {
                            message = "Its a nice day out.";
                        } else if (temp > 13) {
                            message = "Bring a sweater today.";
                        } else {
                            message = "You may freeze to death.";
                        }
                    }
                }
                    Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
            }
        });
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
