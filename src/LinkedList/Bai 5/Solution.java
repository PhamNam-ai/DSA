public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    if (position == 0) {
        return llist.next;
    }
    SinglyLinkedListNode current = llist;
    for (int i = 0; i < position - 1; i++) {
        current = current.next;
    }
    current.next = current.next.next;
    return llist;
}
