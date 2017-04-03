package d0440672.iecs.fcu.hw3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button goPage2;
    private static final int Activity_submit=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        goPage2=(Button)findViewById(R.id.submit_btn);
        goPage2.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,page2Activity.class);
                startActivityForResult(intent,Activity_submit);
        }
        });
    }

    protected void onActivityResult (int requestCode,int resultCode, Intent intent) {


        if(intent == null) {
            return;
        }

        super.onActivityResult(requestCode,resultCode,intent);
        switch(requestCode) {
            case Activity_submit:
                String showName = intent.getStringExtra("KEY_NAME");
                Toast.makeText(MainActivity.this,"Hello"+showName,Toast.LENGTH_SHORT);
                break;
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
        else if(id==R.id.action_web){
            Uri uri=Uri.parse("http://www.gogle.com.tw");
            Intent web = new Intent();
            web.setAction(Intent.ACTION_VIEW);
            web.setData(uri);
            startActivity(web);
        }

        return super.onOptionsItemSelected(item);
    }
}
