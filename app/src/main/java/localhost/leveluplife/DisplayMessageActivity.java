package localhost.leveluplife;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class DisplayMessageActivity extends Activity {
    private WebView webView;
    private OAuthService service;
    private Token requestToken;
    private String info;
    private String authURL;
    private Boolean connecting;
    public final static String EXTRA_SERV = "com.localhost.leveluplife.SERV";
    public final static String EXTRA_TRA =  "com.localhost.leveluplife.TRA";
    public final static String EXTRA_RES =  "com.localhost.leveluplife.RES";

    private Token accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);


        webView.setWebViewClient(new MyWebViewClient());
        /*
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        setContentView(textView);*/
        connecting=true;
        new Download().execute("hello");
        System.out.println("hiya");
        int i=0;


           // System.out.println("connect " + i );
           // i++;

        System.out.println("done");

        /*
        service = new ServiceBuilder()
                .provider(FitBit.class)
                .apiKey("3a24e448ee8e1c95651f40ea22d95208")
                .apiSecret("b5ad6f11dedded08f061b63b7450ca7f")
                .callback(getString(R.string.FitbitCallback))
                .debug()
                .build();

        requestToken = service.getRequestToken();

        final String authURL = service.getAuthorizationUrl(requestToken);
        webView.loadUrl(authURL);
        OAuthRequest request = new OAuthRequest(Verb.POST, "https://www.fitbit.com/");
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println(response.getBody());*/

    }

    public void setRequest(Token r) {
        requestToken = r;
        ((LevelUpLife) this.getApplication()).setRequest(requestToken);
    }

    public void setService(OAuthService s) {
        service = s;
        ((LevelUpLife) this.getApplication()).setSomeVariable(service);
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

    private class Download extends AsyncTask<String, Void, String> {
      //  private WebView webView;
       // private OAuthService service;
       // private Token requestToken;


       // private Token accessToken;
        protected String doInBackground(String... urls) {
            //setContentView(R.layout.webview);
            //webView = (WebView) findViewById(R.id.webView);
           // webView.getSettings().setJavaScriptEnabled(true);
            service = new ServiceBuilder()
                    .provider(FitBit.class)
                    .apiKey("3a24e448ee8e1c95651f40ea22d95208")
                    .apiSecret("b5ad6f11dedded08f061b63b7450ca7f")
                    .callback(getString(R.string.FitbitCallback))
                    .debug()
                    .build();
            setService(service);
            requestToken = service.getRequestToken();
            setRequest(requestToken);
            String athURL = service.getAuthorizationUrl(requestToken);
            System.out.println(athURL + " what is this");

          /*  HReader r=new HReader();
            String ff;
            try {
               ff= r.getText(athURL);
               System.out.println(ff);
            }catch(Exception e){
                System.out.println("error");
            }*/

            // webView.loadUrl(authURL);
            System.out.println("right before crash");
            //webView.loadUrl("http://www.google.com");
            //  OAuthRequest request = new OAuthRequest(Verb.POST, "https://www.fitbit.com/");
            //  service.signRequest(accessToken, request);
            // Response response = request.send();
            // System.out.println(response.getBody());
            return athURL;

            // params comes from the execute() call: params[0] is the url.
          /*  try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }*/
        }
        // onPostExecute displays the results of the AsyncTask.
        // @Override
        protected void onPostExecute(String result) {
            System.out.println("this works");
            authURL=result;



            webView.loadUrl(result);
           // connecting=false;
           // OAuthRequest request = new OAuthRequest(Verb.POST, "https://www.fitbit.com/");
           // service.signRequest(accessToken, request);
           // Response response = request.send();
           // System.out.println(response.getBody());
        }





    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            {
//check for our custom callback protocol
                System.out.println("itshouldntbehere");
               // if(url.startsWith(getString(R.string.FitbitCallback)))
               // {
//custom code       //user authorization is completed, and Fitbit has redirected the user to our callback URL
                System.out.println("helpme");
                    Uri uri = Uri.parse(url);
//Get the oauth verifier that Fitbit provides
                System.out.println("please");
                    String outh="oauth_token";
                System.out.println(uri.toString() + " this is what we get");
                HReader r=new HReader();


                    String verifier = uri.getQueryParameter(outh);
                System.out.println("wrong " + verifier);
                    Verifier v = new Verifier(verifier);
                System.out.println("inow");
//we have everything we need to get the access token now
                 //   accessToken = service.getAccessToken(requestToken, v);
                    System.out.println("accessreceived");
//now that we have the access token, lets hide the webview
                   // webView.setVisibility(View.GONE);
                  //  String abo="http://www.google.com";
                   // webView.loadUrl(abo);
                  //  return true;
              //  }
//otherwise use default behavior
                System.out.println("here reached");
                return super.shouldOverrideUrlLoading(view, url);
            }
        }
    }


}
