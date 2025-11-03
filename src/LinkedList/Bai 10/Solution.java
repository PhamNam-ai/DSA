int getNode(SinglyLinkedListNode* llist, int positionFromTail) {
    SinglyLinkedListNode* fast = llist;
    SinglyLinkedListNode* slow = llist;
    for (int i = 0; i < positionFromTail; i++) fast = fast->next;
    while (fast->next != nullptr) {
        fast = fast->next;
        slow = slow->next;
    }
    return slow->data;
}
