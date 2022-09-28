package org.example.models;

import javafx.beans.property.SimpleStringProperty;

public class FIleInfo {
    private SimpleStringProperty index = new SimpleStringProperty();
    private SimpleStringProperty filename = new SimpleStringProperty();
    private SimpleStringProperty url = new SimpleStringProperty();
    private SimpleStringProperty status = new SimpleStringProperty();
    private SimpleStringProperty actions = new SimpleStringProperty();
    private SimpleStringProperty path = new SimpleStringProperty();

    private String error;

    public FIleInfo(String index, String filename, String url, String status, String actions, String path) {
        this.index.set(index);
        this.filename.set(filename);
        this.url.set(url);
        this.status.set(status);
        this.actions.set(actions);
        this.path.set(path);
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public String getFilename() {
        return filename.get();
    }

    public SimpleStringProperty filenameProperty() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename.set(filename);
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getActions() {
        return actions.get();
    }

    public SimpleStringProperty actionsProperty() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions.set(actions);
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    @Override
    public String toString() {
        return "FIleInfo{" +
                "index=" + index +
                ", filename=" + filename +
                ", url=" + url +
                ", status=" + status +
                ", actions=" + actions +
                ", path=" + path +
                ", error='" + error + '\'' +
                '}';
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
