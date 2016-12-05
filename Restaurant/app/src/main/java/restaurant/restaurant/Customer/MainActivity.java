package restaurant.restaurant.Customer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseACL;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

import restaurant.restaurant.R;
import restaurant.restaurant.Waiter.Login;
import restaurant.restaurant.Waiter.Waiter;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    ImageView logout;
    TextView menu,signup;
    Typeface tf1;

    ParseUser username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        signup=(TextView)findViewById(R.id.txtsignup);

        menu=(TextView)findViewById(R.id.txtmenu);
        tf1=Typeface.createFromAsset(getAssets(), "fonts/style.ttf");
        menu.setTypeface(tf1);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RestaurantMenu.class);

                startActivity(intent);
            }
        });

      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent = new Intent(MainActivity.this, Loginc.class);

              startActivity(intent);
          }
      });



        if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {

            navigationView = (NavigationView) findViewById(R.id.nav_view);

            View headerView = navigationView.getHeaderView(0);


            navigationView.setNavigationItemSelectedListener(this);



        }
        else {

             username = ParseUser.getCurrentUser();
            if (username != null  ) {





                navigationView = (NavigationView) findViewById(R.id.nav_view);

                View headerView = navigationView.getHeaderView(0);

                logout = (ImageView) headerView.findViewById(R.id.imagelogout);
                logout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                ParseUser.logOut();
                                Intent intent = new Intent(MainActivity.this,
                                        MainActivity.class);
                                startActivity(intent);

                            }
                        }).start();
                    }
                });
                navigationView.setNavigationItemSelectedListener(this);



            } else {
                Intent intent = new Intent(MainActivity.this,
                        MainActivity.class);

                startActivity(intent);
                finish();
            }
        }



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Intent intent =new Intent(MainActivity.this,Login.class);


                    startActivity(intent);


                }
            }).start();

        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(MainActivity.this,
                    Gallery.class);
            startActivity(intent);

        }  else if (id == R.id.nav_feedback) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(MainActivity.this,
                            FeedBack.class);
                    startActivity(intent);

                }
            }).start();

        } else if (id == R.id.contact_us) {
            Intent intent =new Intent(MainActivity.this,ContactUs.class);

            startActivity(intent);

        } else if (id == R.id.nav_send) {
            Intent intent =new Intent(MainActivity.this,Email.class);

            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
