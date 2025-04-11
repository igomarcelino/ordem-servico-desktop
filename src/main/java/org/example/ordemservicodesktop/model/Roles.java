package org.example.ordemservicodesktop.model;

public class Roles {
    private Integer id;
    private String roleName;

    public Roles(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Roles() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
