package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.config.AppConfig;
import org.example.models.FIleInfo;
import java.io.File;

public class DownloadManager {

    @FXML
    private TableView<FIleInfo> tableView;

    @FXML
    private TextField urlInput;

    public int index = 0;


    @FXML
    void downloadButtonClicked(ActionEvent event) {
        String url = this.urlInput.getText().trim();
        if(url.isEmpty()){
            System.out.println("URL is empty.");
            return;
        }
        String filename = url.substring(url.lastIndexOf("/")+1);
        String status = "STARTING";
        String action = "OPEN";
        String path = AppConfig.DOWNLOAD_URL+ File.separator + filename;
        FIleInfo file = new FIleInfo(((index+1)+""), filename, url, status, action, path);
        this.index = this.index + 1;

        DownloadThread thread = new DownloadThread(file, this);
        this.tableView.getItems().add(Integer.parseInt(file.getIndex())-1, file);
        thread.start();
        this.urlInput.setText("");
    }

    @FXML
    public void initialize(){
        TableColumn<FIleInfo, String> sn = (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(0);
        sn.setCellValueFactory(p->{
            return p.getValue().indexProperty();
        });

        TableColumn<FIleInfo, String> filename = (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(1);
        filename.setCellValueFactory(p->{
            return p.getValue().filenameProperty();
        });

        TableColumn<FIleInfo, String> url = (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(2);
        url.setCellValueFactory(p->{
            return p.getValue().urlProperty();
        });

        TableColumn<FIleInfo, String> status = (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(3);
        status.setCellValueFactory(p->{
            return p.getValue().statusProperty();
        });

        TableColumn<FIleInfo, String> action = (TableColumn<FIleInfo, String>) this.tableView.getColumns().get(4);
        action.setCellValueFactory(p->{
            return p.getValue().actionsProperty();
        });
    }

    public void updateUI(FIleInfo metafile) {
        System.out.println(metafile);
        FIleInfo fileInfo = this.tableView.getItems().get(Integer.parseInt(metafile.getIndex())-1);
        fileInfo.setStatus(metafile.getStatus());
        this.tableView.refresh();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("");
    }
}
