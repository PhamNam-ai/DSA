// Cách 1: Lặp
public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data); // Tạo node mới
    if (position == 0) {                 // Nếu chèn ở đầu danh sách
        newNode.next = llist;
        return newNode;
    }
    SinglyLinkedListNode current = llist;
    for (int i = 0; i < position - 1 && current != null; i++) { // Duyệt đến node trước vị trí cần chèn
        current = current.next;
    }
    newNode.next = current.next;         // Trỏ node mới đến node sau
    current.next = newNode;              // Gắn node mới vào vị trí cần chèn
    return llist;                        // Trả lại node đầu (head không thay đổi)
}

// Cách 2: Đệ quy
public static SinglyLinkedListNode insertNodeAtPositionRecursion(SinglyLinkedListNode llist, int data, int position) {
    if (position == 0) {                 // Khi vị trí cần chèn là đầu danh sách
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = llist;
        return newNode;
    }
    llist.next = insertNodeAtPositionRecursion(llist.next, data, position - 1); // Gọi đệ quy cho phần còn lại
    return llist;                        // Trả lại node đầu
}