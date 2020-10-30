fun main(){
    val ns = NoteService()
    //notes
    val n0 = ns.add("Tit1", "Text1")
    val n1 = ns.add("Tit2", "Text2")
    val n2 = ns.add("Tit3", "Text3")
    ns.delete(noteId = n1.id)
    ns.delete(noteId = n1.id)
    n1.addComment(Comment())
    val n3a = ns.edit(note = n1, newTitle = "1", newText = "1")
    val n3 = ns.edit(note = n2, newTitle = "Tit33", newText = "Text44")
    val aNotes = ns.get() //emptyArray<Note>()
    ns.getById(ns.newNoteId - 1)
    ns.delete(0)
    val c = n0.addComment(Comment())
    //comments
    val c1 = ns.createComment(note = n3, Comment(message = "Text1"))
    val c2 = ns.createComment(note = n3, Comment(message = "Text2"))
    val c3 = ns.createComment(note = n3, Comment(message = "Text3"))
    ns.deleteComment(n3, c2.id)
    ns.deleteComment(n3, c2.id)
    ns.editComment(n3, c2.id, "NewMessage")
    val c33 = ns.editComment(note = n3, c3.id, newMessage = "Comment333")
    val aComments = ns.getComments(n3)
    ns.restoreComment(n3, c2)
}

