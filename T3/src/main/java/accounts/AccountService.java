package accounts;

import dbService.DBException;
import dbService.DBService;

import java.util.HashMap;
import java.util.Map;


public class AccountService {
    private final DBService loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;

    public AccountService(DBService dbService) {
        //loginToProfile = new HashMap<>();
        this.loginToProfile = dbService;
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) {
        try {
            loginToProfile.addUser(userProfile);
        }
        catch (DBException ex){
        }

                //put();
    }

    public UserProfile getUserByLogin(String login) {
        try{
        return loginToProfile.getUser(login);
        }
        catch(DBException ex){
            return null;
        }
                //.get(login);
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
