package com.nabang97.bookrent.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 18/06/2022 & 8:30
 */

public class JobDescData {
    @NotEmpty(message = "id is required")
    private String id;
    private String instituteName;
    private String institutePhone;
    @NotEmpty(message = "job is required")
    private String job;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstitutePhone() {
        return institutePhone;
    }

    public void setInstitutePhone(String institutePhone) {
        this.institutePhone = institutePhone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
