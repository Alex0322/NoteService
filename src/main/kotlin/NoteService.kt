class NoteService {

    // --- ЗАМЕТКИ ---

    private val notes: ArrayList<Note> = arrayListOf() //список заметок в сервисе
    var newNoteId: Long = 0 //счетчик id заметок в списке

    //Создает новую заметку у текущего пользователя.
    fun add(title: String, text: String): Note {
        val n = Note(id = newNoteId++, title = title, text = text)
        notes.add(n)
        return n
    }

    //Удаляет заметку текущего пользователя.
    fun delete(noteId: Long) {
        val n = getById(noteId) ?: return
        n.deleted = true
    }

    //Редактирует заметку текущего пользователя.
    fun edit(note: Note, newTitle: String, newText: String): Note {
        if (note.deleted) {
            return note
        }
        return note.copy(title = newTitle, text = newText)
    }

    //Возвращает список заметок, созданных пользователем.
    fun get(): ArrayList<Note> {
        return notes
    }

    //Возвращает заметку по её id.
    fun getById(id: Long): Note? {
        for (n in notes) {
            if (n.id == id) {
                return n
            }
        }
        return null
    }

    // --- КОММЕНТАРИИ ---

    //Добавляет новый комментарий к заметке.
    fun createComment(note: Note, comment: Comment): Comment {
        if (note.deleted)
            return comment
        note.addComment(comment)
        return comment
    }

    //Удаляет комментарий к заметке.
    fun deleteComment(note: Note, commentId: Long) {
        if (note.deleted)
            return
        note.deleteComment(commentId)
    }

    //Редактирует указанный комментарий у заметки.
    fun editComment(note: Note, commentId: Long, newMessage: String) {
        if (note.deleted)
            return
        note.editComment(commentId, newMessage)
    }

    //Возвращает список комментариев к заметке.
    fun getComments(note: Note): ArrayList<Comment> {
        return note.comments
    }

    //Восстанавливает удалённый комментарий.
    fun restoreComment(note: Note, comment: Comment) {
        comment.deleted = false
    }

}