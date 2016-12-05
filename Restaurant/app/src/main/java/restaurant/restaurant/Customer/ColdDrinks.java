package restaurant.restaurant.Customer;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import restaurant.restaurant.Adapter.Adapter;
import restaurant.restaurant.R;


public class ColdDrinks extends Fragment {

    private List<Product> beverage_list;
    List<ParseObject> ob;
    ImageButton addbtn;
    Adapter mAdapter;
    Activity c;
    RecyclerView recyclerView;
    Beverages t;
    String posit,cname;
    String person="";
    public void posit(String posit){
        this.posit=posit;
    }
    public void person(String person){
        this.person=person;
    }
    public void cname(String cname){
        this.cname=cname;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        addbtn = (ImageButton)v. findViewById(R.id.btnadd);

        SearchView search = (SearchView) v.findViewById( R.id.search);
        search.setOnQueryTextListener(listener);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        beverage_list = new ArrayList<Product>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Beverages");
        query.whereEqualTo("Type", "Cold Drink");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {

                if (e == null) {
                    for (ParseObject  beverage : objects) {
                        Product map = new Product();
                        map.setName((String)  beverage.get("Name"));
                        map.setPrice((String)  beverage.get("Price"));
                        ParseFile image = (ParseFile)  beverage.getParseFile("image");
                        map.setPhoto(image.getUrl().toString());
                        beverage_list.add(map);


                        c = getActivity();
                          // 3. create an adapter
                        mAdapter = new Adapter(c,  beverage_list,person);
                        mAdapter.Adapter(cname);
                        // 4. set adapter
                        recyclerView.setAdapter(mAdapter);
                        // 5. set item animator to DefaultAnimator
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        addbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (person == null) {
                                    Toast.makeText(c, "Please Login to order!!!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(c, Loginc.class);
                                    startActivity(intent);
                                } else {
                                    if (posit == null) {
                                        Toast.makeText(c, "Please Select Table Number!!!", Toast.LENGTH_LONG).show();
                                        Intent intent =new Intent(c,SelectTable.class);
                                        intent.putExtra("person",person);
                                        intent.putExtra("cname",cname);
                                        startActivity(intent);
                                    } else {
                                        String result = "";
                                        int totalAmount = 0;
                                        List<Product> productList = ((Adapter) mAdapter)
                                                .getList_product();

                                        for (int i = 0; i < productList.size(); i++) {
                                            Product product = productList.get(i);
                                            if (product.isBox() == true) {
                                                result = result + "\n" + product.getName().toString();
                                                totalAmount += (Integer.parseInt(product.getPrice().toString()));

                                            }
                                        }
                                        if (totalAmount != 0) {
                                            ParseObject tables = new ParseObject("Tables");
                                            tables.put("Table", posit);
                                            tables.put("Food", result);
                                            tables.put("Price", totalAmount);
                                            tables.saveInBackground();
                                            Toast.makeText(c, result + "\n" + "Total Amount:=" + totalAmount + "€" + "\n", Toast.LENGTH_LONG).show();
                                        } else {
                                            Toast.makeText(c, "Please select product !!", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                }
                            }
                        });

                    }
                } else {
                    Log.d("", "Error: " + e.getMessage());
                }


            }


        });




        return v;
    }
    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String query) {
            query = query.toLowerCase();

            final List<Product> list = new ArrayList<>();

            for (int i = 0; i <  beverage_list.size(); i++) {

                final String text =  beverage_list.get(i).getName().toString().toLowerCase();
                if (text.contains(query)) {

                    list.add( beverage_list.get(i));
                }
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(c));
            mAdapter = new Adapter(c, list,person);
            recyclerView.setAdapter(mAdapter);
            mAdapter.Adapter(cname);
            mAdapter.notifyDataSetChanged();  // data set changed
            return true;

        }
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    };
}
