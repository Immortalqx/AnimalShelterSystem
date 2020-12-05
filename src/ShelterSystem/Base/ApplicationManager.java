package ShelterSystem.Base;

import java.util.ArrayList;
import java.util.Iterator;

public class ApplicationManager implements Iterable<ApplicationItem> {
    private final ArrayList<ApplicationItem> applicationItems = new ArrayList<ApplicationItem>();

    /**
     * Add a applicationItem in this applicationItemCatalog.
     *
     * @param applicationItem ApplicationItem arguments. The applicationItem you want to add in this applicationItemCatalog.
     */
    public void addApplicationItem(ApplicationItem applicationItem) {
        applicationItems.add(applicationItem);
    }

    /**
     * Remove a applicationItem in this applicationItemCatalog.
     *
     * @param applicationItem ApplicationItem arguments. The applicationItem you want to Remove in this applicationItemCatalog.
     */
    public void removeApplicationItem(ApplicationItem applicationItem) {
        applicationItems.remove(applicationItem);
    }

    /**
     * get the applicationItem you want in this applicationItemCatalog.
     *
     * @param index int arguments. The index of the applicationItem you want to get in this applicationItemCatalog.
     * @return the applicationItem find by the index.
     */
    public ApplicationItem getApplicationItem(int index) {
        return applicationItems.get(index);
    }

    /**
     * get the applicationItem you want in this applicationItemCatalog.
     *
     * @param code String arguments. The id of the applicationItem you want to get in this applicationItemCatalog.
     * @return the applicationItem find by the id.
     */
    public ApplicationItem getApplicationItem(String code) {
        for (ApplicationItem applicationItem : applicationItems) {
            if (applicationItem.getApplication().getCode().equals(code))
                return applicationItem;
        }
        return null;
    }

    /**
     * get the number of the applicationItems you want in this applicationItemCatalog.
     *
     * @return the number of applicationItems.
     */
    public int getNumberOfApplicationItems() {
        return applicationItems.size();
    }

    @Override
    public Iterator<ApplicationItem> iterator() {
        return applicationItems.iterator();
    }
}
