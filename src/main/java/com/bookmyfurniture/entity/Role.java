package com.bookmyfurniture.entity;


public class Role {
	String description;
	String name;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public Role(String description, String name, int roleId) {
		super();
		this.description = description;
		this.name = name;
		this.roleId = roleId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	int roleId;
}

