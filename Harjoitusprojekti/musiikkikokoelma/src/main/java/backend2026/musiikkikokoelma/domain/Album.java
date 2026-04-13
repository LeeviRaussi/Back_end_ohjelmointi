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
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id", nullable = false, updatable = false)
    private Long albumId;

    @Size(max=50)
    private String title;

    @Column(name = "release_year")
    private Integer releaseYear;

    //@JsonIgnoreProperties("albums")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "artist_id")
    @NotNull
    private Artist artist;

    // @ManyToMany(cascade = CascadeType.ALL, mappedBy = "songAlbums")
    @JsonIgnoreProperties("album")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Song> songs;

    public Album() {
    }

    public Album(String title, Integer releaseYear, Artist artist, List<Song> songs) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.songs = songs;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album [albumId=" + albumId + ", title=" + title + ", artist=" + artist + "]";
    }

}
