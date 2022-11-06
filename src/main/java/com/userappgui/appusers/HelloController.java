package com.userappgui.appusers;

import com.userappgui.appusers.Repositories.CityRepository;
import com.userappgui.appusers.VM.CityVM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import com.userappgui.appusers.models.City;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class HelloController {

    @FXML
    private Label label_city;

    @FXML
    private TextField txt_city;

    @FXML
    private TableView<CityVM> tableView_city;
    @FXML
    private TableColumn<CityVM, Integer> tableView_city_id_column;
    @FXML
    private TableColumn<CityVM, String> tableView_city_name_column;

    @FXML
    public void initialize() {
        tableView_city_id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView_city_name_column.setCellValueFactory(new PropertyValueFactory<>("name"));

        ObservableList<CityVM> list = loadData();

        tableView_city.setItems(list);
    }
    @FXML
    protected void onChangeCity (){
        City city = new City(txt_city.getText());
        CityRepository.Add(city);

    }

    private ObservableList<CityVM>  loadData() {
        List<City> cityList = CityRepository.getAll();

        ObservableList<CityVM> cityVMS = FXCollections.observableArrayList();

        cityList.stream().forEach((city -> {
            cityVMS.add(new CityVM(city.getId().intValue(), city.getNameCity()));
        }));

        return cityVMS;
    }

    @FXML
    private void onSaveExcel (){
        try {
            ExcelHelper.saveDataExcel();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}