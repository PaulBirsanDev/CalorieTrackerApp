package TrackingCaloriesProject.FirstApp.Components;

import TrackingCaloriesProject.FirstApp.Interfaces.GetInformation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Getter
@Component
@RequiredArgsConstructor
public class Profile implements GetInformation {
    private String firstName;

    private String lastName;

    private Integer age;

    private Double weight;

    private Double height;

    private Character gender;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
