package restaurant.restaurant.Customer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import restaurant.restaurant.Waiter.MainActivity;
import restaurant.restaurant.R;

public class RestaurantMenu extends AppCompatActivity {
    TextView beverages,soups,maincourses,dessert;
    Typeface tf1;
    String posit;
    Toolbar toolbar;
    String person="";
    String cname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        Intent intent= getIntent();
        posit = intent.getStringExtra("position");
        person=intent.getStringExtra("person");
        cname=intent.getStringExtra("cname");

        maincourses=(TextView)findViewById(R.id.txtMainCourses);
        tf1=Typeface.createFromAsset(getAssets(), "fonts/style.ttf");
        maincourses.setTypeface(tf1);

        maincourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantMenu.this, MainCourse.class);
                intent.putExtra("position", posit);
                intent.putExtra("person", person);
                intent.putExtra("cname", cname);

                startActivity(intent);
            }
        });

        dessert=(TextView)findViewById(R.id.txtDessert);
        tf1=Typeface.createFromAsset(getAssets(), "fonts/style.ttf");
        dessert.setTypeface(tf1);

        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantMenu.this, Dessert.class);
                intent.putExtra("position", posit);
                intent.putExtra("person", person);
                intent.putExtra("cname", cname);

                startActivity(intent);
            }
        });




        beverages=(TextView)findViewById(R.id.txtBeverages);
        tf1=Typeface.createFromAsset(getAssets(), "fonts/style.ttf");
        beverages.setTypeface(tf1);

        TextView tableno =(TextView) findViewById(R.id.txttable);

        tableno.setText(posit);

        beverages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(RestaurantMenu.this, Beverages.class);
                        intent.putExtra("position", posit);
                        intent.putExtra("person", person);
                        intent.putExtra("cname", cname);
                        startActivity(intent);
                    }
                }).start();
            }
        });

        soups=(TextView)findViewById(R.id.txtSoup);
        tf1=Typeface.createFromAsset(getAssets(), "fonts/style.ttf");
        soups.setTypeface(tf1);

        soups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(RestaurantMenu.this, Soup.class);
                        intent.putExtra("position", posit);
                        intent.putExtra("person", person);
                        intent.putExtra("cname", cname);
                        startActivity(intent);
                    }
                }).start();
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_homepage:


                Intent intent = new Intent(RestaurantMenu.this, MainActivity.class);

                startActivity(intent);
                return true;

            case R.id.action_callwaiter:


                Intent inten = new Intent(RestaurantMenu.this, SelectTable.class);
                inten.putExtra("cwaiter","cwaiter");
                inten.putExtra("person", person);
                inten.putExtra("cname", cname);
                startActivity(inten);

                return true;
            case R.id.action_price:
                if(posit==null){
                    Toast.makeText(RestaurantMenu.this, "Please select table", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(RestaurantMenu.this,SelectTable.class);
                    i.putExtra("person",person);
                    i.putExtra("cname",cname);
                    startActivity(i);
                }
                else{
                    Intent i =new Intent(RestaurantMenu.this,Price.class);
                    i.putExtra("table",posit);
                    i.putExtra("cname",cname);
                    startActivity(i);
                }
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }


}


