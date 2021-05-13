package sample;

import javafx.event.ActionEvent;

public class Controller {
    boolean isGlassExist = false;
    boolean isBottleOpened = false;
    boolean isBeerPoured = false;
    public void putOnTableTheGlassAction(ActionEvent actionEvent) {
        System.out.println("Подготовка к празднеству! Ставлю стакан.");
        isGlassExist = true;
    }

    public void openBottleAction(ActionEvent actionEvent) {
        if (isGlassExist) {
            System.out.println("Открываю пивко...");
        } else {
            putOnTableTheGlassAction(actionEvent);
            openBottleAction(actionEvent);
        }
        isBottleOpened = true;
    }

    public void pourTheBeerAction(ActionEvent actionEvent) {
        if (isBottleOpened&&isGlassExist) {
            System.out.println("Наливаю в стакан...");
        } else {
            putOnTableTheGlassAction(actionEvent);
            openBottleAction(actionEvent);
            pourTheBeerAction(actionEvent);
        }
        isBeerPoured = true;
    }

    public void drinkTheBeerAction(ActionEvent actionEvent) throws InterruptedException {
        if (isBeerPoured&&isBottleOpened&&isGlassExist) {
            System.out.println("Закрываю глаза, щас мне будет легко!");
        } else {
            putOnTableTheGlassAction(actionEvent);
            openBottleAction(actionEvent);
            pourTheBeerAction(actionEvent);
            drinkTheBeerAction(actionEvent);
        }
        isBottleOpened = false;
        isBeerPoured = false;
        Thread.sleep(5000);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
