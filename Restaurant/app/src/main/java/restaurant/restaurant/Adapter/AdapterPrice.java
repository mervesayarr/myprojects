package restaurant.restaurant.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import restaurant.restaurant.Customer.Product;
import restaurant.restaurant.R;

/**
 * Created by ASUS on 18.3.2016.
 */
public class AdapterPrice extends RecyclerView.Adapter<AdapterPrice.ViewHolder>{

    Activity activity;

    Context c;

    public List<Product> list_product;
    private LayoutInflater inflater;

    public AdapterPrice(Context c, List<Product> product_list) {
        this.list_product = product_list;
        this.c=c;


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView product_name;
        public TextView product_price;
        public CardView card_view;
        public TextView p_name;


        public ViewHolder(View view) {
            super(view);

            card_view = (CardView)view.findViewById(R.id.card_layout_1);
            product_name = (TextView)view.findViewById(R.id.soup_name);
            product_price = (TextView)view.findViewById(R.id.soup_price);
            p_name = (TextView)view.findViewById(R.id.product_name);



        }
    }

    public AdapterPrice(Activity activity, List<Product> list_product) {

        inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list_product = list_product;
        this.c=activity;
    }
    @Override
    public AdapterPrice.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_1, parent, false);

        ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.product_name.setText(list_product.get(position).getFood());
        holder.p_name.setText(list_product.get(position).getTable());
        holder.product_price.setText(list_product.get(position).getPrice());

    }


    public Object getItem(int position) {
        return list_product.get(position);
    }

    @Override
    public int getItemCount() {
        return list_product.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }






    public List<Product> getList_product() {
        return list_product;
    }

}