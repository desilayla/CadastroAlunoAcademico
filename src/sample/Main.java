package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Banco.BancodeDados;
import sample.Telinhas.TelaPesquisa;

public class Main extends Application {


    public void start(Stage palco) throws Exception {
        try {

            TelaPesquisa pesquisa = new TelaPesquisa();
            pesquisa.start(palco);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);

        BancodeDados b = BancodeDados.getInstance();


    }
}
