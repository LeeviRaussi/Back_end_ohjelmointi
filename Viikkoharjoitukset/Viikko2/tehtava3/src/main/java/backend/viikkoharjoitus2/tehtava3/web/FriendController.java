package backend.viikkoharjoitus2.tehtava3.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import backend.viikkoharjoitus2.tehtava3.domain.Friend;

@Controller
public class FriendController {

    public List<Friend> friends = new ArrayList<>();

    @GetMapping("/friends")
    public String allFriends(Model model) {
        model.addAttribute("friends", friends);
        return "friends";
    }

    @GetMapping("/add")
    public String toAdd(Model model) {
        model.addAttribute("friend", new Friend());
        return "add";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend, Model model) {
        model.addAttribute("friend", friend);
        friends.add(new Friend(friend.getFirstName(), friend.getLastName()));
        return "redirect:/friends";
    }


}
