package backend2026.musiikkikokoelma.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import backend2026.musiikkikokoelma.domain.Album;
import backend2026.musiikkikokoelma.domain.AlbumRepository;
import backend2026.musiikkikokoelma.domain.Artist;
import backend2026.musiikkikokoelma.domain.ArtistRepository;
import backend2026.musiikkikokoelma.domain.Genre;
import backend2026.musiikkikokoelma.domain.GenreRepository;
import backend2026.musiikkikokoelma.domain.Song;
import backend2026.musiikkikokoelma.domain.SongRepository;
import jakarta.validation.Valid;

@Controller
public class MusiikkikokoelmaController {

    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private GenreRepository genreRepository;
    private SongRepository songRepository;

    public MusiikkikokoelmaController(AlbumRepository albumRepository, ArtistRepository artistRepository, GenreRepository genreRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.genreRepository = genreRepository;
        this.songRepository = songRepository;
    }

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/albumlist")
    public String albumList(Model model) {
        model.addAttribute("albums", albumRepository.findByOrderByTitle());
        return "albumlist";
    }

    @GetMapping("/addalbum")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addAlbum(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("artists", artistRepository.findByOrderByName());
        return "addalbum";
    }

    @PostMapping("/savealbum")
    public String saveAlbum(@Valid Album album, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("artists", artistRepository.findByOrderByName());
            return "addalbum";
        }
        albumRepository.save(album);
        return "redirect:/albumlist";
    }

    @GetMapping("/editalbum/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditAlbum(@PathVariable("id") Long albumId, Model model) {
        model.addAttribute("album", albumRepository.findById(albumId));
        model.addAttribute("artists", artistRepository.findByOrderByName());
        return "editalbum";
    }

    @PostMapping("/editalbum")
    public String editedAlbum(@Valid Album album, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("artists", artistRepository.findByOrderByName());
            return "editalbum";
        }
        albumRepository.save(album);
        return "redirect:/albumlist";
    }

    @GetMapping("/deletealbum/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteAlbum(@PathVariable("id") Long albumId, Model model) {
        albumRepository.deleteById(albumId);
        return "redirect:../albumlist";
    }

    @GetMapping("/artistlist")
    public String artistList(Model model) {
        model.addAttribute("artists", artistRepository.findByOrderByName());
        return "artistlist";
    }

    @GetMapping("/addartist")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addArtist(Model model) {
        model.addAttribute("artist", new Artist());
        return "addartist";
    }

    @PostMapping("/saveartist")
    public String saveArtist(@Valid Artist artist, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addartist";
        }
        artistRepository.save(artist);
        return "redirect:/artistlist";
    }

    @GetMapping("/editartist/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditArtist(@PathVariable("id") Long artistId, Model model) {
        model.addAttribute("artist", artistRepository.findById(artistId));
        return "editartist";
    }

    @PostMapping("/editartist")
    public String editedArtist(@Valid Artist artist, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editartist";
        }
        artistRepository.save(artist);
        return "redirect:/artistlist";
    }

    @GetMapping("/deleteartist/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteArtist(@PathVariable("id") Long artistId, Model model) {
        artistRepository.deleteById(artistId);
        return "redirect:../artistlist";
    }

    @GetMapping("/genrelist")
    public String genreList(Model model) {
        model.addAttribute("genres", genreRepository.findByOrderByName());
        return "genrelist";
    }

    @GetMapping("/addgenre")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "addgenre";
    }

    @PostMapping("/savegenre")
    public String saveGenre(@Valid Genre genre, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addgenre";
        }
        genreRepository.save(genre);
        return "redirect:/genrelist";
    }

    @GetMapping("/editgenre/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditGenre(@PathVariable("id") Long genreId, Model model) {
        model.addAttribute("genre", genreRepository.findById(genreId));
        return "editgenre";
    }

    @PostMapping("/editgenre")
    public String editedGenre(@Valid Genre genre, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editgenre";
        }
        genreRepository.save(genre);
        return "redirect:/genrelist";
    }

    @GetMapping("/deletegenre/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteGenre(@PathVariable("id") Long genreId, Model model) {
        genreRepository.deleteById(genreId);
        return "redirect:../genrelist";
    }

    @GetMapping("/songlist")
    public String songList(Model model) {
        model.addAttribute("songs", songRepository.findByOrderByTitle());
        return "songlist";
    }

    @GetMapping("/addsong")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addSong(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("artists", artistRepository.findByOrderByName());
        model.addAttribute("albums", albumRepository.findByOrderByTitle());
        model.addAttribute("genres", genreRepository.findByOrderByName());
        return "addsong";
    }

    @PostMapping("/savesong")
    public String saveSong(@Valid Song song, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("artists", artistRepository.findByOrderByName());
            model.addAttribute("albums", albumRepository.findByOrderByTitle());
            model.addAttribute("genres", genreRepository.findByOrderByName());
            return "addsong";
        }
        songRepository.save(song);
        return "redirect:/songlist";
    }

    @GetMapping("/editsong/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditSong(@PathVariable("id") Long songId, Model model) {
        model.addAttribute("song", songRepository.findById(songId));
        model.addAttribute("artists", artistRepository.findByOrderByName());
        model.addAttribute("albums", albumRepository.findByOrderByTitle());
        model.addAttribute("genres", genreRepository.findByOrderByName());
        return "editsong";
    }

    @PostMapping("/editsong")
    public String editedSong(@Valid Song song, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("artists", artistRepository.findByOrderByName());
            model.addAttribute("albums", albumRepository.findByOrderByTitle());
            model.addAttribute("genres", genreRepository.findByOrderByName());
            return "editsong";
        }
        songRepository.save(song);
        return "redirect:/songlist";
    }

    @GetMapping("/deletesong/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteSong(@PathVariable("id") Long songId, Model model) {
        songRepository.deleteById(songId);
        return "redirect:../songlist";
    }

}
