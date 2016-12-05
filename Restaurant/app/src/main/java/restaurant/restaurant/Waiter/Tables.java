package restaurant.restaurant.Waiter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import restaurant.restaurant.Customer.Price;
import restaurant.restaurant.R;

public class Tables extends AppCompatActivity {
    Spinner spinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.textView);



        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Tables, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] table = getResources().getStringArray(R.array.Tables);
                String tablename = table[position];
                if (!table[position].equals("Tables")) {
                    Intent intent = new Intent(Tables.this, Price.class);


                    intent.putExtra("table", tablename);
                    intent.putExtra("waiter", "waiter");


                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        }

    }
