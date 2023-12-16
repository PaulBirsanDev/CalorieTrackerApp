package TrackingCaloriesProject.FirstApp.Controller;

import TrackingCaloriesProject.FirstApp.Service.UserService;
import TrackingCaloriesProject.FirstApp.module.Components.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("profile")
@CrossOrigin(value = "http://localhost:4200")
public class CalorieController {
//    private final UserService service;

//    @GetMapping
//    List<Profile> getAll
//
}
