package com.Project.Virtual.Assistant.query;

import java.util.List;

public interface QueryService {
    QueryDTO createQuery(QueryDTO queryDTO);
    List<QueryDTO> getAllQueries();
    QueryDTO getQueryById(Long id);
    QueryDTO updateQuery(Long id, QueryDTO queryDTO);
    void deleteQuery(Long id);
}