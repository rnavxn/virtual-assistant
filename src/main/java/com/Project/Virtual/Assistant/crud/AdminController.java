package com.Project.Virtual.Assistant.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public AdminDTO createAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.createAdmin(adminDTO);
    }

    @GetMapping
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminDTO getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public AdminDTO updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(id, adminDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}
