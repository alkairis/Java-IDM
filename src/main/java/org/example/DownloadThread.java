package org.example;

import javafx.scene.control.Alert;
import org.example.models.FIleInfo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadThread extends Thread{
    private FIleInfo file;
    DownloadManager manager;

    public DownloadThread(FIleInfo file, DownloadManager manager){
        this.file = file;
        this.manager = manager;
    }

    @Override
    public void run() {
        this.file.setStatus("DOWNLOADING");
        this.manager.updateUI(this.file);

        try {
            Files.copy(new URL(this.file.getUrl()).openStream(), Paths.get(this.file.getPath()));
            this.file.setStatus("DONE");
        } catch (IOException e) {
            this.file.setStatus("FAILED");
            this.file.setError(e.getClass().getSimpleName());
        }
        this.manager.updateUI(this.file);

    }
}
