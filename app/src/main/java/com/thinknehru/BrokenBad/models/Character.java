
package com.thinknehru.BrokenBad.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class Character implements Serializable
{

    @SerializedName("char_id")
    @Expose
    private Integer charId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("occupation")
    @Expose
    private List<String> occupation = null;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("appearance")
    @Expose
    private List<Integer> appearance = null;
    @SerializedName("portrayed")
    @Expose
    private String portrayed;
    @SerializedName("category")
    @Expose
    private String category;
//    @SerializedName("better_call_saul_appearance")
//    @Expose
//    private List<Object> betterCallSaulAppearance = null;
    private final static long serialVersionUID = 3418774020772032484L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Character() {
    }

    /**
     * 
     * @param birthday
     * @param img
     * @param occupation
     * @param appearance
     * @param betterCallSaulAppearance
     * @param charId
     * @param portrayed
     * @param name
     * @param nickname
     * @param category
     * @param status
     */
    public Character(Integer charId, String name, String birthday, List<String> occupation, String img, String status, String nickname, List<Integer> appearance, String portrayed, String category, List<Object> betterCallSaulAppearance) {
        super();
        this.charId = charId;
        this.name = name;
        this.birthday = birthday;
        this.occupation = occupation;
        this.img = img;
        this.status = status;
        this.nickname = nickname;
        this.appearance = appearance;
        this.portrayed = portrayed;
        this.category = category;
//        this.betterCallSaulAppearance = betterCallSaulAppearance;
    }

    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Integer> getAppearance() {
        return appearance;
    }

    public void setAppearance(List<Integer> appearance) {
        this.appearance = appearance;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public List<Object> getBetterCallSaulAppearance() {
//        return betterCallSaulAppearance;
//    }
//
//    public void setBetterCallSaulAppearance(List<Object> betterCallSaulAppearance) {
//        this.betterCallSaulAppearance = betterCallSaulAppearance;
//    }

    @Override
    public String toString(){
        return String.format("%s, %s, %s", this.birthday, this.portrayed, this.occupation);
    }
}
