module com.example.course_java_lab_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.course_java_lab_1 to javafx.fxml;
    exports com.example.course_java_lab_1;
}