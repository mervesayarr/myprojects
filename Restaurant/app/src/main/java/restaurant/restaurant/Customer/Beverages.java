
package restaurant.restaurant.Customer;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import restaurant.restaurant.Adapter.ViewPagerAdapter;
import restaurant.restaurant.R;


public class Beverages extends AppCompatActivity {


    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Hot Drinks","Cold Drinks"};
    int Numboftabs =2;
    String posit,cname;
    String person="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);

        Intent intent= getIntent();
        posit = intent.getStringExtra("position");
        person = intent.getStringExtra("person");
        cname=intent.getStringExtra("cname");



        if(cname==null)
        { final Dialog rankDialog = new Dialog(Beverages.this, R.style.FullHeightDialog);

            rankDialog.setContentView(R.layout.rank_dialog);
            rankDialog.setCancelable(true);

            final TextView text = (TextView) rankDialog.findViewById(R.id.rank_dialog_text1);
            text.setText("In order to order a meal,firstly you should be logged, click green button at bottom right..");

            final RatingBar ratingBar = (RatingBar) rankDialog.findViewById(R.id.dialog_ratingbar);
            ratingBar.setVisibility(View.INVISIBLE);

            Button addfav = (Button) rankDialog.findViewById(R.id.btnmyfavorite);
            addfav.setVisibility(View.INVISIBLE);

            Button cancel = (Button) rankDialog.findViewById(R.id.btncancel);
            cancel.setText("Ok");
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rankDialog.dismiss();
                }
            });

            rankDialog.show();
        }

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        if(person==null)
            toolbar.setVisibility(View.INVISIBLE);

        else

            toolbar.setVisibility(View.VISIBLE);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles for the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs,posit,person,cname);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.table, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_table:

                Intent intent =new Intent(Beverages.this,SelectTable.class);
                intent.putExtra("person","customer");
                startActivity(intent);
                return true;
            case R.id.action_price:
                if(posit==null){
                    Toast.makeText(Beverages.this, "Please select table", Toast.LENGTH_LONG).show();
                    Intent i =new Intent(Beverages.this,SelectTable.class);
                    i.putExtra("person",person);
                    i.putExtra("cname",cname);
                    startActivity(i);
                }
                else{
                    Intent i =new Intent(Beverages.this,Price.class);
                    i.putExtra("table",posit);
                    i.putExtra("cname",cname);
                    startActivity(i);
                }
                return true;


            case R.id.action_fav:
                Intent inte =new Intent(Beverages.this,MyFavorite.class);

                inte.putExtra("cname",cname);
                startActivity(inte);
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }



}