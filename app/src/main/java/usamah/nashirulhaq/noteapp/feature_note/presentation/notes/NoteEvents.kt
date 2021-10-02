package usamah.nashirulhaq.noteapp.feature_note.presentation.notes

import usamah.nashirulhaq.noteapp.feature_note.domain.model.Note
import usamah.nashirulhaq.noteapp.feature_note.domain.util.NoteOrder

sealed class NoteEvents {
    data class Order(val noteOrder: NoteOrder): NoteEvents()
    data class DeleteNote(val note: Note): NoteEvents()
    object RestoreNote: NoteEvents()
    object ToggleOrderSection: NoteEvents()
}