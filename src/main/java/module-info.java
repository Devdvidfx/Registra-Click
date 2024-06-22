module org.controle.normaeng {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires annotations;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens org.controle.normaeng to javafx.fxml;
    exports org.controle.normaeng;
}