package backend2026.musiikkikokoelma.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id", nullable = false, updatable = false)
    private Long artistId;

    @Size(min=1)
    @NotNull
    private String name;

    @Column(name = "founding_year")
    private Integer foundingYear;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
    private List<Album> albums;

    // @ManyToMany(cascade = CascadeType.ALL, mappedBy = "songArtists")
    @JsonIgnoreProperties("artist")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
    private List<Song> songs;

    public Artist() {
    }

    public Artist(String name, Integer foundingYear, List<Album> albums, List<Song> songs) {
        this.name = name;
        this.foundingYear = foundingYear;
        this.albums = albums;
        this.songs = songs;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(Integer foundingYear) {
        this.foundingYear = foundingYear;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Artist [artistId=" + artistId + ", name=" + name + ", foundingYear=" + foundingYear + "]";
    }

}
