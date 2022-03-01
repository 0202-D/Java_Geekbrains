package Lesson_8.ServerSide;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * @author Dm.Petrov
 * DATE: 26.12.2021
 */
public class AuthServiceImpl implements AuthService {
    private static final Logger LOGGER = LogManager.getLogger(AuthServiceImpl.class);
    private class Entry {
        private String login;
        private String pass;
        private String nick;

        public Entry(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }

    private List<Entry> entries;

    @Override
    public void start() {
      //  System.out.println("Authentication start");
        LOGGER.info("Authentication Service started");
    }

    @Override
    public void stop() {
       // System.out.println("Authentication stop");
        LOGGER.info("Authentication Service stopped");
    }


    public AuthServiceImpl() {
        entries = new ArrayList<>();
        entries.add(new Entry("1", "pass1", "Ivan"));
        entries.add(new Entry("2", "pass2", "Maria"));
        entries.add(new Entry("3", "pass3", "Stepan"));
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        for (Entry o : entries) {
            if (o.login.equals(login) && o.pass.equals(pass)) return o.nick;
        }
        return null;
    }
}


