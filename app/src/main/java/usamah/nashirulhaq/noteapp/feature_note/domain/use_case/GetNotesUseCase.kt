package usamah.nashirulhaq.noteapp.feature_note.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import usamah.nashirulhaq.noteapp.feature_note.domain.model.Note
import usamah.nashirulhaq.noteapp.feature_note.domain.repository.NoteRepository
import usamah.nashirulhaq.noteapp.feature_note.domain.util.NoteOrder
import usamah.nashirulhaq.noteapp.feature_note.domain.util.OrderType

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending )
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending  { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending  { it.color }
                    }
                }
            }
        }
    }
}