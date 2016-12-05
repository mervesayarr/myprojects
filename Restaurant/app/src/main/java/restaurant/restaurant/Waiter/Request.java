package restaurant.restaurant.Waiter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import restaurant.restaurant.Adapter.Adapter;
import restaurant.restaurant.Customer.Product;
import restaurant.restaurant.R;

public class Request extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<Product> request_list;
    List<ParseObject> ob;
    ImageButton addbtn;
    Toolbar toolbar;
    Context c ;
    String posit,cname;
    String person="";
    Adapter adapter_items;
    ImageView delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);



        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        delete =(ImageView) findViewById(R.id.btndelete);








        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recycler_view.setLayoutManager(layoutManager);

        request_list = new ArrayList<Product>();

        try {

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                    "Request");


            ob = query.find();
            for (ParseObject request : ob) {
                Product map = new Product();
                map.setTable((String) request.get("TableName"));


                request_list.add(map);


            }
        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }


        adapter_items = new Adapter(this,request_list,"request");



        recycler_view.setHasFixedSize(true);

        recycler_view.setAdapter(adapter_items);

        recycler_view.setItemAnimator(new DefaultItemAnimator());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog rankDialog = new Dialog(Request.this, R.style.FullHeightDialog);

                rankDialog.setContentView(R.layout.rank_dialog);
                rankDialog.setCancelable(true);

                final TextView text = (TextView) rankDialog.findViewById(R.id.rank_dialog_text1);
                text.setText("Are you sure to delete request ?");

                final RatingBar ratingBar = (RatingBar) rankDialog.findViewById(R.id.dialog_ratingbar);
                ratingBar.setVisibility(View.INVISIBLE);

                Button addfav = (Button) rankDialog.findViewById(R.id.btnmyfavorite);
                addfav.setVisibility(View.INVISIBLE);

                Button cancel = (Button) rankDialog.findViewById(R.id.btncancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rankDialog.dismiss();
                    }
                });

                Button delete = (Button) rankDialog.findViewById(R.id.btnDelete);
                delete.setVisibility(View.VISIBLE);

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<Product> productList = ((Adapter) adapter_items)
                                .getList_product();
                        for (int i = 0; i < productList.size(); i++) {
                            Product product = productList.get(i);

                            if (product.isBox() == true) {
                                String name = product.getTable().toString();
                                ParseQuery<ParseObject> query = ParseQuery.getQuery("Request");


                                query.whereEqualTo("TableName", name);

                                query.findInBackground(new FindCallback<ParseObject>() {

                                    @Override
                                    public void done(List<ParseObject> objects, com.parse.ParseException e) {


                                        if (e == null) {

                                            for (ParseObject nameObj : objects) {

                                                nameObj.deleteInBackground();
                                                finish();
                                                Toast.makeText(Request.this, "Request is deleted", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }

                                });
                            }
                        }

                        rankDialog.dismiss();
                    }

                });
                //now that the dialog is set up, it's time to show it

                rankDialog.show();

            }
        });
    }

}
