package restaurant.restaurant.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import restaurant.restaurant.R;


public class Loginc extends AppCompatActivity {

    String usernametxt;
    String passwordtxt;
    EditText username;
    EditText password;
    Button login;
    TextView link_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginc);

        username = (EditText) findViewById(R.id.editTextusername);
        password = (EditText) findViewById(R.id.editTextpassword);
        login = (Button) findViewById(R.id.btnLogin);
        link_signup = (TextView) findViewById(R.id.link_signup);







        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        usernametxt = username.getText().toString();
                        passwordtxt = password.getText().toString();

                        ParseUser.logInInBackground(usernametxt, passwordtxt,
                                new LogInCallback() {
                                    @Override
                                    public void done(ParseUser user, ParseException e) {
                                        if (user != null ) {

                                            if( user.getString("Type").toString().equals("waiter")){



                                                Toast.makeText(getApplicationContext(),
                                                        "Please enter valid user !!",
                                                        Toast.LENGTH_LONG).show();

                                            }
                                            else if (user.getString("Type").toString().equals("customer")){
                                                Intent intent = new Intent(Loginc.this, RestaurantMenu.class);
                                                intent.putExtra("person","customer");
                                                intent.putExtra("cname",user.get("username").toString());
                                                startActivity(intent);
                                                Toast.makeText(getApplicationContext(),
                                                        "Successfully Logged in",
                                                        Toast.LENGTH_LONG).show();
                                            }
                                        } else {
                                            Toast.makeText(
                                                    getApplicationContext(),
                                                    "No such user exist, please signup",
                                                    Toast.LENGTH_LONG).show();
                                        }

                                    }
                                });
                    }
                }).start();



            }
        });


        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loginc.this, Signup.class);
                startActivity(intent);
            }
        });
    }



}
