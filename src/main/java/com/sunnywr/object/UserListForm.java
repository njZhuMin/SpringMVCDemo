package com.sunnywr.object;

import com.google.common.base.MoreObjects;

import java.util.List;

public class UserListForm {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("users", users)
                .toString();
    }
}
