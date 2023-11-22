package si.vstaric.tuuscasus.util

class Stack<T>{
    val elements: MutableList<T> = mutableListOf()
    fun isEmpty() = elements.isEmpty()
    fun size() = elements.size
    fun push(item: T) = elements.add(item)
    fun pop() : T {
        val item = elements.lastOrNull()
        if (!isEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item ?: throw NoSuchElementException("Stack is empty.")
    }
    fun peek() : T = elements.lastOrNull() ?: throw NoSuchElementException("Stack is empty.")

    override fun toString(): String = elements.toString()
}

fun <T> Stack<T>.push(items: Collection<T>) = items.forEach { this.push(it) }