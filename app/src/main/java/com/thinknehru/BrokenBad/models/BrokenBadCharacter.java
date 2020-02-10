
package com.thinknehru.BrokenBad.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrokenBadCharacter implements Serializable
{

    @SerializedName("characters")
    @Expose
    private List<Character> characters = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    private final static long serialVersionUID = 7911131314065377450L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BrokenBadCharacter() {
    }

    /**
     * 
     * @param characters
     * @param total
     */
    public BrokenBadCharacter(List<Character> characters, Integer total) {
        super();
        this.characters = characters;
        this.total = total;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
