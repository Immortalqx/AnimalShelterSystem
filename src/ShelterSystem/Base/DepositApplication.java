package ShelterSystem.Base;

/**
 * This class represent a DepositApplication.
 */
public class DepositApplication extends Application {
    private String describe;    //寄送动物的说明

    /**
     * Constructs a <code>DepositApplication</code> object.
     */
    public DepositApplication() {

    }

    /**
     * Constructs a <code>DepositApplication</code> object.
     *
     * @param code     DepositApplication's code
     * @param date     DepositApplication's date
     * @param animal   DepositApplication's animal
     * @param describe DepositApplication's describe
     */
    public DepositApplication(String code, String date, Animal animal, String describe) {
        super(code, date, animal);
        this.describe = describe;
    }

    /**
     * get describe
     *
     * @return describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * set describe
     *
     * @param describe the describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "DepositApplication" + '_' +
                code + '_' +
                date + '_' +
                animal + '_' +
                describe;
    }
}
