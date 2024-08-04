package com.freitas.api.service;


import com.freitas.api.model.ApiScript;
import com.freitas.api.repository.ApiScriptRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@Service
public class CustomService {

    @PersistenceContext
    private EntityManager entityMana;

    private TransactionTemplate transactionTemplate;

    public CustomService(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }



    @Autowired
    private ApiScriptRepository apiScriptRepository;

    public List<Map<String, Object>> executeSqlScript(String apiName) {
        ApiScript apiScript = apiScriptRepository.findByApiName(apiName);
        if (apiScript == null) {
            throw new RuntimeException("API Script not found for API name: " + apiName);
        }

        String sql = apiScript.getSqlScript();

        List<Map<String, Object>> resultList = transactionTemplate.execute(status -> {
            Query query = entityMana.createNativeQuery(sql);
            query.unwrap(org.hibernate.query.NativeQuery.class)
                    .setResultTransformer(org.hibernate.transform.Transformers.ALIAS_TO_ENTITY_MAP);
            return query.getResultList();
        });

        return resultList;



    }






}








