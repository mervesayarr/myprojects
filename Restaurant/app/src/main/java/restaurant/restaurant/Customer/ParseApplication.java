package restaurant.restaurant.Customer;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //  initialization code
        Parse.initialize(this, "ZI7zLUSDtknevwujpTASMCaMa9rDg6oRke8NDPHC", "k5eAxJIcoRWKQQ7nz0XDXeWkR27GE4WFdFTmfKQx");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();


        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);


    }

}