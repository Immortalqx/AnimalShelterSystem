package ShelterSystem.Base;

import java.util.Objects;

/**
 * This class represent a Animal.
 */
public class Animal {
    private String typename;    //动物的种类
    private String nickname;    //动物的名字或者昵称
    private String code;        //动物的编码
    private int date;           //收养的日期
    private String describe;    //更加具体的描述

    /**
     * make a Animal.
     */
    public Animal() {

    }

    /**
     * make a Animal.
     *
     * @param code     animal's code.
     * @param typename animal's typename.
     * @param nickname animal's nickname.
     * @param date     animal's date.
     * @param describe animal's describe.
     */
    public Animal(String code, String typename, String nickname, int date, String describe) {
        this.typename = typename;
        this.nickname = nickname;
        this.code = code;
        this.date = date;
        this.describe = describe;
    }

    /**
     * get animal's typename.
     *
     * @return animal's typename.
     */
    public String getTypename() {
        return typename;
    }

    /**
     * set animal's typename.
     *
     * @param typename animal's typename.
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * get animal's nickname.
     *
     * @return animal's nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * set animal's nickname.
     *
     * @param nickname animal's nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * get animal's code.
     *
     * @return animal's code.
     */
    public String getCode() {
        return code;
    }

    /**
     * set animal's code.
     *
     * @param code animal's code.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * set animal's date.
     *
     * @return animal's date.
     */
    public int getDate() {
        return date;
    }

    /**
     * set animal's date.
     *
     * @param date animal's date.
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * get animal's describe.
     *
     * @return animal's describe.
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * set animal's describe.
     *
     * @param describe animal's describe.
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Animal" + '_' +
                code + '_' +
                typename + '_' +
                nickname + '_' +
                date + '_' +
                describe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return getDate() == animal.getDate() &&
                getTypename().equals(animal.getTypename()) &&
                getNickname().equals(animal.getNickname()) &&
                getCode().equals(animal.getCode()) &&
                getDescribe().equals(animal.getDescribe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypename(), getNickname(), getCode(), getDate(), getDescribe());
    }
}
