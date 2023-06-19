package com.example.sportdiaryfrontend;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import sport.diary.api.workout.model.Workout;
import sport.diary.api.workout.repository.WorkoutRepository;
import sport.diary.api.workout.repository.WorkoutRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class HomePageController {

    @FXML
    private ListView<Workout> workoutLW;

    private WorkoutRepository  workoutRepository = new WorkoutRepositoryImpl();

    @FXML
    public void initialize() {

        List<Workout> workoutList = workoutRepository.readAll(Utils.currentCustomer);
        workoutLW.getItems().addAll(workoutList);
    }

    public void addWorkoutAction(){

        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Workout Name");
        Optional<String> rez = inputDialog.showAndWait();
        String workoutName = rez.get();
        System.out.println(workoutName);
        Workout workout = new Workout();
        workout.setName(workoutName);
        //workoutLW.getItems().add(workout);
        workoutRepository.create(workout,Utils.currentCustomer);
        workoutLW.getItems().clear();
        List<Workout> workoutList = workoutRepository.readAll(Utils.currentCustomer);
        workoutLW.getItems().addAll(workoutList);

    }
}
