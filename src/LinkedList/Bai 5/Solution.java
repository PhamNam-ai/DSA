// Cách 1 : Lặp
public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
    // Nếu vị trí là 0 thì xóa node đầu
    if (position == 0) {
        return llist.next;
    }

    // Duyệt đến node ngay trước vị trí cần xóa
    SinglyLinkedListNode current = llist;
    for (int i = 0; i < position - 1 && current.next != null; i++) {
        current = current.next;
    }

    // Bỏ qua node ở vị trí cần xóa (nối node trước với node sau)
    current.next = current.next.next;

    return llist; // Trả lại danh sách sau khi xóa
}

// Cách 2 : Đệ quy
public static SinglyLinkedListNode deleteNodeRecursion(SinglyLinkedListNode llist, int position) {
    // Trường hợp danh sách rỗng
    if (llist == null) return null;

    // Nếu cần xóa node đầu tiên
    if (position == 0) return llist.next;

    // Gọi đệ quy cho phần còn lại của danh sách
    llist.next = deleteNodeRecursion(llist.next, position - 1);
    return llist; // Trả lại node đầu danh sách
}