package restaurant.restaurant.Waiter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.ParseACL;
import com.parse.ParseObject;

import java.util.List;

import restaurant.restaurant.Adapter.Adapter;
import restaurant.restaurant.Customer.Product;
import restaurant.restaurant.R;

public class Waiter extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<Product> show_list;
    List<ParseObject> ob;

    Adapter adapter_items;
    Button showprice,showfeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);


        showprice=(Button) findViewById(R.id.btnshowprice);
        showfeedback=(Button) findViewById(R.id.btnshowfeedback);
        showprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseACL defaultACL = new ParseACL();


                defaultACL.setPublicReadAccess(true);

                ParseACL.setDefaultACL(defaultACL, true);

                Intent intent =new Intent(Waiter.this,Tables.class);

                startActivity(intent);
            }
        });

        showfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Waiter.this,ShowWaiter.class);
                startActivity(i);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_request) {
            Intent intent = new Intent(Waiter.this,Request.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}