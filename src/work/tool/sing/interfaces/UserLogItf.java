package work.tool.sing.interfaces;

import work.tool.sing.property.UserProperty;

import java.util.ArrayList;

public interface UserLogItf {

    boolean login();

    boolean singUp();

    boolean update();

    ArrayList<UserProperty> findNeed(int topLevel);
}
