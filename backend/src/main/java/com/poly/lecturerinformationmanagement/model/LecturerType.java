package com.poly.lecturerinformationmanagement.model;

public enum LecturerType {
    FULL_TIME("FULL_TIME"),
    PART_TIME("PART_TIME");

    private final String displayName;

    LecturerType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
