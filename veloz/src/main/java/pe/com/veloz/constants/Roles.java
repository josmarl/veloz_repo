/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.constants;

public enum Roles {

    USER("ROLE_USER", "USER"),
    ADMIN("ROLE_ADMIN", "ADMIN");

    private String role;
    private String roleSubString;

    private Roles(String role, String roleSubString) {
        this.role = role;
        this.roleSubString = roleSubString;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleSubString() {
        return roleSubString;
    }

    public void setRoleSubString(String roleSubString) {
        this.roleSubString = roleSubString;
    }

}
