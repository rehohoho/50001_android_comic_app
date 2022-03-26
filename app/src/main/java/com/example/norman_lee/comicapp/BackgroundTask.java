package com.example.norman_lee.comicapp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class BackgroundTask<I,O> {
    abstract public O task(I input) throws JSONException, IOException;

    abstract public void done(O result);

    public void start(final I userInput) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //Background work here
                final Container<O> c = new Container<O>();
                O o = null;
                try {
                    o = task(userInput);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                c.set(o);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //UI Thread work here
                        if (c.get() != null) {
                            done(c.get());
                        }
                    }
                });
            }
        });
    }
}

class UpdateComicSubroutine extends BackgroundTask<String, Pair<Bitmap, String>> {

    ImageView imageViewComic;
    TextView textViewTitle;

    UpdateComicSubroutine(ImageView imageViewComic, TextView textViewTitle) {
        this.imageViewComic = imageViewComic;
        this.textViewTitle = textViewTitle;
    }

    @Override
    public Pair<Bitmap, String> task(String input) throws JSONException, IOException {
        final Pair<String, String> res = Utils.getImageURLFromXkcdApi(input);
        return new Pair(
            Utils.getBitmap(new URL(res.first)),
            res.second
        );
    }

    @Override
    public void done(Pair<Bitmap, String> result) {
        imageViewComic.setImageBitmap(result.first);
        textViewTitle.setText(result.second);
    }
}
