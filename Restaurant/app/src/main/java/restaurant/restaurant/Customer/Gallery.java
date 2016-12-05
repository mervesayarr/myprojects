package restaurant.restaurant.Customer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import restaurant.restaurant.R;

public class Gallery extends AppCompatActivity implements View.OnClickListener {
    ImageView image ;
    Button next;
    RelativeLayout relativeLayout;
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        relativeLayout = (RelativeLayout)findViewById(R.id.relative);
        relativeLayout.setBackgroundResource(R.mipmap.view);

        image= (ImageView) findViewById(R.id.imageView4);

            Button restart = (Button) findViewById(R.id.restart);
            restart.setOnClickListener(this);


            next = (Button) findViewById(R.id.next);
            next.setOnClickListener(this);

        }


        @Override
        public void onClick(View view)
        {

            switch (view.getId())
            {
                case R.id.restart:
                    relativeLayout.setBackgroundResource(R.mipmap.view);
                    a = 0;
                    break;

                case R.id.next:
                    if (a == 0)
                    {
                        relativeLayout.setBackgroundResource(R.mipmap.entrance);
                        a = 1;
                    }
                    else if (a == 1)
                    {
                        relativeLayout.setBackgroundResource(R.mipmap.food);
                        a = 2;
                    }
                    else if (a == 2)
                    {
                        relativeLayout.setBackgroundResource(R.mipmap.kitchen);
                        a = 3;
                    }
                    else if (a == 3)
                    {

                        relativeLayout.setBackgroundResource(R.mipmap.food2);
                        a = 4;
                    }

                    break;

            }


        }

}
