// Cách 1 : Lặp
SinglyLinkedListNode* reverse(SinglyLinkedListNode* llist) {
    SinglyLinkedListNode* prev = nullptr;      // con trỏ lưu nút trước đó (ban đầu chưa có)
    SinglyLinkedListNode* current = llist;     // con trỏ hiện tại, bắt đầu từ đầu danh sách
    SinglyLinkedListNode* next = nullptr;      // con trỏ lưu nút tiếp theo

    // Duyệt qua danh sách đến khi hết nút
    while (current != nullptr) {
        next = current->next;   // Lưu lại nút kế tiếp (vì sắp thay đổi liên kết)
        current->next = prev;   // Đảo chiều liên kết: trỏ ngược về nút trước
        prev = current;         // Tiến con trỏ prev lên nút hiện tại
        current = next;         // Tiến con trỏ current sang nút kế tiếp
    }

    return prev; // prev chính là head mới sau khi đảo ngược
}

//Cách 2 : Đệ quy
SinglyLinkedListNode* reverse(SinglyLinkedListNode* llist) {
    // Nếu danh sách rỗng hoặc chỉ có 1 phần tử → trả về luôn
    if (llist == nullptr || llist->next == nullptr)
        return llist;

    // Gọi đệ quy để đảo ngược phần còn lại của danh sách
    SinglyLinkedListNode* newHead = reverse(llist->next);

    // Đảo chiều liên kết giữa hai nút
    llist->next->next = llist;   // trỏ nút kế tiếp ngược về nút hiện tại
    llist->next = nullptr;       // nút hiện tại giờ là cuối → next = nullptr

    return newHead;  // newHead là đầu danh sách sau khi đảo
}
