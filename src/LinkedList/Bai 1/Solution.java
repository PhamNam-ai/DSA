static void printLinkedList(SinglyLinkedListNode head) {
    SinglyLinkedListNode current = head; // Bắt đầu từ node đầu tiên
    while (current != null) {             // Khi chưa đến cuối danh sách
        System.out.println(current.data); // In giá trị của node hiện tại
        current = current.next;           // Chuyển sang node tiếp theo
    }
}
