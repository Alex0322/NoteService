data class Note(
    val id: Long = 0,
    val date: Long = 0,
    val title: String = "",
    val text: String = "",
) {
    var deleted: Boolean = false
    var commentId: Long = 0
    val comments: ArrayList<Comment> = arrayListOf()

    fun getById(id: Long): Comment? {
        for (c in comments) {
            if (c.id == id) {
                return c
            }
        }
        return null
    }

    fun addComment(comment: Comment): Comment? {
        if (this.deleted)
            return null
        comments += comment.copy(id = commentId++)
        return comments.last()
    }

    fun deleteComment(commentId: Long) {
        if (this.deleted)
            return
        val c = getById(commentId) ?: return
        c.deleted = true
    }

    fun editComment(commentId: Long, newMessage: String) {
        if (this.deleted)
            return
        val c = getById(commentId) ?: return
        if (c.deleted)
            return
        comments[comments.indexOf(c)] = comments[comments.indexOf(c)].copy(message = newMessage)
    }

}
