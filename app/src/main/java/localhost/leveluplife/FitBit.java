package localhost.leveluplife;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

/**
 * Created by Rom on 10/24/2015.
 */
public class FitBit extends DefaultApi10a {
    private static final String AUTHORIZE_URL = "https://www.fitbit.com/oauth/authorize?oauth_token=%s";

    public String getAccessTokenEndpoint(){
        return "https://api.fitbit.com/oauth/access_token";
    }
    public String getRequestTokenEndpoint(){
        return "https://api.fitbit.com/oauth/request_token";
    }
    public String getAuthorizationUrl(Token requestToken){
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }
}
