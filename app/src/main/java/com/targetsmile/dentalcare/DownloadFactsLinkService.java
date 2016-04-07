package com.targetsmile.dentalcare;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class DownloadFactsLinkService extends Service {


    SharedPreferences prefs;


    public DownloadFactsLinkService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return null;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        prefs = this.getSharedPreferences("com.targetsmile.dentalcare", Context.MODE_PRIVATE);

        DownloadLinkTextFile task = new DownloadLinkTextFile();
        task.execute("https://dl.dropboxusercontent.com/u/7920261/dentalfactlinks.txt");

        return Service.START_FLAG_REDELIVERY;
    }


    public class DownloadLinkTextFile extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection  = null;

            try {
                url = new URL(urls[0]);

                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream in = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(in);

                int data = inputStreamReader.read();

                while(data != -1)
                {
                    char current = (char) data;

                    result += current;
                    data = inputStreamReader.read();


                }

                return result;

            } catch (MalformedURLException e) {
                // e.printStackTrace();
                prefs.edit().putStringSet("linksToDentalFacts", Data.fetchData()).apply();

            } catch (IOException e) {
                // e.printStackTrace();
                prefs.edit().putStringSet("linksToDentalFacts", Data.fetchData()).apply();
            } catch (Exception e)
            {
                prefs.edit().putStringSet("linksToDentalFacts", Data.fetchData()).apply();
            }




            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                super.onPostExecute(result);

                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String dentalFactsData = jsonObject.getString("dentalFactsData");

                    //        Log.i("Info fetched", dentalFactsData);

                    Set<String> linkSet = new HashSet<String>();

                    JSONArray jsonArray = new JSONArray(dentalFactsData);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonPart = jsonArray.getJSONObject(i);
                        String tempLink = jsonPart.getString("link");


                        linkSet.add(tempLink);

                        // String tempExplanation = jsonPart.getString("explanation");
                        // Log.i("Links -> ", tempLink + " Explanation " + tempExplanation);

                    }


                    prefs.edit().putStringSet("linksToDentalFacts", linkSet).apply();

                    Log.i("Message", "Set the links in shared preferences....done");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            else
            {
                prefs.edit().putStringSet("linksToDentalFacts", Data.fetchData()).apply();
            }

        }

    }
}
