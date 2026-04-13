package backend2026.musiikkikokoelma.web;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend2026.musiikkikokoelma.domain.Song;
import backend2026.musiikkikokoelma.domain.SongRepository;

@RestController
public class MusiikkikokoelmaRestController {

    private SongRepository songRepository;

    public MusiikkikokoelmaRestController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/songs")
    public List<Song> songListRest() {
        return (List<Song>) songRepository.findAll();
    }

    @GetMapping("/songs/{id}")
    public Optional<Song> findSongRest(@PathVariable("id") Long songId) {
        return songRepository.findById(songId);
    }

    @PostMapping("/songs")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Song saveNewSongRest(@RequestBody Song song) {
        return songRepository.save(song);
    }

    @PutMapping("/songs/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Song editSongRest(@RequestBody Song editedSong, @PathVariable("id") Long songId) {
        editedSong.setSongId(songId);
        return songRepository.save(editedSong);
    }

    @DeleteMapping("/songs/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Iterable<Song> deleteSongRest(@RequestBody Song song, @PathVariable("id") Long songId) {
        songRepository.deleteById(songId);
        return songRepository.findAll();
    }

}
