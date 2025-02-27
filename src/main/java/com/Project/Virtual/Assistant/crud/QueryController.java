package com.Project.Virtual.Assistant.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/queries")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping
    public QueryDTO createQuery(@RequestBody QueryDTO queryDTO) {
        return queryService.createQuery(queryDTO);
    }

    @GetMapping
    public List<QueryDTO> getAllQueries() {
        return queryService.getAllQueries();
    }

    @GetMapping("/{id}")
    public QueryDTO getQueryById(@PathVariable Long id) {
        return queryService.getQueryById(id);
    }

    @PutMapping("/{id}")
    public QueryDTO updateQuery(@PathVariable Long id, @RequestBody QueryDTO queryDTO) {
        return queryService.updateQuery(id, queryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteQuery(@PathVariable Long id) {
        queryService.deleteQuery(id);
    }
}