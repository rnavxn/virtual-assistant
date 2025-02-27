package com.Project.Virtual.Assistant.crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    private AdminDTO convertToDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole().name());
        return dto;
    }

    private Admin convertToEntity(AdminDTO dto) {
        Admin admin = new Admin();
        admin.setEmail(dto.getEmail());
        admin.setRole(AdminRole.valueOf(dto.getRole()));
        return admin;
    }

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin admin = convertToEntity(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return convertToDTO(savedAdmin);
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return convertToDTO(admin.get());
        }
        throw new RuntimeException("Admin not found");
    }

    @Override
    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            Admin existingAdmin = optionalAdmin.get();
            existingAdmin.setEmail(adminDTO.getEmail());
            existingAdmin.setRole(AdminRole.valueOf(adminDTO.getRole()));
            Admin updatedAdmin = adminRepository.save(existingAdmin);
            return convertToDTO(updatedAdmin);
        }
        throw new RuntimeException("Admin not found");
    }

    @Override
    public String deleteAdmin(Long id) {
    	if(adminRepository.existsById(id)) {
    		adminRepository.deleteById(id);
    		return "Deleted Successfully";
    	}
    	else {
    		return "Data Not found!!";
    	}
    }
}