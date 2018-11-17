package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;
    
    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        String testUser = "abcdefghijklmnopqrstuvwxyz";
        if (username.length() < 3) {
            return true;
        }
        
        if (password.length() < 8) {
            return true;
        }
        
        for (int i = 0; i < username.length(); i++) {
            if (!testUser.contains(username.substring(i, i + 1))) {
                return true;
            }
        }
        
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i, i + 1).hashCode() >= 123 || password.substring(i, i + 1).hashCode() < 65
                    || (password.substring(i, i + 1).hashCode() > 90 && password.substring(i, i + 1).hashCode() < 97)) {
                return false;
            }
        }

        return true;
    }
}
