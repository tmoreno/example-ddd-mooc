package com.tmoreno.mooc.backoffice.student.commands.changeName;

import com.tmoreno.mooc.shared.command.CommandParams;

public final class ChangeStudentNameCommandParams extends CommandParams {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
