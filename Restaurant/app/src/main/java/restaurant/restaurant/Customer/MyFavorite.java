package restaurant.restaurant.Customer;

import android.app.Dialog;
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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import restaurant.restaurant.Adapter.Adapter;
import restaurant.restaurant.R;

public class MyFavorite extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<Product> fav_list;
    String cname;
    ImageView delete;
    Adapter adapter_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        delete=(ImageView)findViewById(R.id.btndelete);

        Intent intent=getIntent();
        cname=intent.getStringExtra("cname");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(layoutManager);
        fav_list = new ArrayList<Product>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Favorite");
        query.whereEqualTo("Customer", cname);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {


                if (e == null) {
                    for (ParseObject fav : objects) {
                        Product map = new Product();


                        map.setFood((String) fav.get("Food").toString());
                        map.setRate((String) fav.get("Rate").toString());

                        fav_list.add(map);

                        adapter_items = new Adapter(MyFavorite.this, fav_list, "fav");


                        recycler_view.setHasFixedSize(true);

                        recycler_view.setAdapter(adapter_items);

                        recycler_view.setItemAnimator(new DefaultItemAnimator());


                    }
                } else {
                    Log.d("", "Error: " + e.getMessage());
                }


            }


        });
    delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final Dialog rankDialog = new Dialog(MyFavorite.this, R.style.FullHeightDialog);

            rankDialog.setContentView(R.layout.rank_dialog);
            rankDialog.setCancelable(true);

            final TextView text = (TextView) rankDialog.findViewById(R.id.rank_dialog_text1);
            text.setText("Are you sure to delete ?");

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
                            String name=product.getFood().toString();
                            ParseQuery<ParseObject> query = ParseQuery.getQuery("Favorite");


                            query.whereEqualTo("Food",name);

                            query.findInBackground(new FindCallback<ParseObject>() {

                                @Override
                                public void done(List<ParseObject> objects, com.parse.ParseException e) {


                                    if (e == null) {

                                        for (ParseObject nameObj : objects) {

                                            nameObj.deleteInBackground();
                                            finish();
                                            Toast.makeText(MyFavorite.this, "Deleted", Toast.LENGTH_LONG).show();
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
