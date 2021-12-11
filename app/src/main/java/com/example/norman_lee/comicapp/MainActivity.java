package com.example.norman_lee.comicapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText editTextComicNo;
    Button buttonGetComic;
    TextView textViewTitle;
    ImageView imageViewComic;

    String comicNo;
    public static final String TAG = "Logcat";
    final String ERROR_NO_NETWORK = "No Network";
    final String ERROR_NOT_VALID = "Comic No Not Valid";
    final String ERROR_MALFORMED_URL = "Malformed URL";
    final String ERROR_BAD_JSON = "Bad JSON Response";
    final String ERROR_HTTPS_ERROR = "HTTPS Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 6.0 Study the Utils class and see what methods are available for you
        //TODO 6.1 Ensure that Android Manifest has permissions for internet and has orientation fixed
        //TODO 6.2 Get references to widgets
        //TODO 6.3 Set up setOnClickListener for the button

        //TODO 6.4 Retrieve the user input from the EditText
        //TODO 6.5 - 6.9 Modify getComic below
        //TODO 6.10 If network is active, call the getComic method with the userInput

    }


    //TODO 6.5 - 6.9 ****************
    //TODO you are reminded that new Runnable{} is an anonymous inner class
    //TODO 6.5 Make sure getComic has the signature getComic(final String userInput); make sure an executor and a handler are instantiated
    //TODO 6.6 (background work) create a final Container<Bitmap> cBitmap object which will be used for commmunication between the main thread and the child thread
    //TODO 6.7 (background work) Call Utils.getImageURLFromXkcdApi to get the image URL from comicNo
    //TODO 6.8 (background work)Call Utils.getBitmap using the URL to get the bitmap
    //TODO 6.9 (UI thread work)Assign the Bitmap downloaded to imageView. The bitmap may be null.


    void getComic(final String userInput) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Handler handler = new Handler(Looper.getMainLooper());
    }

    class Container<T> {
        T value;
        Container() {
            this.value = null;
        }
        void set(T x) { this.value = x; }
        T get() { return this.value; }
    }
}
