package ShelterSystem.Base;

/**
 * This class represent a employee.
 */
public class Employee extends User {
    private String id;      //证件号
    private String address; //家庭住址
    private int wages;      //工资

    /**
     * Constructs a <code>Employee</code> object.
     */
    public Employee() {
        super();
    }

    /**
     * Constructs a <code>Employee</code> object.
     *
     * @param account  employee's account.
     * @param password employee's password.
     * @param name     employee's name.
     * @param phone    employee's phone.
     * @param id       employee's id.
     * @param address  employee's address.
     * @param wages    employee's wages.
     */
    public Employee(String account, String password, String name, String phone, String id, String address, int wages) {
        super(account, password, name, phone);
        this.id = id;
        this.address = address;
        this.wages = wages;
    }

    /**
     * Get the id of a employee object
     *
     * @return the id of a employee
     */
    public String getId() {
        return id;
    }

    /**
     * Get the address of a employee object
     *
     * @return the address of a employee
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the id wages a employee object
     *
     * @return the wages of a employee
     */
    public int getWages() {
        return wages;
    }

    /**
     * Set the id for a employee object
     *
     * @param id the id set by the employee
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the address for a employee object
     *
     * @param address the address set by the employee
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set the wages for a employee object
     *
     * @param wages the wages set by the employee
     */
    public void setWages(int wages) {
        this.wages = wages;
    }

    public String importDate() {
        return "Employee" + '_' +
                account + '_' +
                password + '_' +
                name + '_' +
                phone + '_' +
                id + '_' +
                address + '_' +
                wages;
    }

    @Override
    public String toString() {
        return "Employee" + '_' +
                account + '_' +
                name + '_' +
                phone + '_' +
                id + '_' +
                address + '_' +
                wages;
    }
}