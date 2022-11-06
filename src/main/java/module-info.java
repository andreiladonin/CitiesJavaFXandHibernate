module com.userappgui.appusers {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires poi;


    opens com.userappgui.appusers to javafx.fxml;
    opens com.userappgui.appusers.models;
    exports com.userappgui.appusers;
    exports com.userappgui.appusers.VM;
    opens com.userappgui.appusers.VM to javafx.fxml;

}