module FXProject01 {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;

	opens com.FXProject to javafx.graphics,javafx.controls, javafx.fxml,javafx.base;
	exports com.FXProject;
}
