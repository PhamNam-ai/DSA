// Cách 1: Lặp
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    // Nếu 1 trong 2 danh sách rỗng, trả về danh sách còn lại
    if (head1 == null) return head2;
    if (head2 == null) return head1;

    // Tạo node giả (dummy) để dễ thao tác nối danh sách
    SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
    SinglyLinkedListNode tail = dummy; // tail trỏ đến phần cuối của danh sách đã trộn

    // Duyệt cả 2 danh sách cho đến khi 1 trong 2 hết
    while (head1 != null && head2 != null) {
        if (head1.data <= head2.data) {     // So sánh phần tử nhỏ hơn
            tail.next = head1;              // Nối node nhỏ hơn vào danh sách kết quả
            head1 = head1.next;             // Tiến sang node kế tiếp trong list 1
        } else {
            tail.next = head2;
            head2 = head2.next;
        }
        tail = tail.next;                   // Di chuyển tail tới node mới nối vào
    }

    // Nếu 1 danh sách còn sót lại, nối phần còn lại vào
    if (head1 != null) tail.next = head1;
    else tail.next = head2;

    // Trả về danh sách bắt đầu sau dummy
    return dummy.next;
}

// Cách 2: Đệ quy
static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    // Nếu một danh sách rỗng, trả về danh sách còn lại
    if (head1 == null) return head2;
    if (head2 == null) return head1;

    // So sánh giá trị tại 2 node đầu
    if (head1.data <= head2.data) {
        head1.next = mergeLists(head1.next, head2); // Ghép phần còn lại đệ quy
        return head1; // Trả về node nhỏ hơn làm đầu
    } else {
        head2.next = mergeLists(head1, head2.next);
        return head2;
    }
}
