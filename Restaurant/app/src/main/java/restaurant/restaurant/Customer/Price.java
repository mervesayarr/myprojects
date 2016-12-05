package restaurant.restaurant.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


import restaurant.restaurant.Adapter.AdapterPrice;
import restaurant.restaurant.R;

public class Price extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<Product> price_list;
    String tableno;
    String waiter="";
    Button pay,callwaiter,totalamount;
  AdapterPrice adapter_items;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        pay=(Button)findViewById(R.id.btnPay);
        callwaiter=(Button) findViewById(R.id.btnCallWaiter);
        totalamount =(Button) findViewById(R.id.btnTotalAmount);
        total =(TextView) findViewById(R.id.total);

        Intent intent=getIntent();
        tableno=intent.getStringExtra("table");
        waiter=intent.getStringExtra("waiter");

        if(waiter==null){
            pay.setVisibility(View.INVISIBLE);
            callwaiter.setVisibility(View.VISIBLE);


        }
        else{
            pay.setVisibility(View.VISIBLE);
            callwaiter.setVisibility(View.INVISIBLE);


        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(layoutManager);

        price_list = new ArrayList<Product>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tables");
        query.whereEqualTo("Table", tableno);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {


                if (e == null) {
                    for (ParseObject showprice : objects) {
                        Product map = new Product();


                        map.setTable((String) showprice.get("Table").toString());
                        map.setFood((String) showprice.get("Food").toString());
                        map.setPrice((String) showprice.get("Price").toString());

                        price_list.add(map);

                        adapter_items = new AdapterPrice(Price.this, price_list);


                        recycler_view.setHasFixedSize(true);

                        recycler_view.setAdapter(adapter_items);

                        recycler_view.setItemAnimator(new DefaultItemAnimator());


                    }
                } else {
                    Log.d("", "Error: " + e.getMessage());
                }


            }


        });

        totalamount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float totalAmount = 0;
                String.format("%.3f", totalAmount);

                    for (Product tb : adapter_items.list_product) {


                        totalAmount += (Float.parseFloat(tb.getPrice()));
                    }

                    Toast.makeText(Price.this, "Total Amount: " + totalAmount + "€", Toast.LENGTH_LONG).show();


            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParseQuery<ParseObject> query = ParseQuery.getQuery("Tables");


                query.whereEqualTo("Table", tableno);

                query.findInBackground(new FindCallback<ParseObject>() {

                    @Override
                    public void done(List<ParseObject> objects, com.parse.ParseException e) {


                        if (e == null) {

                            for (ParseObject nameObj : objects) {

                                nameObj.deleteInBackground();
                                finish();
                                Toast.makeText(Price.this, "Bill Paid", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                });

            }
        });

callwaiter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ParseObject request = new ParseObject("Request");
        request.put("TableName", tableno);
        request.saveInBackground();
        Toast.makeText(Price.this,"Waiter is called",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Price.this,RestaurantMenu.class);
        startActivity(intent);


    }
});

    }



}
