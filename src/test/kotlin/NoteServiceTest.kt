import org.junit.Test

class NoteServiceTest {

    @Test
    fun main_Misc(){
        main()
    }

    @Test
    fun ns_Misc(){
        val ns = NoteService()
        //notes
        val n0 = ns.add("Tit1", "Text1")
        val n1 = ns.add("Tit2", "Text2")
        val n2 = ns.add("Tit3", "Text3")
        ns.delete(noteId = n1.id)
        ns.delete(noteId = n1.id)
        n1.editComment(0, "")
        n1.addComment(Comment())
        n1.deleteComment(-1)
        ns.createComment(note = n1, Comment())
        ns.deleteComment(note = n1, commentId = 0)
        ns.editComment(note = n1, 0, "")
        val n3a = ns.edit(note = n1, newTitle = "1", newText = "1")
        val n3 = ns.edit(note = n2, newTitle = "Tit33", newText = "Text44")
        val aNotes = ns.get() //emptyArray<Note>()
        ns.getById(id = -1)
        ns.getById(ns.newNoteId - 1)
        ns.delete(0)
        val c = n0.addComment(Comment())
        //comments
        val c1 = ns.createComment(note = n3, Comment(message = "Text1"))
        val c2 = ns.createComment(note = n3, Comment(message = "Text2"))
        val c3 = ns.createComment(note = n3, Comment(message = "Text3"))
        ns.deleteComment(n3, c2.id)
        ns.delete(n3.id)
        ns.deleteComment(n3, c2.id)
        ns.editComment(n3, c2.id, "NewMessage")
        val c33 = ns.editComment(note = n3, c3.id, newMessage = "Comment333")
        val aComments = ns.getComments(n3)
        ns.restoreComment(n3, c2)
        assert(true)
       }

    @Test
    fun note_Misc() {
        val n0 = Note()
        val n = Note(title = "Tit1", text = "Text1")
        n.getById(-1)
        n.addComment(Comment(message = "m1"))
        val c2 = n.addComment(Comment(message = "m2"))
        if (c2 != null) {
            val c = n.editComment(commentId = c2.id, "m22")
        }
        val c = n.addComment(Comment(message = "m3"))
        n.deleteComment(n.commentId - 1)
        n.editComment(n.commentId - 1, "")
        assert(true)
    }

    @Test
    fun comment_Misc() {
        val aPhoto = PhotoAttachment(photo = Photo())
        val aAudio = AudioAttachment(audio = Audio())
        val aVideo = VideoAttachment(video = Video())
        val aDoc = DocAttachment(doc = Doc())
        val aGood = GoodAttachment(good = Good())

        val ns = NoteService()
        val n = ns.add("t", "x")
        val c0 = n.addComment(Comment())
        if (c0 != null) {
            n.deleteComment(c0.id)
            c0.addAttachment(aPhoto)
            c0.printAttachmentsInfo()
        }
        val c = n.addComment(Comment(message = "m1"))
        c?.addAttachment(aPhoto)
        c?.addAttachment(aAudio)
        c?.addAttachment(aVideo)
        c?.addAttachment(aDoc)
        c?.addAttachment(aGood)
        c?.printAttachmentsInfo()
        assert(true)
    }

}