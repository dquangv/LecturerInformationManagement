package com.poly.lecturerinformationmanagement.model;

public enum EducationLevel {
    ASSOCIATE("Cử nhân Cao đẳng"),
    BACHELOR("Cử nhân Đại học"),
    MASTER("Thạc sỹ"),
    DOCTORATE("Tiến sỹ");

    private final String displayName;

    EducationLevel(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static EducationLevel fromDisplayName(String displayName) {
        for (EducationLevel level : EducationLevel.values()) {
            if (level.getDisplayName().equalsIgnoreCase(displayName)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid education level: " + displayName);
    }
}
