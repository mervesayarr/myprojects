package restaurant.restaurant.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.squareup.picasso.Picasso;

import java.util.List;

import restaurant.restaurant.Customer.Product;
import restaurant.restaurant.R;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Activity activity;

    Context c;
    String person="";
    String cname;
    List<Product> list_product;
    private LayoutInflater inflater;





    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView product_name,price_euro;
        public TextView product_price;
        public RelativeLayout relative_layout;
        public LinearLayout linear;
        public ImageView product_image;
        public CardView card_view;
        public CheckBox checkbox,checkboxlike,checkboxunlike,delete;
        public RatingBar rbar;
       public EditText amount;



        public ViewHolder(View view) {
            super(view);

            card_view = (CardView)view.findViewById(R.id.card_view);
            relative_layout =(RelativeLayout) view.findViewById(R.id.relative);
            linear=(LinearLayout)view.findViewById(R.id.linear);
            product_name = (TextView)view.findViewById(R.id.soup_name);
            price_euro=(TextView)view.findViewById(R.id.price_euro);
            product_price = (TextView)view.findViewById(R.id.soup_price);
            product_image = (ImageView)view.findViewById(R.id.soup_photo);
            checkbox = (CheckBox) view.findViewById(R.id.checkBoxadd);
            checkboxlike = (CheckBox) view.findViewById(R.id.checkBoxlike);
            checkboxunlike= (CheckBox) view.findViewById(R.id.checkBoxunlike);
            delete= (CheckBox) view.findViewById(R.id.checkBoxdelete);
            rbar=(RatingBar)view.findViewById(R.id.ratingb);
           amount=(EditText) view.findViewById(R.id.editTextamount);


        }
    }




    public Adapter(Activity activity, List<Product> list_product,String person) {

        inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list_product = list_product;
        this.person=person;
        this.c=activity;
    }
    public void Adapter(String cname) {


        this.cname=cname;

    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);

        ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if(person==null){
            holder.checkboxlike.setVisibility(View.INVISIBLE);
            holder.checkboxunlike.setVisibility(View.INVISIBLE);
            holder.checkbox.setVisibility(View.INVISIBLE);

            holder.product_name.setText(list_product.get(position).getName());
            holder.product_price.setText(list_product.get(position).getPrice());

            String uri = list_product.get(position).getPhoto();
            Picasso.with(c).load(uri).into(holder.product_image);

        }
       else if(person=="fav"){
            holder.checkboxlike.setVisibility(View.INVISIBLE);
            holder.checkboxunlike.setVisibility(View.INVISIBLE);
            holder.checkbox.setVisibility(View.INVISIBLE);
            holder.price_euro.setVisibility(View.INVISIBLE);
            holder.delete.setVisibility(View.VISIBLE);

            holder.product_name.setText(list_product.get(position).getFood());

            String rate =((list_product.get(position).getRate()));
            LayerDrawable stars = (LayerDrawable) holder.rbar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
            holder.rbar.setVisibility(View.VISIBLE);
            holder.rbar.setRating(Float.parseFloat(rate));


            holder.relative_layout.setBackgroundColor(Color.RED);
            holder.product_name.setTypeface(null, Typeface.BOLD);

            holder.product_name.setTextColor(Color.WHITE);

        }
        else if(person=="request"){
            holder.checkboxlike.setVisibility(View.INVISIBLE);
            holder.checkboxunlike.setVisibility(View.INVISIBLE);
            holder.checkbox.setVisibility(View.INVISIBLE);
            holder.price_euro.setVisibility(View.INVISIBLE);
            holder.delete.setVisibility(View.VISIBLE);

            holder.product_name.setText(list_product.get(position).getTable());


            holder.relative_layout.setBackgroundColor(Color.parseColor("#FFE461AB"));



            holder.product_name.setTextColor(Color.WHITE);
            holder.product_name.setTextSize(20);
            holder.product_name.setTypeface(null, Typeface.BOLD);


        }
        else if (person.equals("waiter")){
            holder.checkboxlike.setVisibility(View.INVISIBLE);
            holder.checkboxunlike.setVisibility(View.INVISIBLE);
            holder.checkbox.setVisibility(View.INVISIBLE);
            holder.product_name.setText(list_product.get(position).getTable()+"\n"+list_product.get(position).getFood());
            holder.product_price.setText(list_product.get(position).getPrice());



        }
        else if(person.equals("customer")){
            holder.checkboxlike.setVisibility(View.VISIBLE);
            holder.checkboxunlike.setVisibility(View.VISIBLE);
            holder.checkbox.setVisibility(View.VISIBLE);
            holder.product_name.setText(list_product.get(position).getName());
            holder.product_price.setText(list_product.get(position).getPrice());

            String uri = list_product.get(position).getPhoto();
            Picasso.with(c).load(uri).into(holder.product_image);


        }
        else if (person.equals("feedback")){
            holder.checkboxlike.setVisibility(View.INVISIBLE);
            holder.checkboxunlike.setVisibility(View.INVISIBLE);
            holder.checkbox.setVisibility(View.INVISIBLE);
            holder.price_euro.setVisibility(View.INVISIBLE);
            holder.product_name.setText("\n" + list_product.get(position).getFeedback());
            holder.product_price.setText(list_product.get(position).getPrice());

            holder.relative_layout.setBackgroundColor(Color.parseColor("#6f52d1"));

            holder.product_name.setTextColor(Color.WHITE);
            holder.product_price.setTextColor(Color.WHITE);
            holder.product_name.setTypeface(null, Typeface.BOLD);
            holder.product_price.setTypeface(null, Typeface.BOLD);



        }
        else if (person.equals("unlike")){
            holder.checkboxlike.setVisibility(View.INVISIBLE);
            holder.checkboxunlike.setVisibility(View.INVISIBLE);
            holder.checkbox.setVisibility(View.INVISIBLE);
            holder.price_euro.setVisibility(View.INVISIBLE);
            holder.product_name.setText("\n" + list_product.get(position).getFood());
            holder.product_price.setText(list_product.get(position).getPrice());

            holder.relative_layout.setBackgroundColor(Color.parseColor("#6f52d1"));

            holder.product_name.setTextColor(Color.WHITE);
            holder.product_price.setTextColor(Color.WHITE);

            holder.product_name.setTypeface(null, Typeface.BOLD);
            holder.product_price.setTypeface(null, Typeface.BOLD);

        }



        holder.checkboxlike.setChecked(list_product.get(position).isLike());
        holder.checkboxlike.setTag(list_product.get(position));


        holder.checkboxlike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Product product = (Product) cb.getTag();

                product.setLike(cb.isChecked());
                list_product.get(position).setLike(cb.isChecked());


                holder.checkboxunlike.setChecked(false);

               final  Dialog rankDialog = new Dialog(c, R.style.FullHeightDialog);

                rankDialog.setContentView(R.layout.rank_dialog);
                rankDialog.setCancelable(true);
                final RatingBar ratingBar = (RatingBar) rankDialog.findViewById(R.id.dialog_ratingbar);
               final TextView text = (TextView) rankDialog.findViewById(R.id.rank_dialog_text1);

              //  final LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();



             /*   ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating,
                                                boolean fromUser) {
                        ratingBar.setRating(rating);

                        if (ratingBar.getRating() <= 3.0) {
                            stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                            text.setText("Not Bad");
                        } else if (ratingBar.getRating() == 4.0) {
                            stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
                            text.setText("Good");
                        } else if (ratingBar.getRating() == 5.0) {
                            stars.getDrawable(2).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                            text.setText("Excellent");
                        }
                    }
                });*/




                Button addfav = (Button) rankDialog.findViewById(R.id.btnmyfavorite);
                addfav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        ParseObject favorite = new ParseObject("Favorite");
                        favorite.put("Customer", cname);
                        favorite.put("Food", list_product.get(position).getName());
                        favorite.put("Rate", String.valueOf(ratingBar.getRating()));

                        favorite.saveInBackground();
                        rankDialog.dismiss();
                    }

                });
                //now that the dialog is set up, it's time to show it

                Button cancel = (Button) rankDialog.findViewById(R.id.btncancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rankDialog.dismiss();
                    }
                });
                rankDialog.show();



            }
        });

        holder.checkboxunlike.setChecked(list_product.get(position).isLike());
        holder.checkboxunlike.setTag(list_product.get(position));


        holder.checkboxunlike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Product product = (Product) cb.getTag();

                product.setLike(cb.isChecked());
                list_product.get(position).setLike(cb.isChecked());


                holder.checkboxlike.setChecked(false);

                LayoutInflater li = LayoutInflater.from(c);
                View promptsView = li.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        c);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);


                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        String result = userInput.getText().toString();
                                       if(!result.isEmpty()) {
                                           ParseObject fback = new ParseObject("Unlike");
                                           fback.put("Reason", result);
                                           fback.put("Food", list_product.get(position).getName());
                                           fback.saveInBackground();
                                           Toast.makeText(c,"Thank you for your review",Toast.LENGTH_LONG).show();

                                       }
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });






        holder.checkbox.setChecked(list_product.get(position).isBox());
        holder.checkbox.setTag(list_product.get(position));


        holder.checkbox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Product product = (Product) cb.getTag();

                product.setBox(cb.isChecked());
                list_product.get(position).setBox(cb.isChecked());


            }
        });

        holder.delete.setChecked(list_product.get(position).isBox());
        holder.delete.setTag(list_product.get(position));


        holder.delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Product product = (Product) cb.getTag();

                product.setBox(cb.isChecked());






            }
        });

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
