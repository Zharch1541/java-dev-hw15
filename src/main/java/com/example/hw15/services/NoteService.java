package com.example.hw15.services;

import com.example.hw15.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {
    @Autowired NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(UUID id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(UUID id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }
}
