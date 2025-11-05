// Cách 1 : Đệ quy
public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    // Trường hợp cơ sở: danh sách rỗng hoặc chỉ có 1 node
    if (llist == null || llist.next == null) {
        return llist;
    }

    // Gọi đệ quy cho phần còn lại của danh sách
    SinglyLinkedListNode newHead = reverse(llist.next);

    // Đảo chiều liên kết giữa 2 node
    llist.next.next = llist;  // node kế tiếp trỏ ngược về node hiện tại
    llist.next = null;        // cắt liên kết cũ để tránh vòng lặp vô tận

    return newHead; // newHead chính là node cuối cùng (đầu mới của danh sách đảo ngược)
}

// Cách 2 : Lặp
Cách 1: Dùng vòng lặp (Iterative)
public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    SinglyLinkedListNode prev = null;      // prev là con trỏ trỏ về node phía trước (ban đầu null)
    SinglyLinkedListNode current = llist;  // current là node hiện tại, bắt đầu từ đầu danh sách

    while (current != null) {              // lặp đến khi current đi hết danh sách
        SinglyLinkedListNode next = current.next; // Lưu lại node kế tiếp (vì sắp đổi hướng liên kết)
        current.next = prev;               // Đảo ngược liên kết: node hiện tại trỏ ngược về node trước
        prev = current;                    // Dịch prev tiến lên 1 bước (prev = current)
        current = next;                    // Dịch current tiến lên 1 bước (current = node tiếp theo)
    }

    return prev; // prev lúc này là node cuối cùng của danh sách ban đầu → trở thành head mới
}
