package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

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

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
        
        if (!password.equals(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }
        
        String testUser = "abcdefghijklmnopqrstuvwxyz";
        
        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }
        
        for (int i = 0; i < username.length(); i++) {
            if (!testUser.contains(username.substring(i, i + 1))) {
                status.addError("use only a-z in username");
            }
        }
        boolean legit = false;
        for (int i = 0; i < password.length(); i++) {
            
            if (password.substring(i, i + 1).hashCode() >= 123 || password.substring(i, i + 1).hashCode() < 65
                    || (password.substring(i, i + 1).hashCode() > 90 && password.substring(i, i + 1).hashCode() < 97)) {
                legit = true;
            }
        }

        if (!legit) {
            status.addError("Password should have at least one number or special character");
        }

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }

}
