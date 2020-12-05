package ShelterSystem.Base;

/**
 * This class represent a AdoptApplication.
 */
public class AdoptApplication extends Application {
    private int cost;       //为收养的动物支出的开销
    private String time;    //期望收养动物的时间
    private boolean adjust; //是否接受调剂

    /**
     * represent a AdoptApplication.
     */
    public AdoptApplication() {
        super();
    }

    /**
     * represent a AdoptApplication.
     *
     * @param code   AdoptApplication's code .
     * @param date   AdoptApplication's date .
     * @param animal AdoptApplication's animal .
     * @param cost   AdoptApplication's cost .
     * @param time   AdoptApplication's time .
     * @param adjust AdoptApplication's adjust .
     */
    public AdoptApplication(String code, String date, Animal animal, int cost, String time, boolean adjust) {
        super(code, date, animal);
        this.cost = cost;
        this.time = time;
        this.adjust = adjust;
    }

    /**
     * get the cost
     *
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * set cost
     *
     * @param cost the cost want to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * get the time
     *
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * set time
     *
     * @param time the time want to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * is the application want to adjust request?
     *
     * @return yes or no
     */
    public boolean isAdjust() {
        return adjust;
    }

    /**
     * change  the application to adjust request
     */
    public void setAdjust(boolean adjust) {
        this.adjust = adjust;
    }

    @Override
    public String toString() {
        return "AdoptApplication" + '_' +
                code + '_' +
                date + '_' +
                animal + '_' +
                cost + '_' +
                time + '_' +
                adjust;
    }
}
