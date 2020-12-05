package ShelterSystem.Base;

/**
 * This class represent a customer.
 */
public class Customer extends User {
    private ApplicationItem applicationItem;    //用户的领养或者寄送申请

    /**
     * Constructs a <code>Customer</code> object.
     */
    public Customer() {
        super();
    }

    /**
     * Constructs a <code>Customer</code> object.
     *
     * @param account  customer's account .
     * @param password customer's password.
     * @param name     customer's name.
     * @param phone    customer's phone.
     */
    public Customer(String account, String password, String name, String phone) {
        super(account, password, name, phone);
    }

    /**
     * Constructs a <code>Customer</code> object.
     *
     * @param account  customer's account .
     * @param password customer's password.
     * @param name     customer's name.
     * @param phone    customer's phone.
     */
    public Customer(String account, String password, String name, String phone, ApplicationItem applicationItem) {
        super(account, password, name, phone);
        this.applicationItem = applicationItem;
    }

    /**
     * Get the animal the customer want in the animal shelter
     *
     * @return the animal that the customer want
     */
    public ApplicationItem getApplicationItem() {
        return applicationItem;
    }

    /**
     * Set the animal the customer want in the animal shelter
     *
     * @param applicationItem the animal the customer want
     */
    public void setApplicationItem(ApplicationItem applicationItem) {
        this.applicationItem = applicationItem;
    }

    public String importDate() {
        if (applicationItem != null)
            return "Customer" + '_' +
                    account + '_' +
                    password + '_' +
                    name + '_' +
                    phone + '_' +
                    applicationItem.getApplication().getCode();
        else
            return "Customer" + '_' +
                    account + '_' +
                    password + '_' +
                    name + '_' +
                    phone + '_' +
                    "null";
    }

    @Override
    public String toString() {
        if (applicationItem != null)
            return "Customer" + '_' +
                    account + '_' +
                    name + '_' +
                    phone + '_' +
                    applicationItem.getApplication().getCode();
        else
            return "Customer" + '_' +
                    account + '_' +
                    name + '_' +
                    phone + '_' +
                    "null";
    }
}
