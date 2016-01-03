package localhost.leveluplife;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.io.PrintWriter;


public class SuccessTransfer extends ActionBarActivity {
    private Token requestToken;
    private Verifier v;
    private OAuthService service;
    private ActivityLog activityLog;
    private Response response;
    private int steps;
    private int floors;
    private int caloriesOut;
    private int min;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.datastuff);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        context=this;
        //TextView textView = new TextView(this);
        //textView.setTextSize(40);
       // textView.setText(message);
       // setContentView(textView);
        setContentView(R.layout.activity_success_transfer);
        service=((LevelUpLife) this.getApplication()).getService();
        requestToken = ((LevelUpLife) this.getApplication()).getRequest();
        v = new Verifier(message);
        activityLog = new ActivityLog();
        new Stream().execute("hello");


        /*
       OAuthRequest request = new OAuthRequest(Verb.POST, "https://www.fitbit.com/");
       service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println(response.getBody());*/
    }


  //  @Override
    /*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_success_transfer, menu);
        return true;
    }*/

    public void market(View view)
    {
        Intent intent = new Intent(this, Market.class);


        startActivity(intent);
    }

    public void collection(View view)
    {
        Intent intent = new Intent(this, Collection.class);


        startActivity(intent);
    }

    public void tasks(View view)
    {
        Intent intent = new Intent(this, Tasks.class);


        startActivity(intent);
    }
   // @Override
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

    public void noMouse(){
        System.out.println("hello");
    }


    private class Stream extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            Token  accessToken = service.getAccessToken(requestToken, v);
            System.out.println("noodles");

            OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.fitbit.com/1/user/-/activities/date/2015-10-23.json");
            service.signRequest(accessToken, request);
            response = request.send();
            //System.out.println(response.getBody());
            // setResponse(response);
           // activityLog.parse(response);
            try {
                System.out.println("TESTING. THIS FUCKING BETTER WORK");

                //Log.i(MainActivity.class.getName(), jsonObject.getString("date"));
                JSONObject jsonObject = new JSONObject(response.getBody());

                //steps
                //JSONObject steps = new JSONObject("steps");
                steps = jsonObject.getJSONObject("summary").getInt("steps");
                System.out.println("step is: " + steps);

                SharedPreferences mon=context.getSharedPreferences("Steps", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=mon.edit();
                editor.putInt("Steps", steps);
                editor.commit();
                // ((LevelUpLife) this.getApplication()).setSteps(steps);

                //caloriesOut
                caloriesOut = jsonObject.getJSONObject("summary").getInt("activityCalories");
                //  setCaloriesOut(caloriesOut);
                System.out.println("cal " + caloriesOut);
                mon=context.getSharedPreferences("Calories",Context.MODE_PRIVATE);
                editor=mon.edit();
                editor.putInt("Calories", caloriesOut);
                editor.commit();

                //floors
                //JSONObject floors = new JSONObject("floors");
                floors = jsonObject.getJSONObject("summary").getInt("floors");
                // setFloors(floors);
                System.out.println("floor " + floors);
                //  mon=context.getSharedPreferences("Floors",Context.MODE_PRIVATE);
                editor=mon.edit();
                editor.putInt("Floors", floors);
                editor.commit();

                min=jsonObject.getJSONObject("summary").getInt("fairlyActiveMinutes") + jsonObject.getJSONObject("summary").getInt("veryActiveMinutes") + jsonObject.getJSONObject("summary").getInt("lightlyActiveMinutes");
                System.out.println("Minutes " + min);
                mon=context.getSharedPreferences("Min",Context.MODE_PRIVATE);
                editor=mon.edit();
                editor.putInt("Min", min);
                editor.commit();
                int s=mon.getInt("Min", -1);
                System.out.println("this went fine"+ min + " " + s);

            } catch (Exception e) {
                e.printStackTrace();
            }



        return "hello";
        }

    }

}
