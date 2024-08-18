package com.poly.lecturerinformationmanagement.model;

public enum Department {
    INFORMATION_TECHNOLOGY("Công nghệ thông tin"),
    SOFTWARE_APPLICATION("Ứng dụng phần mềm"),
    SOFTWARE_DEVELOPMENT("Phát triển phần mềm");

    private final String displayName;

    Department(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Department fromDisplayName(String displayName) {
        for (Department dep : Department.values()) {
            if (dep.getDisplayName().equalsIgnoreCase(displayName)) {
                return dep;
            }
        }
        throw new IllegalArgumentException("Invalid department: " + displayName);
    }
}
