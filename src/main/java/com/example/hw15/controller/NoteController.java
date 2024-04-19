package com.example.hw15.controller;

import com.example.hw15.entity.Note;
import com.example.hw15.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Validated
@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getList() {
        ModelAndView result = new ModelAndView("notes/allNotes");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView getNoteForEdit(@RequestParam(value = "id") UUID id) {
        ModelAndView result = new ModelAndView("notes/editNote");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editNote(
            @RequestParam(value = "id") UUID id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content) {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }

    @DeleteMapping("/delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteNoteById(@RequestParam(value="id") UUID id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }
    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public ModelAndView createNote(
            @RequestParam(value="title") String title,
            @RequestParam(value="content") String content) {
        Note note = new  Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return new ModelAndView("redirect:/note/list");
    }
}
