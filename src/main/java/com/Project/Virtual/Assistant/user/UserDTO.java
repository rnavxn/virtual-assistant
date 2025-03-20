package com.Project.Virtual.Assistant.user;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;
    private String name;
    private String email;
    private Role role;
    
 // Constructor to convert User -> UserDTO
    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

}
