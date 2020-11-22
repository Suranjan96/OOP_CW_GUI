import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;

public class GUI extends Application {
    private final static Wins wins = new Wins();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainPage();

    }

    public void mainPage(){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Premier League");
        Scene mainScene;

        AnchorPane mainLayout = new AnchorPane();


        Label label = new Label("Premier League");
        label.setTextFill(Color.web("#ffffff", 1));
        //Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
        //label.setFont(font);
        //label.setFont(Font.font(58));
        label.setPrefHeight(115);
        label.setPrefWidth(529);
        //label.setLayoutX(125);
        label.setLayoutY(15);
        label.setStyle("-fx-font-size: 40;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

        Button btnRanking = new javafx.scene.control.Button("Ranking Table");
        btnRanking.setLayoutX(125);
        btnRanking.setLayoutY(150);
        btnRanking.setPrefWidth(250);
        btnRanking.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

        Button btnMatches = new javafx.scene.control.Button("Table of Matches");
        btnMatches.setLayoutX(125);
        btnMatches.setLayoutY(250);
        btnMatches.setPrefWidth(250);
        btnMatches.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");

        Button btnCloseWin = new Button("Exit");
        btnCloseWin.setLayoutX(300);
        btnCloseWin.setLayoutY(400);
        btnCloseWin.setPrefWidth(100);
        btnCloseWin.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");
        btnCloseWin.setOnAction(event -> primaryStage.close());


       //mainLayout.setStyle("-fx-background-color: #ffffff;");
        mainLayout.setStyle("-fx-background-image: url(img1.jpg);"+"-fx-background-repeat: stretch;"+
                "-fx-background-size: 500 500;"+
                "-fx-background-position: center center;");
        mainLayout.getChildren().addAll(label,btnRanking, btnMatches,btnCloseWin);      // 3 buttons add to main window layout
        mainScene = new Scene(mainLayout,500,500);
        primaryStage.setResizable(false);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        btnRanking.setOnAction(event -> {       // Open action on Finance Calculator.
            primaryStage.close();
            rankingTable();

        });
        btnMatches.setOnAction(event -> {      //Open action on Auto loan Calculator
            primaryStage.close();
            matchTable();

        });
    }

    public void rankingTable() {
        Stage stage = new Stage();
        stage.setTitle("Premier League Ranking Table");
        Scene scene;

        Pane pane = new Pane();
        Label label;
        pane.getChildren().add(label = new Label("Ranking Table"));
       label.setTextFill(Color.web("#ffffff", 1));
       pane.setStyle("-fx-background-image: url(img2.jpg);"+"-fx-background-repeat: stretch;"+
               "-fx-background-size: 1000 800;"+
               "-fx-background-position: center center;");
        //pane.setStyle("-fx-background-color: #936ab7;");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
        label.setFont(font);
        //label.setFont(Font.font(58));
        label.setPrefHeight(115);
        label.setPrefWidth(529);
        label.setLayoutX(40);
        label.setLayoutY(15);

        PremierLeagueManager.premierLeague.sort(Collections.reverseOrder());
        TableView<SportClub> table = new TableView<SportClub>();
        final ObservableList<SportClub> data = FXCollections.observableArrayList(PremierLeagueManager.premierLeague);

        /*TableColumn position = new TableColumn("Position");
        position.setCellValueFactory(new PropertyValueFactory("position"));
        position.setPrefWidth(80);*/

        TableColumn name = new TableColumn("Club Name");
        name.setCellValueFactory(new PropertyValueFactory("clubName1"));
        name.setSortable(false);
        name.setPrefWidth(160);


        TableColumn played = new TableColumn("Played");
        played.setCellValueFactory(new PropertyValueFactory("noOfMatches"));
        played.setSortable(false);
        played.setPrefWidth(90);
       played.setStyle( "-fx-alignment: CENTER;");

        TableColumn won = new TableColumn(" Won ");
        won.setCellValueFactory(new PropertyValueFactory("wins"));
        won.setPrefWidth(90);
       won.setStyle( "-fx-alignment: CENTER;");

        TableColumn drawn = new TableColumn(" Drawn ");
        drawn.setCellValueFactory(new PropertyValueFactory("draws"));
       drawn.setSortable(false);
        drawn.setPrefWidth(90);
       drawn.setStyle( "-fx-alignment: CENTER;");

        TableColumn lost = new TableColumn(" Lost ");
        lost.setCellValueFactory(new PropertyValueFactory("defeats"));
        lost.setSortable(false);
        lost.setPrefWidth(90);
       lost.setStyle( "-fx-alignment: CENTER;");

        TableColumn goalFor = new TableColumn(" GF ");
        goalFor.setCellValueFactory(new PropertyValueFactory("scored"));
        goalFor.setPrefWidth(85);
       goalFor.setStyle( "-fx-alignment: CENTER;");

        TableColumn goalAgainst = new TableColumn(" GA ");
        goalAgainst.setCellValueFactory(new PropertyValueFactory("noOfGoals"));
        goalAgainst.setSortable(false);
        goalAgainst.setPrefWidth(85);
       goalAgainst.setStyle( "-fx-alignment: CENTER;");

        TableColumn gaolDiffernce = new TableColumn(" GD ");
        gaolDiffernce.setCellValueFactory(new PropertyValueFactory("goalDifference"));
        gaolDiffernce.setSortable(false);
        gaolDiffernce.setPrefWidth(85);
       gaolDiffernce.setStyle( "-fx-alignment: CENTER;");

        TableColumn points = new TableColumn("Points");
        points.setCellValueFactory(new PropertyValueFactory("noOfPoints"));
        points.setPrefWidth(90);
        points.setStyle( "-fx-alignment: CENTER;");


        //Adding data to the table
       ObservableList<String> list = FXCollections.observableArrayList();
       table.setItems(data);
       table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       table.getColumns().addAll(name, played, won, drawn, lost, goalFor, goalAgainst, gaolDiffernce, points);

        //Setting the size of the table
       //table.setStyle(" . table-row-cell {-fx-cell-size: 50px;}");
       table.setFixedCellSize(40);
        table.setMaxSize(866, 400);

        VBox vbox;
        pane.getChildren().add(vbox = new VBox());

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 50, 50, 60));
        vbox.getChildren().addAll(label, table);

        Button btnOption1;
        pane.getChildren().add(btnOption1 = new Button("Home"));
        btnOption1.setPrefHeight(50);
        btnOption1.setPrefWidth(150);
        btnOption1.setLayoutX(500);
        btnOption1.setLayoutY(600);
        btnOption1.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");

        //btnOption1.setStyle("-fx-background-color:#1a6ebf");
        btnOption1.setOnAction(event -> {
            stage.close();
            mainPage();
        });

        Button exit;
        pane.getChildren().add(exit = new Button("Exit"));
        exit.setPrefWidth(120);
        exit.setLayoutX(750);
        exit.setLayoutY(600);
        exit.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-alignment: center;"+"-fx-background-radius: 50px;");
        //exit.setStyle("-fx-background-color:#bf1a2d");
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED,
                event -> {
                    stage.close();
                });

        Label label1;
        pane.getChildren().add(label1 = new Label("Sort by:-"));
        label1.setTextFill(Color.web("#ffffff", 1));
        Font font1 = Font.font("verdana", FontWeight.BOLD, 22);
        label1.setFont(font1);
        label1.setPrefHeight(30);
        label1.setPrefWidth(150);
        label1.setLayoutX(40);
        label1.setLayoutY(600);

        Button sortWon;
        pane.getChildren().add(sortWon = new Button("Won"));
        sortWon.setPrefHeight(10);
        sortWon.setPrefWidth(80);
        sortWon.setLayoutX(40);
        sortWon.setLayoutY(650);
        sortWon.setStyle("-fx-font-size: 16;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");

        sortWon.setOnAction(event -> {
            PremierLeagueManager.premierLeague.sort(Collections.reverseOrder());
            //wins.compare();
            //table.setItems();

        });

        Button sortGF;
        pane.getChildren().add(sortGF = new Button("GF"));
        sortGF.setPrefHeight(10);
        sortGF.setPrefWidth(80);
        sortGF.setLayoutX(40);
        sortGF.setLayoutY(700);
        sortGF.setStyle("-fx-font-size: 16;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");

        sortGF.setOnAction(event -> {
            PremierLeagueManager.premierLeague.sort(Collections.reverseOrder());
            //wins.compare();
            //table.setItems();

        });

        Button sortPoint;
        pane.getChildren().add(sortPoint = new Button("Points"));
        sortPoint.setPrefHeight(10);
        sortPoint.setPrefWidth(80);
        sortPoint.setLayoutX(40);
        sortPoint.setLayoutY(750);
        sortPoint.setStyle("-fx-font-size: 16;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");

        sortPoint.setOnAction(event -> {
            PremierLeagueManager.premierLeague.sort(Collections.reverseOrder());
            //wins.compare();
            //table.setItems();

        });

       scene = new Scene(pane, 1000, 800);
       stage.setResizable(false);
       stage.setScene(scene);
       stage.show();

    }

    public void matchTable(){
        Stage stage = new Stage();
        stage.setTitle("Premier League Match Table");
        Scene scene;

        Pane pane = new Pane();
        pane.setStyle("-fx-background-image: url(img2.jpg);"+"-fx-background-repeat: stretch;"+ "-fx-background-size: 1000 800;"+ "-fx-background-position: center center;");
        Label label;
        pane.getChildren().add(label = new Label("Table of Matches"));
        label.setTextFill(Color.web("#ffffff", 1));
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
        label.setFont(font);
        label.setPrefHeight(115);
        label.setPrefWidth(529);
        label.setLayoutX(40);
        label.setLayoutY(15);

        /*final DatePicker datePicker = new DatePicker();
        // Make the DatePicker non-editable
        datePicker.setEditable(false);
        datePicker.setPrefHeight(50);
        datePicker.setPrefWidth(150);
        datePicker.setLayoutX(750);
        datePicker.setLayoutY(25);
        datePicker.setStyle("-fx-font-size: 16;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");
        pane.getChildren().add(datePicker);
        // Print the new date in the TextArea*/

        TableView<SportClub> table = new TableView<SportClub>();
        final ObservableList<SportClub> data1 = FXCollections.observableArrayList(PremierLeagueManager.matches);

        TableColumn date1 = new TableColumn("Date");
        table.refresh();
        date1.setCellValueFactory(new PropertyValueFactory("date"));
        date1.setPrefWidth(160);
        date1.setStyle( "-fx-alignment: CENTER;");

        TableColumn home_team = new TableColumn("Home Team");
        home_team.setCellValueFactory(new PropertyValueFactory("clubName1"));
        home_team.setSortable(false);
        home_team.setPrefWidth(180);
        home_team.setStyle( "-fx-alignment: CENTER;");

        TableColumn results = new TableColumn("Results");

        TableColumn results1 = new TableColumn("Home");
        results1.setCellValueFactory(new PropertyValueFactory("noOfGoals"));
        results1.setSortable(false);
        results1.setPrefWidth(100);
        results1.setStyle( "-fx-alignment: CENTER;");

        TableColumn results2 = new TableColumn("Away");
        results2.setCellValueFactory(new PropertyValueFactory("scored"));
        results2.setSortable(false);
        results2.setPrefWidth(100);
        results2.setStyle( "-fx-alignment: CENTER;");

        results.getColumns().addAll(results1,results2);
        results.setSortable(false);
        results.setPrefWidth(100);
        results.setStyle( "-fx-alignment: CENTER;");

        TableColumn away_team = new TableColumn("Away Team");
        away_team.setCellValueFactory(new PropertyValueFactory("clubName2"));
        away_team.setSortable(false);
        away_team.setPrefWidth(180);
        away_team.setStyle( "-fx-alignment: CENTER;");

        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(date1, home_team, results, away_team);

        //Setting the size of the table
        table.setFixedCellSize(40);
        table.setMaxSize(820, 400);
        table.setItems(data1);

        VBox vbox;
        pane.getChildren().add(vbox = new VBox());
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 50, 50, 60));
        vbox.getChildren().addAll(label, table);

        Button random;
        pane.getChildren().add(random = new Button("Let's Play"));
        random.setPrefHeight(50);
        random.setPrefWidth(150);
        random.setLayoutX(500);
        random.setLayoutY(25);
        random.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");
        random.setOnAction(event -> {
            Main.random();
            stage.close();
            matchTable();
        });

        Button btnOption2;
        pane.getChildren().add(btnOption2 = new Button("Home"));
        btnOption2.setPrefHeight(50);
        btnOption2.setPrefWidth(150);
        btnOption2.setLayoutX(500);
        btnOption2.setLayoutY(600);
        btnOption2.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");
        btnOption2.setOnAction(event -> {
            stage.close();
            mainPage();
        });

        Button exit;
        pane.getChildren().add(exit = new Button("Exit"));
        exit.setPrefHeight(50);
        exit.setPrefWidth(120);
        exit.setLayoutX(750);
        exit.setLayoutY(600);
        exit.setStyle("-fx-font-size: 20;"+"-fx-font-weight: bold;"+"-fx-background-radius: 50px;");
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED,
                event -> {
            stage.close();
                });

        scene = new Scene(pane, 1000, 800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void searchDate(){

    }
}
