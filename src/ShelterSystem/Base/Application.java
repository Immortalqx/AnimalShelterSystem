package ShelterSystem.Base;

import java.util.Objects;

/**
 * This class represent a basic Application.
 */
public class Application {
    protected String code;    //编码
    protected String date;    //申请日期
    protected Animal animal;  //涉及到的动物信息

    /**
     * Constructs a <code>Application</code> object.
     */
    public Application() {

    }

    /**
     * Constructs a <code>Application</code> object.
     *
     * @param code   Application's code
     * @param date   Application's date
     * @param animal Application's animal
     */
    public Application(String code, String date, Animal animal) {
        this.code = code;
        this.date = date;
        this.animal = animal;
    }

    /**
     * get Application's code
     *
     * @return Application's code
     */
    public String getCode() {
        return code;
    }

    /**
     * set Application's code
     *
     * @param code Application's code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * get Application's date
     *
     * @return Application's date
     */
    public String getDate() {
        return date;
    }

    /**
     * set Application's date
     *
     * @param date Application's date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * get Application's animal
     *
     * @return Application's animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * set Application's animal
     *
     * @param animal Application's animal
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return getCode().equals(that.getCode()) &&
                getDate().equals(that.getDate()) &&
                getAnimal().equals(that.getAnimal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getDate(), getAnimal());
    }
}
