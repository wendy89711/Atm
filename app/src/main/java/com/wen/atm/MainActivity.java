package com.wen.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN = 21;
    boolean logon = false;
    private PokerCard card;
    String[] func = {"餘額查詢","交易明細","最新消息","投資理財","離開"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        String user = "wendy";
//        SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
//        pref.edit()
//                .putString("USER", user)//資料標籤叫"USER"
//                .putInt("STAGE", 3)
//                .putFloat("HP", 98.3f)
//                .commit();
//        String userid = getSharedPreferences("test",MODE_PRIVATE)
//                .getString("USER","");

//        ListView list = (ListView) findViewById(R.id.list);
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,func);
//        list.setAdapter(adapter);
        card = findViewById(R.id.card);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card.setValue(24);
            }
        });
        if (!logon) {
            Intent login = new Intent(this,LoginActivity.class);
//            startActivity(login);
            startActivityForResult(login,REQUEST_CODE_LOGIN);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
                logon = true;
            }
        }
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
