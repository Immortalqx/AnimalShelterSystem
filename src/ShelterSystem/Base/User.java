package ShelterSystem.Base;

import java.util.Objects;

/**
 * This class represent a basic user.
 */
public class User {
    protected String account = null;     //账号
    protected String password = null;    //密码
    protected String name = null;        //姓名
    protected String phone = null;         //电话

    /**
     * Constructs a <code>User</code> object.
     */
    public User() {
    }

    /**
     * Constructs a <code>User</code> object.
     *
     * @param account  user's account .
     * @param password user's password.
     * @param name     user's name.
     * @param phone    user's phone.
     */
    public User(String account, String password, String name, String phone) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    /**
     * Get the account of a User object
     *
     * @return the account of a User
     */
    public String getAccount() {
        return account;
    }

    /**
     * Get the password of a User object
     *
     * @return the password of a User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the name of a User object
     *
     * @return the name of a User
     */
    public String getName() {
        return name;
    }

    /**
     * Get the phone of a User object
     *
     * @return the phone of a User
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the account for a User object
     *
     * @param account the account set by the user
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Set the password for a User object
     *
     * @param password the account set by the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the name for a User object
     *
     * @param name the account set by the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the phone for a User object
     *
     * @param phone the account set by the user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String importDate() {
        return "User" + '_' +
                account + '_' +
                password + '_' +
                name + '_' +
                phone;
    }

    @Override
    public String toString() {
        return "User" + '_' +
                account + '_' +
                name + '_' +
                phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getPhone() == user.getPhone() &&
                getAccount().equals(user.getAccount()) &&
                getPassword().equals(user.getPassword()) &&
                getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccount(), getPassword(), getName(), getPhone());
    }
}
