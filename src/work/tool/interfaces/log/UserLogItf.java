package work.tool.interfaces.log;

import work.tool.property.log.UserProperty;

import java.util.ArrayList;

public interface UserLogItf {

    boolean login();

    boolean singUp();

    boolean update();

    ArrayList<UserProperty> findNeed(int topLevel);
}
