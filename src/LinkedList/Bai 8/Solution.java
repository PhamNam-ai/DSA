// Cách 1 : Lặp
static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    // Duyệt đồng thời cả hai danh sách
    while (head1 != null && head2 != null) {
        // Nếu dữ liệu của 2 nút khác nhau → không giống nhau
        if (head1.data != head2.data) {
            return false;
        }
        // Tiến tới nút kế tiếp ở cả hai danh sách
        head1 = head1.next;
        head2 = head2.next;
    }

    // Nếu cả hai đều kết thúc cùng lúc → giống nhau, ngược lại thì khác
    return (head1 == null && head2 == null);
}

// Cách 2 : Đệ quy
static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    // Nếu cả hai đều rỗng => giống nhau
    if (head1 == null && head2 == null)
        return true;

    // Nếu chỉ một danh sách rỗng => khác nhau
    if (head1 == null || head2 == null)
        return false;

    // Nếu dữ liệu khác nhau => khác
    if (head1.data != head2.data)
        return false;

    // Gọi đệ quy kiểm tra phần còn lại
    return compareLists(head1.next, head2.next);
}
