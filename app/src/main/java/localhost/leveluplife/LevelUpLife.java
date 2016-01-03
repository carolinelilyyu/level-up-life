package localhost.leveluplife;

import android.app.Application;

import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 * Created by Rom on 10/24/2015.
 */
public class LevelUpLife extends Application {

        private OAuthService service;
        private Token request;
        int money;

        public OAuthService getService() {
            return service;
        }

        public void setSomeVariable(OAuthService someService) {
            this.service = someService;
        }

    public Token getRequest() {
        return request;
    }

    public void setRequest(Token someRequest) {
        this.request = someRequest;
    }
    public void setMoney(int m){money=m;}
    public int getMoney(){return money;}

}
