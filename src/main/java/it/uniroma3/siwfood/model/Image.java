package it.uniroma3.siwfood.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "imagedata", length = 2000)
    public byte[] imageData;
    public String filename;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public byte[] getImageData() {
        return imageData;
    }
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFormat(){
        return getFilename().substring(1+getFilename().lastIndexOf('.'));
    }

    public String getBase64() {
        return Base64.getEncoder().encodeToString(this.imageData);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(imageData);
        result = prime * result + Objects.hash(filename);
        return result;
    }
}
