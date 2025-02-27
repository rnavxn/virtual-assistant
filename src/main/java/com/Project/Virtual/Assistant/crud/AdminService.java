package com.Project.Virtual.Assistant.crud;

import java.util.List;

public interface AdminService {
    AdminDTO createAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminById(Long id);
    AdminDTO updateAdmin(Long id, AdminDTO adminDTO);
    String deleteAdmin(Long id);
}
