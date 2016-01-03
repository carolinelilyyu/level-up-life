package localhost.leveluplife;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;


public class MyActivity extends Activity {
    private String info;
    private String mess2;
    public final static String EXTRA_MESSAGE = "com.localhost.leveluplife.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        mess2= editText.getText().toString();

        Context context = this;
       // SharedPreferences sharedPref = context.getSharedPreferences(
        //        getString(R.string.sheep), Context.MODE_PRIVATE);
       //SharedPreferences.Editor editor = sharedPref.edit();
      // editor.putInt(getString(R.string.sheep), 0);
      //  editor.commit();
        SharedPreferences mon=context.getSharedPreferences("Money",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mon.edit();
        int shep=mon.getInt("Money", 0);

        if(shep<=0)
        {
            editor.putInt("Money", 500);
            editor.commit();

        }





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        /*
        Intent intent = new Intent(this, Download.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent); */
        String stringUrl = "hello";
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();

            EditText editText = (EditText) findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            System.out.println("this is mess " + message);

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    Intent intent = new Intent(this, DisplayMessageActivity.class);

                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);

                    //new Download().execute(stringUrl);
                } else {
                    System.out.println("No network connection available.");
                }





    }

    public void goF(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        Intent intent = new Intent(this, SuccessTransfer.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }



}
