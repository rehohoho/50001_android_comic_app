package com.example.norman_lee.comicapp;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
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
        //TODO 6.5 - 6.9 Modify GetComic below
        //TODO 6.10 If network is active, instantiate GetComic and call the execute method

    }

    //TODO 6.5 - 6.9 ****************
    //TODO you are reminded that this is an inner class
    //TODO 6.5 Make GetComic extend AsyncTask<String, String, Bitmap>
    //TODO 6.6 (doInBackground)Call Utils.getImageURLFromXkcdApi to get the image URL from comicNo
    //TODO 6.7 (onProgressUpdate, doInBackground) Call publishProgress, write code to update textViewTitle with the image URL
    //TODO 6.8 (doInBackground)Call Utils.getBitmap using the URL to get the bitmap
    //TODO 6.9 (onPostExecute)Assign the Bitmap downloaded to imageView. The bitmap may be null.
    class GetComic {


    }

}
