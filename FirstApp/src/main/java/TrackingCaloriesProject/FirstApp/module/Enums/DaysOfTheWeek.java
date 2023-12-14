package TrackingCaloriesProject.FirstApp.module.Enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public enum DaysOfTheWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private Integer code;

    DaysOfTheWeek(Integer code) {
        this.code = code;
    }
}
