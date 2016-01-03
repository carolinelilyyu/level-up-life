package localhost.leveluplife;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


import org.json.JSONObject;
import org.scribe.model.Response;

import java.util.ArrayList;
import java.util.logging.Level;

/**
 * Created by Caroline Yu on 10/24/2015.
 */
public class ActivityLog extends Activity {
    private int steps;
    private int floors;
    private int caloriesOut;
    private int min;
    private Response r;
    private Context context;
    public void onCreate() {
        System.out.println("TESTING. THIS BETTER WORK");
        Context context = this;
    }
    public void parse(Response response){
        try {
            System.out.println("TESTING. THIS BETTER WORK");

            //Log.i(MainActivity.class.getName(), jsonObject.getString("date"));
            JSONObject jsonObject = new JSONObject(response.getBody());

            //steps
            //JSONObject steps = new JSONObject("steps");
            steps = jsonObject.getJSONObject("summary").getInt("steps");
            System.out.println("step is: " + steps);

            SharedPreferences mon=context.getSharedPreferences("Steps",Context.MODE_PRIVATE);
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

    }




}

