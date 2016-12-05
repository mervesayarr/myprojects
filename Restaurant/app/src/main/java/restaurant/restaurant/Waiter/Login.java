package restaurant.restaurant.Waiter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import restaurant.restaurant.R;


public class Login extends AppCompatActivity {

    String usernametxt;
    String passwordtxt;
    EditText username;
    EditText password;
    Button login;
    String table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.editTextusername);
        password = (EditText) findViewById(R.id.editTextpassword);
        login = (Button) findViewById(R.id.btnLogin);



        Intent intent= getIntent();
        table = intent.getStringExtra("position");





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
                                            if(  user.getString("Type").toString().equals("customer")){
                                                Toast.makeText(getApplicationContext(),
                                                        "Please enter correct waiter account",
                                                        Toast.LENGTH_LONG).show();
                                            }
                                             if( user.getString("Type").toString().equals("waiter")){


                                            Intent intent = new Intent(Login.this, Waiter.class);
                                                 intent.putExtra("person", "customer");
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



    }



}
