package usamah.nashirulhaq.noteapp.feature_note.domain.repository

import kotlinx.coroutines.flow.Flow
import usamah.nashirulhaq.noteapp.feature_note.domain.model.Note

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNotesById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}