package restaurant.restaurant.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import java.text.DateFormat;
import java.util.Date;

import restaurant.restaurant.Waiter.MainActivity;
import restaurant.restaurant.R;

public class FeedBack extends AppCompatActivity {

    ImageView btnfeedback;
    EditText edittxtfeed;
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Your opinion is very important for us..", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        date=(TextView)findViewById(R.id.textViewdate);
        btnfeedback = (ImageView) findViewById(R.id.btnfeedback);
        edittxtfeed =(EditText) findViewById(R.id.editTextfeedback);

        final String Date = DateFormat.getDateTimeInstance().format(new Date());
        date.setText(Date);

        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = edittxtfeed.getText().toString();

                ParseObject fback = new ParseObject("Feedback");
                fback.put("Feedback", feedback);
                fback.put("Date",Date);
                fback.saveInBackground();
                Toast.makeText(FeedBack.this,"Thank you for your feedback.. ",Toast.LENGTH_LONG).show();
                Intent i = new Intent(FeedBack.this,MainActivity.class);
                startActivity(i);


            }
        });
    }

}
