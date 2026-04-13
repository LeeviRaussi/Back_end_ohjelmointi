package backend2026.musiikkikokoelma.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
/* import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany; */
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id", nullable = false, updatable = false)
    private Long songId;

    @Size(min=1, max=50)
    @NotNull
    private String title;

    /* Many-To-Many lähde: https://www.baeldung.com/jpa-many-to-many
    @ManyToMany
    @JoinTable(
        name = "artist_song",
        joinColumns = @JoinColumn(name = "song_id"),
        inverseJoinColumns = @JoinColumn(name = "artist_id")
    ) */
    @JsonIgnoreProperties("songs")
    @ManyToOne
    @JoinColumn(name = "artist_id")
    @NotNull
    private Artist artist;

    @Column(name = "release_year")
    private Integer releaseYear;

    /* @ManyToMany
    @JoinTable(
        name = "album_song",
        joinColumns = @JoinColumn(name = "song_id"),
        inverseJoinColumns = @JoinColumn(name = "album_id")
    ) */
    @JsonIgnoreProperties("songs")
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Size(min=4, max=8)
    private String length;

    @JsonIgnoreProperties("songs")
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Song() {
    }

    public Song(String title, Artist artist, Integer releaseYear, Album album, String length, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.album = album;
        this.length = length;
        this.genre = genre;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song [songId=" + songId + ", title=" + title + ", releaseYear=" + releaseYear
                + ", length=" + length + "]";
    }

}
