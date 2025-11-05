// Cách 1: Lặp
static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data); // Tạo node mới chứa dữ liệu cần chèn

    if (head == null) { // Nếu danh sách rỗng
        return newNode; // Node mới trở thành head
    }

    SinglyLinkedListNode current = head; // Bắt đầu từ node đầu
    while (current.next != null) {       // Duyệt đến node cuối cùng
        current = current.next;
    }
    current.next = newNode;              // Gắn node mới vào cuối danh sách
    return head;                         // Trả về node đầu (head không thay đổi)
}

// Cách 2: Đệ quy
static SinglyLinkedListNode insertNodeAtTailRecursion(SinglyLinkedListNode head, int data) {
    if (head == null) {                  // Nếu danh sách rỗng, node mới là head
        return new SinglyLinkedListNode(data);
    }
    if (head.next == null) {             // Nếu head là node cuối cùng
        head.next = new SinglyLinkedListNode(data); // Gắn node mới vào sau
    } else {
        insertNodeAtTailRecursion(head.next, data); // Gọi đệ quy cho phần còn lại của danh sách
    }
    return head;                         // Trả lại node đầu tiên
}
