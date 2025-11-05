//Cách 1: Lặp
static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data); // Tạo node mới với dữ liệu
    newNode.next = llist;      // Trỏ node mới đến node đầu hiện tại
    return newNode;            // Node mới trở thành node đầu mới
}

//Cách 2: Đệ quy
static SinglyLinkedListNode insertNodeAtHeadRecursion(SinglyLinkedListNode llist, int data) {
    if (llist == null) {                           // Nếu danh sách rỗng
        return new SinglyLinkedListNode(data);     // Node mới là node đầu
    }
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data); // Tạo node mới
    newNode.next = llist;                          // Trỏ node mới vào node đầu cũ
    return newNode;                                // Trả về node đầu mới (giống cách lặp)
}