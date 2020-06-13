package pl.pszczolkowski.demo.model;

public class Movie {
    String title;
    String directorName;
    Long productionDate;

    public Movie(String title, String directorName, Long productionDate) {
        this.title = title;
        this.directorName = directorName;
        this.productionDate = productionDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Long getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Long productionDate) {
        this.productionDate = productionDate;
    }
}
