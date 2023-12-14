package TrackingCaloriesProject.FirstApp.module.Enums;

public enum ActivityGoals {
    LOOSE_FAT("Loose Fat"),
    MAINTENANCE("Maintenance"),
    GAIN_MUSCLE("Gain Muscle");

    private String name;

    ActivityGoals(String name) {
        this.name = name;
    }
}
