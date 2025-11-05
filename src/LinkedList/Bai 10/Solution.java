// Cách 1 : Lặp
public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    // Bước 1: Tính tổng số phần tử trong danh sách
    int length = 0;
    SinglyLinkedListNode temp = llist;
    while (temp != null) {
        length++;
        temp = temp.next;
    }

    // Bước 2: Tính vị trí từ đầu danh sách
    int indexFromHead = length - positionFromTail - 1;

    // Bước 3: Duyệt lại lần nữa để lấy node ở vị trí đó
    temp = llist;
    for (int i = 0; i < indexFromHead; i++) {
        temp = temp.next;
    }

    // Bước 4: Trả về giá trị data
    return temp.data;
}


// Cách 2 : Đệ quy
public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
    // Bọc lời gọi hàm phụ có thêm biến đếm
    return getNodeRecursive(llist, positionFromTail).value;
}

// Hàm phụ trả về cả giá trị và vị trí hiện tại khi đệ quy quay ngược lại
private static ResultHelper getNodeRecursive(SinglyLinkedListNode node, int positionFromTail) {
    if (node == null) {
        // Khi đã tới cuối danh sách, bắt đầu đếm ngược
        return new ResultHelper(-1, 0);
    }

    // Gọi đệ quy tới node tiếp theo
    ResultHelper res = getNodeRecursive(node.next, positionFromTail);
    res.indexFromTail++;

    // Khi đếm đến đúng vị trí cần, lưu giá trị node hiện tại
    if (res.indexFromTail - 1 == positionFromTail) {
        res.value = node.data;
    }

    return res;
}

// Lớp phụ để lưu kết quả đệ quy (value và vị trí từ đuôi)
static class ResultHelper {
    int value;          // Giá trị node cần lấy
    int indexFromTail;  // Vị trí đang đếm từ đuôi lên

    ResultHelper(int value, int indexFromTail) {
        this.value = value;
        this.indexFromTail = indexFromTail;
    }
}
