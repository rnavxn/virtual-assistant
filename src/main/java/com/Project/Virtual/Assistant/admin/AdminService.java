package com.Project.Virtual.Assistant.admin;

import java.util.*;
import java.util.Optional;

public interface AdminService {
    Admin createAdmin(AdminDTO adminDTO);
    List<Admin> getAllAdmins();
    Optional<Admin> getAdminById(Long id);
}
