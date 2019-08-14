import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AlarmApp extends Application {
    //start application
    public void start(Stage primaryStage){
        Pane aPane = new Pane();
        aPane.setStyle("-fx-background-color: white;");
        Pane inPane1 = new Pane();
        inPane1.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        inPane1.relocate(10,10);
        inPane1.setPrefSize(200,90);
        Pane inPane2 = new Pane();
        inPane2.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        inPane2.relocate(220,10);
        inPane2.setPrefSize(200,40);
        Pane inPane3 = new Pane();
        inPane3.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        inPane3.relocate(220,60);
        inPane3.setPrefSize(200,40);

        Label label1 = new Label();
        //label1.setLabelFor(inPane1);
        label1.setText("Remaining Time:");
        label1.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        label1.relocate(10,10);

        Label label2 = new Label();
        //label2.setLabelFor(inPane2);
        label2.setText("Current Time:");
        label2.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        label2.relocate(220,10);

        Label label3 = new Label();
        //label3.setLabelFor(inPane3);
        label3.setText("Alarm Time:");
        label3.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        label3.relocate(220,60);

        Label remainTime = new Label();
        remainTime.setText("00:00:00");
        remainTime.setStyle("-fx-font: 48 System; -fx-text-fill: darkgreen;");
        remainTime.relocate(22,20);

        TextField tf1 = new TextField();
        tf1.setText("01:54:16 PM");
        tf1.relocate(225,20);
        tf1.setPrefSize(190,25);
        tf1.setAlignment(Pos.CENTER_RIGHT);

        TextField tf2 = new TextField();
        tf2.setText("10:30:00 AM");
        tf2.relocate(225,70);
        tf2.setPrefSize(190,25);
        tf2.setAlignment(Pos.CENTER_RIGHT);
        //tf2.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");

        Button newAlarm = new Button();
        newAlarm.setText("New Alarm");
        newAlarm.setPrefSize(100,30);
        newAlarm.relocate(10,150);

        Button editB = new Button();
        newAlarm.setText("Edit");
        newAlarm.setPrefSize(80,30);
        newAlarm.relocate(120,150);

        Button deleteB = new Button();
        newAlarm.setText("Delete");
        newAlarm.setPrefSize(80,30);
        newAlarm.relocate(210,150);

        RadioButton[] radioB = new RadioButton[2];
        String[] radioBLabels = {"ON", "OFF"};

        ToggleGroup toggle = new ToggleGroup();

        for (int i = 0; i<2; i++){
            radioB[i] = new RadioButton(radioBLabels[i]);
            radioB[i].relocate(310 + i*50, 150);
            radioB[i].setPrefSize(50,30);
            aPane.getChildren().add(radioB[i]);
            radioB[i].setToggleGroup(toggle);
            radioB[i].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {

                }
            });

        }

        ObservableList<String> options = FXCollections.observableArrayList("Weekday", "Saturday", "Sunday");
        ComboBox select = new ComboBox(options);
        select.setPromptText("Select Alarm");
        select.setPrefSize(410,30);
        select.relocate(10,110);

        aPane.getChildren().addAll(inPane1,inPane2,inPane3,label1,label2,label3,remainTime,tf1,tf2,select,newAlarm, editB, deleteB);
        //inPane1.getChildren().add();
        //inPane2.getChildren().add(tf1);
        //inPane3.getChildren().add(tf2);


        primaryStage.setTitle("Alarm App");
        primaryStage.setScene(new Scene(aPane, 430,190));
        //primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
