package com.sunnywr.object;

import com.google.common.base.MoreObjects;

import java.util.Map;

public class UserMapForm {
    private Map<String, User> users;

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("users", users)
                .toString();
    }
}
