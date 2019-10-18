module com.wembleyleach {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    exports com.wembleyleach;
    opens com.wembleyleach to javafx.fxml;
}
