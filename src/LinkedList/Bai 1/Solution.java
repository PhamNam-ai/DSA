// Cách 1 : Lặp
static void printLinkedList(SinglyLinkedListNode head) {
    SinglyLinkedListNode current = head; // Bắt đầu từ node đầu tiên
    while (current != null) {             // Khi chưa đến cuối danh sách
        System.out.println(current.data); // In giá trị của node hiện tại
        current = current.next;           // Chuyển sang node tiếp theo
    }
}


// Cách 2: Đệ quy
static void printLinkedListRecursion(SinglyLinkedListNode head) {
    if (head == null) return;
    System.out.println(head.data);
    printLinkedListRecursion(head.next);
}
