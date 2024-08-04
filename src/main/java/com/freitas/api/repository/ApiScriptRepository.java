package com.freitas.api.repository;

import com.freitas.api.model.ApiScript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiScriptRepository extends JpaRepository <ApiScript,Long> {
    ApiScript findByApiName(String apiName);

}
