package com.freitas.api.model;


import jakarta.persistence.*;


@Entity
@Table(name = "api_scripts")
public class ApiScript {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

    @Column(name = "api_name", nullable = false)
    private String apiName;

    @Column(name = "sql_script", nullable = false)
    private String sqlScript;

    public ApiScript() {
    }

    public ApiScript(long id, String apiName, String sqlScript) {
        this.id = id;
        this.apiName = apiName;
        this.sqlScript = sqlScript;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getSqlScript() {
        return sqlScript;
    }

    public void setSqlScript(String sqlScript) {
        this.sqlScript = sqlScript;
    }
}
