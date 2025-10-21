module com.Dzbice.untitled {
    requires javafx.controls;
    requires javafx.graphics;
    requires com.google.gson;

    // Export the package containing your main JavaFX Application
    exports app.Dz;

    // Open the package to javafx.graphics for reflective access
    opens app.Dz to javafx.graphics;
}
