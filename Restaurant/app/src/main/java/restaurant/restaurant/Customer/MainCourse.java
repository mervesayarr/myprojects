package restaurant.restaurant.Customer;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import restaurant.restaurant.Adapter.Adapter;
import restaurant.restaurant.R;


public class MainCourse extends ActionBarActivity {

    private RecyclerView recycler_view;
    private List<Product> maincourse_list;
    List<ParseObject> ob;
    ImageButton addbtn;
    Toolbar toolbar;
    Context c ;
    String posit,cname;
    String person="";
    Adapter adapter_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        Intent intent= getIntent();
        posit = intent.getStringExtra("position");
        person = intent.getStringExtra("person");
        cname=intent.getStringExtra("cname");

        if(cname==null)
        { final Dialog rankDialog = new Dialog(MainCourse.this, R.style.FullHeightDialog);

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

        SearchView search = (SearchView) findViewById( R.id.search);
        search.setOnQueryTextListener(listener);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        addbtn = (ImageButton) findViewById(R.id.btnadd);





        if(person==null)
            toolbar.setVisibility(View.INVISIBLE);

        else

            toolbar.setVisibility(View.VISIBLE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recycler_view.setLayoutManager(layoutManager);

        maincourse_list = new ArrayList<Product>();

        try {

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "MainCourse");


            ob = query.find();
            for (ParseObject maincourse : ob) {
                Product map = new Product();
                map.setName((String) maincourse.get("Name"));
                map.setPrice((String) maincourse.get("Price"));
                ParseFile image = (ParseFile) maincourse.getParseFile("image");
                map.setPhoto(image.getUrl().toString());

                maincourse_list.add(map);


            }
        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }


        adapter_items = new Adapter(this,maincourse_list,person);

        adapter_items.Adapter(cname);

        recycler_view.setHasFixedSize(true);

        recycler_view.setAdapter(adapter_items);

        recycler_view.setItemAnimator(new DefaultItemAnimator());


        recycler_view.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {



            @Override
            public void onTouchEvent(RecyclerView recycler, MotionEvent event) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recycler, MotionEvent event) {
                return false;
            }

        });


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (person == null) {
                    Toast.makeText(MainCourse.this, "Please Login to order!!!", Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(MainCourse.this,Loginc.class);
                    startActivity(intent);
                } else {
                    if (posit == null) {
                        Toast.makeText(MainCourse.this, "Please Select Table Number!!!", Toast.LENGTH_LONG).show();
                        Intent intent =new Intent(MainCourse.this,SelectTable.class);
                        intent.putExtra("person",person);
                        intent.putExtra("cname",cname);
                        startActivity(intent);
                    } else {

                        String result = "";
                        float totalAmount = 0;

                        List<Product> productList = ((Adapter) adapter_items)
                                .getList_product();

                        for (int i = 0; i < productList.size(); i++) {
                            Product product = productList.get(i);

                            if (product.isBox() == true) {
                                result = result + "\n" + product.getName().toString();
                                totalAmount += (Float.parseFloat(product.getPrice().toString()));



                            }

                        }
                        if (totalAmount != 0) {
                            ParseObject tables = new ParseObject("Tables");
                            tables.put("Table", posit);
                            tables.put("Food", result);
                            tables.put("Price", totalAmount);
                            tables.saveInBackground();
                            Toast.makeText(MainCourse.this, result + "\n" + "Total Amount:=" + totalAmount + "€" + "\n", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainCourse.this, "Please select product !!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String query) {
            query = query.toLowerCase();

            final List<Product> list = new ArrayList<>();

            for (int i = 0; i < maincourse_list.size(); i++) {

                final String text = maincourse_list.get(i).getName().toString().toLowerCase();
                if (text.contains(query)) {

                    list.add(maincourse_list.get(i));
                }
            }

            recycler_view.setLayoutManager(new LinearLayoutManager(MainCourse.this));
            adapter_items = new Adapter(MainCourse.this, list,person);
            adapter_items.Adapter(cname);
            recycler_view.setAdapter(adapter_items);
            adapter_items.notifyDataSetChanged();  // data set changed
            return true;

        }
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.table, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_table:

                Intent intent =new Intent(MainCourse.this,SelectTable.class);
                intent.putExtra("person","customer");
                intent.putExtra("cname",cname);
                startActivity(intent);
                return true;

            case R.id.action_price:
                if(posit==null){
                    Toast.makeText(MainCourse.this,"Please select table",Toast.LENGTH_LONG).show();
                    Intent i =new Intent(MainCourse.this,SelectTable.class);
                    i.putExtra("person",person);
                    i.putExtra("cname",cname);
                    startActivity(i);
                }
                else{
                    Intent i =new Intent(MainCourse.this,Price.class);
                    i.putExtra("table",posit);
                    i.putExtra("cname",cname);
                    startActivity(i);
                }
                return true;
            case R.id.action_fav:
                Intent inte =new Intent(MainCourse.this,MyFavorite.class);

                inte.putExtra("cname",cname);
                startActivity(inte);
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }



}