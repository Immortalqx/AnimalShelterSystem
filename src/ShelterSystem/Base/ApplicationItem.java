package ShelterSystem.Base;

/**
 * This class represent a ApplicationItem.
 */
public class ApplicationItem {
    private Application application;
    private boolean isPassed = false;   //申请是否通过

    /**
     * Constructs a <code>ApplicationItem</code> object.
     *
     * @param application ApplicationItem's Application
     * @param isPassed    ApplicationItem's passCondition
     */
    public ApplicationItem(Application application, boolean isPassed) {
        this.application = application;
        this.isPassed = isPassed;
    }

    /**
     * Constructs a <code>ApplicationItem</code> object.
     *
     * @param application ApplicationItem's Application
     */
    public ApplicationItem(Application application) {
        this.application = application;
    }

    /**
     * get ApplicationItem' application
     *
     * @return application
     */
    public Application getApplication() {
        return application;
    }

    /**
     * get ApplicationItem' passCondition
     *
     * @return isPassed
     */
    public boolean isPassed() {
        return isPassed;
    }

    /**
     * change ApplicationItem' passCondition
     *
     * @param passed passCondition
     */
    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    @Override
    public String toString() {
        return "ApplicationItem" + '_' +
                application + '_' +
                isPassed;
    }
}
