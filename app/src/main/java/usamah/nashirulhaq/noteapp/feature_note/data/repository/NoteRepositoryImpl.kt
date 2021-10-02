package usamah.nashirulhaq.noteapp.feature_note.data.repository

import kotlinx.coroutines.flow.Flow
import usamah.nashirulhaq.noteapp.feature_note.data.data_source.NoteDao
import usamah.nashirulhaq.noteapp.feature_note.domain.model.Note
import usamah.nashirulhaq.noteapp.feature_note.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNotesById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}