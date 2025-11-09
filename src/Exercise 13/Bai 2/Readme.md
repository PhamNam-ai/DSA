Bài 2
Làm bài Prim's (MST) : Special Subtree

Tóm tắt: Cho đồ thị vô hướng, có trọng số. Tìm cây bao trùm nhỏ nhất (MST) bằng thuật toán Prim. In ra tổng trọng số của cây tìm được.


Gợi ý:
Đồ thị dạng danh sách liền kề, tương tự các bài trước. Tuy nhiên, do có trọng số, nên danh sách kề là danh sách các lớp con Cost lưu thông tin khoảng cách (r) và đỉnh kề (v):
class Cost implements Comparable<Cost> {
public int r, v;
public Cost(int cost, int vertex) {
r = cost;
v = vertex;
}
@Override
public int compareTo(Cost c) {
if (r < c.r) return -1;
if (r> c.r) return 1;
if (v < c.v) return -1;
if (v > c.v) return 1;
return 0;
}

}
Xây dựng đồ thị
Dùng hàng ưu tiên nhỏ nhất với kiểu dữ liệu Cost để mỗi lần lấy ra đỉnh có khoảng cách nhỏ nhất trong quá trình chạy theo thuật toán Prim.
Có thêm xem thêm gợi ý trong bài bên dưới (Dijkstra) để làm được 2 cách cài đặt khác nhau cho thuật toán.
