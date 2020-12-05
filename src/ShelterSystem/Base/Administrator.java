package ShelterSystem.Base;

/**
 * This class represent a administrator.
 */
public class Administrator extends User {
    private String id = null;      //证件号
    private int wages = 0;      //工资

    /**
     * Constructs a <code>Administrator</code> object.
     */
    public Administrator() {
        super();
    }

    /**
     * Constructs a <code>Administrator</code> object.
     *
     * @param account  Administrator's account.
     * @param password Administrator's password.
     * @param name     Administrator's name.
     * @param phone    Administrator's phone.
     * @param id       Administrator's id.
     * @param wages    Administrator's wages.
     */
    public Administrator(String account, String password, String name, String phone, String id, int wages) {
        super(account, password, name, phone);
        this.id = id;
        this.wages = wages;
    }

    /**
     * Get the id of a Administrator object
     *
     * @return the id of a Administrator
     */
    public String getId() {
        return id;
    }

    /**
     * Get the id wages a Administrator object
     *
     * @return the wages of a Administrator
     */
    public int getWages() {
        return wages;
    }

    /**
     * Set the id for a Administrator object
     *
     * @param id the id set by the Administrator
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the wages for a Administrator object
     *
     * @param wages the wages set by the Administrator
     */
    public void setWages(int wages) {
        this.wages = wages;
    }

    /**
     * get a easy save way to save the date
     *
     * @return a String object easy to save
     */
    public String importDate() {
        return "Administrator" + '_' +
                account + '_' +
                password + '_' +
                name + '_' +
                phone + '_' +
                id + '_' +
                wages;
    }

    @Override
    public String toString() {
        return "Administrator" + '_' +
                account + '_' +
                name + '_' +
                phone + '_' +
                id + '_' +
                wages;
    }
}