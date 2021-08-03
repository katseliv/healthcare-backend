package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class AppointmentCreateDto {

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("is_taken")
    private Boolean isTaken;

    private Instant datetime;

    private String result;

    private String recipe;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

}
