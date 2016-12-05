package restaurant.restaurant.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.parse.ParseObject;

import restaurant.restaurant.Adapter.GridViewAdapter;
import restaurant.restaurant.R;

public class SelectTable extends AppCompatActivity {
    GridView gv;
    String person="customer";
    String cname,cwaiter;


    public static String [] tableList={"Table 0","Table 1","Table 2","Table 3","Table 4","Table 5","Table 6","Table 7","Table 8"
            };
    public static int [] tableImages={R.mipmap.tbl,R.mipmap.tbl,R.mipmap.tbl,R.mipmap.tbl,R.mipmap.tbl,
            R.mipmap.tbl,R.mipmap.tbl,R.mipmap.tbl,R.mipmap.tbl
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_table);

        Intent intent= getIntent();
        person = intent.getStringExtra("person");
        cname = intent.getStringExtra("cname");
        cwaiter = intent.getStringExtra("cwaiter");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new GridViewAdapter(this, tableList, tableImages));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                    if(cwaiter==null){
                    Intent intent = new Intent(SelectTable.this, RestaurantMenu.class);
                    intent.putExtra("position", "Table " + position);
                    intent.putExtra("person", person);
                     intent.putExtra("cname", cname);

                        startActivity(intent);}
                else if (cwaiter.equals("cwaiter")){
                        ParseObject request = new ParseObject("Request");
                        request.put("TableName", "Table " + position);
                        request.saveInBackground();
                        Toast.makeText(SelectTable.this, "Waiter is called", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SelectTable.this,RestaurantMenu.class);
                        intent.putExtra("cname",cname);
                        intent.putExtra("person", person);
                        Toast.makeText(SelectTable.this, "Waiter is called", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }


            }


        });


    }

}
