module com.yepianer.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires easyexcel.core;
    requires org.apache.poi.poi;
    requires org.apache.logging.log4j;
    requires com.alibaba.fastjson2;



    opens com.yepianer.demo to javafx.fxml;
    exports com.yepianer.demo;
}