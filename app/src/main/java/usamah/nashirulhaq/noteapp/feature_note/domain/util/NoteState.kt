package usamah.nashirulhaq.noteapp.feature_note.domain.util

import usamah.nashirulhaq.noteapp.feature_note.domain.model.Note

data class NoteState(
    /**
     * [notes]
    */
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
