package com.Project.Virtual.Assistant.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryRepository queryRepository;

    private QueryDTO convertToDTO(Query query) {
        QueryDTO dto = new QueryDTO();
        dto.setId(query.getId());
        dto.setQuestion(query.getQuestion());
        dto.setResponse(query.getResponse());
        dto.setStatus(query.getStatus().name());
        return dto;
    }

    private Query convertToEntity(QueryDTO dto) {
        Query query = new Query();
        query.setQuestion(dto.getQuestion());
        query.setResponse(dto.getResponse());
        query.setStatus(QueryStatus.valueOf(dto.getStatus()));
        return query;
    }

    @Override
    public QueryDTO createQuery(QueryDTO queryDTO) {
        Query query = convertToEntity(queryDTO);
        Query savedQuery = queryRepository.save(query);
        return convertToDTO(savedQuery);
    }

    @Override
    public List<QueryDTO> getAllQueries() {
        return queryRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public QueryDTO getQueryById(Long id) {
        Optional<Query> query = queryRepository.findById(id);
        if (query.isPresent()) {
            return convertToDTO(query.get());
        }
        throw new RuntimeException("Query not found");
    }

    @Override
    public QueryDTO updateQuery(Long id, QueryDTO queryDTO) {
        Optional<Query> optionalQuery = queryRepository.findById(id);
        if (optionalQuery.isPresent()) {
            Query existingQuery = optionalQuery.get();
            existingQuery.setQuestion(queryDTO.getQuestion());
            existingQuery.setResponse(queryDTO.getResponse());
            existingQuery.setStatus(QueryStatus.valueOf(queryDTO.getStatus()));
            Query updatedQuery = queryRepository.save(existingQuery);
            return convertToDTO(updatedQuery);
        }
        throw new RuntimeException("Query not found");
    }

    @Override
    public void deleteQuery(Long id) {
        queryRepository.deleteById(id);
    }
}