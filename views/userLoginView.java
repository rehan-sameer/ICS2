package views;
import com.sun.javafx.scene.SceneEventDispatcher;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Objects.User;
import static views.MainApp.currentUser;

public class userLoginView {
    public static Scene userLoginView(Stage stage) {
        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(15);
        gp.setPadding(new Insets(20, 20, 20, 20)); // top, right, bottom, left
        gp.setAlignment(Pos.CENTER);


        Label loginLabel = new Label("User Login Screen");
        Label usernameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        TextField usernameTF = new TextField();
        TextField passwordTF = new TextField();
        Button loginBtn = new Button("Login");
        Button cancelBtn = new Button("Cancel");

        gp.add(loginLabel, 0, 0);
        gp.add(usernameLabel, 0, 1);
        gp.add(usernameTF, 1, 1);
        gp.add(passwordLabel, 0, 2);
        gp.add(passwordTF, 1, 2);
        gp.add(loginBtn, 2, 3);
        gp.add(cancelBtn, 1, 3);

        Label messageLabel = new Label(""); // starts empty
        gp.add(messageLabel, 1,4);

        loginBtn.setOnAction(e -> {
            String inputUsername = usernameTF.getText();
            String inputPassword = passwordTF.getText();

            boolean valid = false;
            for (User user : views.MainApp.users) {
                if (user.getUsername().equals(inputUsername) &&
                        user.getPassword().equals(inputPassword)) {
                    valid = true;
                    currentUser = user;
                    break;
                }
            }

            if (valid) {
                messageLabel.setText(""); // clear any previous error
                // todo: open user dashboard
                stage.setScene(UserDashboardView.UserDashboardView());
                stage.setTitle("User Dashboard");
                 // todo: close login window
            } else {
                messageLabel.setText("Invalid username or password. \nRegister if new user");
                Button registerBtn = new Button("Register");
                registerBtn.setMinWidth(150);
                registerBtn.setOnAction(e1 -> {
                    Stage loginStage = new Stage();
                    views.RegisterView register = new views.RegisterView();
                    //todo: open register window
                    //todo: close login window
                });
                gp.add(registerBtn,1,6);

            }
        });
        cancelBtn.setOnAction(e -> {
            //todo: close login window
        });


        Scene scene = new Scene(gp, 600, 400);
        return scene;
    }
}