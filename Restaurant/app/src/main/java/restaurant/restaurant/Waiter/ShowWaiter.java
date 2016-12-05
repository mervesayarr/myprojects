package restaurant.restaurant.Waiter;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import restaurant.restaurant.Adapter.Adapter;
import restaurant.restaurant.Customer.Product;
import restaurant.restaurant.R;

public class ShowWaiter extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<Product> show_list;
    List<ParseObject> ob;
    Typeface tf1;
    Adapter adapter_items;
    Button feedback, unlike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_waiter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);


        LinearLayoutManager layoutManager = new LinearLayoutManager(ShowWaiter.this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);


        recycler_view.setLayoutManager(layoutManager);




    }

    public void feedback() {

        show_list = new ArrayList<Product>();
        try {

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "Feedback");


            ob = query.find();
            for (ParseObject fb : ob) {
                Product map = new Product();
                map.setPrice((String) fb.get("Feedback"));
                map.setFeedback((String) fb.get("Date"));

                show_list.add(map);


            }
        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        adapter_items = new Adapter(ShowWaiter.this, show_list, "feedback");


        recycler_view.setHasFixedSize(true);

        recycler_view.setAdapter(adapter_items);

        recycler_view.setItemAnimator(new DefaultItemAnimator());
    }


    public void showunlike() {

        show_list = new ArrayList<Product>();
        try {

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "Unlike");


            ob = query.find();
            for (ParseObject ul : ob) {
                Product map = new Product();
                map.setFood((String) ul.get("Food"));
                map.setPrice((String) ul.get("Reason"));

                show_list.add(map);


            }
        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        adapter_items = new Adapter(ShowWaiter.this, show_list, "unlike");


        recycler_view.setHasFixedSize(true);

        recycler_view.setAdapter(adapter_items);

        recycler_view.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.waiter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_feedback:

                feedback();
                return true;

            case R.id.action_unlike:

                showunlike();
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }
}
