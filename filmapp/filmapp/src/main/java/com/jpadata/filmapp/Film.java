package com.jpadata.filmapp;

import javax.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id", nullable = false)
    private Integer f_id;
    @Column(name = "f_Name")
    private String F_Name;
    @Column(name = "F_Year")
    private Integer F_Year;
    @Column(name = "F_Yonetmen")
    private String F_Yonetmen;

    public Film(String f_Name, int f_Year, String f_Yonetmen) {
        F_Name = f_Name;
        F_Year = f_Year;
        F_Yonetmen = f_Yonetmen;
    }

    public Film(){

    }
    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public int getF_Year() {
        return F_Year;
    }

    public void setF_Year(int f_Year) {
        F_Year = f_Year;
    }

    public String getF_Yonetmen() {
        return F_Yonetmen;
    }

    public void setF_Yonetmen(String f_Yonetmen) {
        F_Yonetmen = f_Yonetmen;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "f_id=" + f_id +
                ", F_Name='" + F_Name + '\'' +
                ", F_Year=" + F_Year +
                ", F_Yonetmen='" + F_Yonetmen + '\'' +
                '}';
    }
}
