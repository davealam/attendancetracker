package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        EmployeeRepository.getInstance().loadState();

        //Goes through loaded employee list and calls method to remove expired points
        for(int i = 0; i < EmployeeRepository.getInstance().getEmployeeObservableList().size(); i++) {
            EmployeeRepository.getInstance().getEmployeeObservableList().get(i).removeExpiredPoints();
        }

        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("AttendanceTracker");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        EmployeeRepository.getInstance().saveState();
        super.stop();
    }
}