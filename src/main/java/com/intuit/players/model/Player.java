package com.intuit.players.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @Column(name = "id", nullable = false)
    private String playerID;
    @Column(name = "birthyear")
    private Integer birthYear;
    @Column(name = "birthmonth")
    private Integer birthMonth;
    @Column(name = "birthday")
    private Integer birthDay;
    @Column(name = "birthcountry")
    private String birthCountry;
    @Column(name = "birthstate")
    private String birthState;
    @Column(name = "birthcity")
    private String birthCity;
    @Column(name = "deathyear")
    private Integer deathYear;
    @Column(name = "deathmonth")
    private Integer deathMonth;
    @Column(name = "deathday")
    private Integer deathDay;
    @Column(name = "deathcountry")
    private String deathCountry;
    @Column(name = "deathstate")
    private String deathState;
    @Column(name = "deathcity")
    private String deathCity;
    @Column(name = "namefirst")
    private String nameFirst;
    @Column(name = "namelast")
    private String nameLast;
    @Column(name = "namegiven")
    private String nameGiven;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "height")
    private Integer height;
    @Column(name = "bats")
    private String batsSide;
    @Column(name = "throws")
    private String throwsSide;
    @Column(name = "debut")
    private LocalDate debut;
    @Column(name = "finalgame")
    private LocalDate finalGame;
    @Column(name = "retroid")
    private String retroID;
    @Column(name = "bbrefid")
    private String bbrefID;

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Integer getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(Integer deathMonth) {
        this.deathMonth = deathMonth;
    }

    public Integer getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Integer deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getBatsSide() {
        return batsSide;
    }

    public void setBatsSide(String batsSide) {
        this.batsSide = batsSide;
    }

    public String getThrowsSide() {
        return throwsSide;
    }

    public void setThrowsSide(String throwsSide) {
        this.throwsSide = throwsSide;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public LocalDate getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(LocalDate finalGame) {
        this.finalGame = finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerID, player.playerID) && Objects.equals(birthYear, player.birthYear) && Objects.equals(birthMonth, player.birthMonth) && Objects.equals(birthDay, player.birthDay) && Objects.equals(birthCountry, player.birthCountry) && Objects.equals(birthState, player.birthState) && Objects.equals(birthCity, player.birthCity) && Objects.equals(deathYear, player.deathYear) && Objects.equals(deathMonth, player.deathMonth) && Objects.equals(deathDay, player.deathDay) && Objects.equals(deathCountry, player.deathCountry) && Objects.equals(deathState, player.deathState) && Objects.equals(deathCity, player.deathCity) && Objects.equals(nameFirst, player.nameFirst) && Objects.equals(nameLast, player.nameLast) && Objects.equals(nameGiven, player.nameGiven) && Objects.equals(weight, player.weight) && Objects.equals(height, player.height) && Objects.equals(batsSide, player.batsSide) && Objects.equals(throwsSide, player.throwsSide) && Objects.equals(debut, player.debut) && Objects.equals(finalGame, player.finalGame) && Objects.equals(retroID, player.retroID) && Objects.equals(bbrefID, player.bbrefID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID, birthYear, birthMonth, birthDay, birthCountry, birthState, birthCity, deathYear, deathMonth, deathDay, deathCountry, deathState, deathCity, nameFirst, nameLast, nameGiven, weight, height, batsSide, throwsSide, debut, finalGame, retroID, bbrefID);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerID='" + playerID + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", birthDay=" + birthDay +
                ", birthCountry='" + birthCountry + '\'' +
                ", birthState='" + birthState + '\'' +
                ", birthCity='" + birthCity + '\'' +
                ", deathYear=" + deathYear +
                ", deathMonth=" + deathMonth +
                ", deathDay=" + deathDay +
                ", deathCountry='" + deathCountry + '\'' +
                ", deathState='" + deathState + '\'' +
                ", deathCity='" + deathCity + '\'' +
                ", nameFirst='" + nameFirst + '\'' +
                ", nameLast='" + nameLast + '\'' +
                ", nameGiven='" + nameGiven + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", batsSide='" + batsSide + '\'' +
                ", throwsSide='" + throwsSide + '\'' +
                ", debut=" + debut +
                ", finalGame=" + finalGame +
                ", retroID='" + retroID + '\'' +
                ", bbrefID='" + bbrefID + '\'' +
                '}';
    }
}
