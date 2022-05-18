import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.tinylog.Logger;

public class GameController {

    @FXML
    private GridPane board;


    @FXML
    private void initialize() {
        for (var i = 0; i < board.getRowCount(); i++) {
            for (var j = 0; j < board.getColumnCount(); j++) {
                var box = createBox();
                board.add(box, j, i);
            }
        }
    }





    private StackPane createBox() {
        var box = new StackPane();
        box.getStyleClass().add("box");
        var stone = new Circle(30);
        stone.setFill(Color.TRANSPARENT);
        box.getChildren().add(stone);
       // box.getChildren().remove(stone);
        box.setOnMouseClicked(this::handleMouseClick);
        return box;
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        var box = (StackPane) event.getSource();
        var row = GridPane.getRowIndex(box);
        var col = GridPane.getColumnIndex(box);
        var stone = (Circle) box.getChildren().get(0);
        stone.setFill(takeAwayAStone((Color) stone.getFill()));

        // find a solution for this sout or delete it
        System.out.printf("Click on box (%d,%d)%n", row, col);
       // Logger.debug("Click on box (%d,%d)", row, col);
        clickedOnBox();



    }
    private Color takeAwayAStone(Color color) {
        if (color == Color.TRANSPARENT) {
            return Color.SLATEGRAY;
        }
        return Color.SLATEGRAY;

    }


    private void clickedOnBox(){

        Logger.info("You clicked in a box ");


    }
}
