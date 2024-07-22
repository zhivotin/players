package com.intuit.players.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDTO implements Serializable {

    private String playerID;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;
    @JsonProperty("bats")
    private String batsSide;
    @JsonProperty("throws")
    private String throwsSide;
    private LocalDate debut;
    private LocalDate finalGame;
    private String retroID;
    private String bbrefID;

    public PlayerDTO() {

    }

    private PlayerDTO (Builder builder) {
        this.playerID = builder.playerID;
        this.birthYear = builder.birthYear;
        this.birthMonth = builder.birthMonth;
        this.birthDay = builder.birthDay;
        this.birthCountry = builder.birthCountry;
        this.birthState = builder.birthState;
        this.birthCity = builder.birthCity;
        this.deathYear = builder.deathYear;
        this.deathMonth = builder.deathMonth;
        this.deathDay = builder.deathDay;
        this.deathCountry = builder.deathCountry;
        this.deathState = builder.deathState;
        this.deathCity = builder.deathCity;
        this.nameFirst = builder.nameFirst;
        this.nameLast = builder.nameLast;
        this.nameGiven = builder.nameGiven;
        this.weight = builder.weight;
        this.height = builder.height;
        this.batsSide = builder.batsSide;
        this.throwsSide = builder.throwsSide;
        this.debut = builder.debut;
        this.finalGame = builder.finalGame;
        this.retroID = builder.retroID;
        this.bbrefID = builder.bbrefID;
    }

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
        PlayerDTO playerDTO = (PlayerDTO) o;
        return Objects.equals(playerID, playerDTO.playerID) && Objects.equals(birthYear, playerDTO.birthYear) && Objects.equals(birthMonth, playerDTO.birthMonth) && Objects.equals(birthDay, playerDTO.birthDay) && Objects.equals(birthCountry, playerDTO.birthCountry) && Objects.equals(birthState, playerDTO.birthState) && Objects.equals(birthCity, playerDTO.birthCity) && Objects.equals(deathYear, playerDTO.deathYear) && Objects.equals(deathMonth, playerDTO.deathMonth) && Objects.equals(deathDay, playerDTO.deathDay) && Objects.equals(deathCountry, playerDTO.deathCountry) && Objects.equals(deathState, playerDTO.deathState) && Objects.equals(deathCity, playerDTO.deathCity) && Objects.equals(nameFirst, playerDTO.nameFirst) && Objects.equals(nameLast, playerDTO.nameLast) && Objects.equals(nameGiven, playerDTO.nameGiven) && Objects.equals(weight, playerDTO.weight) && Objects.equals(height, playerDTO.height) && Objects.equals(batsSide, playerDTO.batsSide) && Objects.equals(throwsSide, playerDTO.throwsSide) && Objects.equals(debut, playerDTO.debut) && Objects.equals(finalGame, playerDTO.finalGame) && Objects.equals(retroID, playerDTO.retroID) && Objects.equals(bbrefID, playerDTO.bbrefID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID, birthYear, birthMonth, birthDay, birthCountry, birthState, birthCity, deathYear, deathMonth, deathDay, deathCountry, deathState, deathCity, nameFirst, nameLast, nameGiven, weight, height, batsSide, throwsSide, debut, finalGame, retroID, bbrefID);
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
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

    public static class Builder {
        private String playerID;
        private Integer birthYear;
        private Integer birthMonth;
        private Integer birthDay;
        private String birthCountry;
        private String birthState;
        private String birthCity;
        private Integer deathYear;
        private Integer deathMonth;
        private Integer deathDay;
        private String deathCountry;
        private String deathState;
        private String deathCity;
        private String nameFirst;
        private String nameLast;
        private String nameGiven;
        private Integer weight;
        private Integer height;
        private String batsSide;
        private String throwsSide;
        private LocalDate debut;
        private LocalDate finalGame;
        private String retroID;
        private String bbrefID;

        public Builder () {

        }

        public Builder playerID(String playerID) {
            this.playerID = playerID;
            return this;
        }

        public Builder birthYear(Integer birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        public Builder birthMonth(Integer birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }

        public Builder birthDay(Integer birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder birthCountry(String birthCountry) {
            this.birthCountry = birthCountry;
            return this;
        }

        public Builder birthState(String birthState) {
            this.birthState = birthState;
            return this;
        }

        public Builder birthCity(String birthCity) {
            this.birthCity = birthCity;
            return this;
        }

        public Builder deathYear(Integer deathYear) {
            this.deathYear = deathYear;
            return this;
        }

        public Builder deathMonth(Integer deathMonth) {
            this.deathMonth = deathMonth;
            return this;
        }

        public Builder deathDay(Integer deathDay) {
            this.deathDay = deathDay;
            return this;
        }

        public Builder deathCountry(String deathCountry) {
            this.deathCountry = deathCountry;
            return this;
        }

        public Builder deathState(String deathState) {
            this.deathState = deathState;
            return this;
        }

        public Builder deathCity(String deathCity) {
            this.deathCity = deathCity;
            return this;
        }

        public Builder nameFirst(String nameFirst) {
            this.nameFirst = nameFirst;
            return this;
        }

        public Builder nameLast(String nameLast) {
            this.nameLast = nameLast;
            return this;
        }

        public Builder nameGiven(String nameGiven) {
            this.nameGiven = nameGiven;
            return this;
        }

        public Builder weight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Builder height(Integer height) {
            this.height = height;
            return this;
        }

        public Builder batsSide(String batsSide) {
            this.batsSide = batsSide;
            return this;
        }

        public Builder throwsSide(String throwsSide) {
            this.throwsSide = throwsSide;
            return this;
        }

        public Builder debut(LocalDate debut) {
            this.debut = debut;
            return this;
        }

        public Builder finalGame(LocalDate finalGame) {
            this.finalGame = finalGame;
            return this;
        }

        public Builder retroID(String retroID) {
            this.retroID = retroID;
            return this;
        }

        public Builder bbrefID(String bbrefID) {
            this.bbrefID = bbrefID;
            return this;
        }

        public PlayerDTO build() {
            return new PlayerDTO(this);
        }
    }
}
