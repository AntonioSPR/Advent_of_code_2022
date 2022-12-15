// We add elements at the end of the queue, remove elements at the beginning of the queue

class FixedQueueWithList(private val maxSize: Int = 4){

    val elements: MutableList<Any> = mutableListOf()

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    fun push(item: Any) {
        if(elements.size == maxSize) {
            pop()
        }
        elements.add(item)
    }

    fun pop() : Any? {
        val item = elements.firstOrNull()
        if (!isEmpty()){
            elements.removeAt(0)
        }
        return item
    }

    fun peek() : Any? = elements.firstOrNull()

    fun allItemsDifferent() : Boolean {
        return elements.distinct().size == elements.size
    }

    override fun toString(): String = elements.toString()

} // -------------------------------------------------- class FixedQueueWithList(private val maxSize: Int = 4){