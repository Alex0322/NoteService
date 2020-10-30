data class Comment(
    val id: Long = 0,
    val post_id: Long = 0,
    val from_group: Int = 0,
    val message: String = "",
    val sticker_id: Int = 0,
    val reply_to_comment: Int = 0,
) {
    var deleted: Boolean = false
    private var attachmentId: Int = 0
    private var attachments = emptyArray<Attachment?>()

    val parents_stack = emptyArray<Int>()
    val thread = Thread()

    fun addAttachment(a: Attachment?): Attachment? {
        if (this.deleted)
            return null
        if (a != null)
            when (a) {
                is PhotoAttachment -> a.photo.id = attachmentId
                is AudioAttachment -> a.audio.id = attachmentId
                is VideoAttachment -> a.video.id = attachmentId
                is DocAttachment -> a.doc.id = attachmentId
                is GoodAttachment -> a.good.id = attachmentId
            }
        attachments += a
        attachmentId++
        return attachments.last()
    }

    fun printAttachmentsInfo() {
        if (deleted)
            return
        for (a in attachments) {
            if (a != null) {
                print("AttachmentType=${a.type} ")
            }
        }
    }

    data class Thread(
        val count: Int = 0,
        val can_post: Boolean = false,
        val show_reply_button: Boolean = false,
        val group_can_post: Boolean = false
    ) {
        private var items = emptyArray<Comment>()
    }
}