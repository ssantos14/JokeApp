package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.androidjokedisplay.JokeActivity;
import com.example.android.javajokegenerator.JokeGenerator;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private static final String JOKE_TAG = "joke_intent_tag";
    //String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        //new EndpointsAsyncTask().execute(getApplicationContext());
        JokeGenerator jokeGenerator = new JokeGenerator();
        String joke = jokeGenerator.getJoke();
        Intent startJokeActivityIntent = new Intent(this,JokeActivity.class);
        startJokeActivityIntent.putExtra(JOKE_TAG,joke);
        startActivity(startJokeActivityIntent);
    }

//    class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
//        private MyApi myApiService = null;
//        private Context context;
//
//        @Override
//        protected String doInBackground(Context... params) {
//            if(myApiService == null) {
//                MyApi.Builder builder = new MyApi
//                        .Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                            @Override
//                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                                abstractGoogleClientRequest.setDisableGZipContent(true);
//                            }
//                        });
//                myApiService = builder.build();
//            }
//
//            context = params[0];
//
//            try {
//                return myApiService.sayJoke().execute().getData();
//            } catch (IOException e) {
//                return e.getMessage();
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            mJoke = result;
////            if(mIdlingResource != null){
////                mIdlingResource.decrement();
////            }
//            Intent startJokeActivityIntent = new Intent(MainActivity.this,JokeActivity.class);
//            startJokeActivityIntent.putExtra(JOKE_TAG,mJoke);
//            startActivity(startJokeActivityIntent);
//        }
//    }

}
