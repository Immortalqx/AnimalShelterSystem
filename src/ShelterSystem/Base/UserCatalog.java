package ShelterSystem.Base;

import java.util.ArrayList;
import java.util.Iterator;

public class UserCatalog implements Iterable<User> {
    private final ArrayList<User> users = new ArrayList<User>();

    /**
     * Add a user in this userCatalog.
     *
     * @param user User arguments. The user you want to add in this userCatalog.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Remove a user in this userCatalog.
     *
     * @param user User arguments. The user you want to Remove in this userCatalog.
     */
    public void removeUser(User user) {
        users.remove(user);
    }

    /**
     * get the user you want in this userCatalog.
     *
     * @param index int arguments. The index of the user you want to get in this userCatalog.
     * @return the user find by the index.
     */
    public User getUser(int index) {
        return users.get(index);
    }

    /**
     * get the user you want in this userCatalog.
     *
     * @param account String arguments. The account of the user you want to get in this userCatalog.
     * @return the user find by the id.
     */
    public User getUser(String account) {
        for (User user : users) {
            if (user.getAccount().equals(account))
                return user;
        }
        return null;
    }

    /**
     * get the number of the users you want in this userCatalog.
     *
     * @return the number of users.
     */
    public int getNumberOfUsers() {
        return users.size();
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}
