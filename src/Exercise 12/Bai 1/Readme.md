Làm bài Connected Cells in a Grid

Tóm tắt: Cho mảng hai chiều với các phần tử (ô) có giá trị là 0 hoặc 1. Hai phần từ được gọi là kết nối (connected) với nhau nếu chúng cùng có giá trị là 1 và ở sát nhau theo chiều ngang, chiều dọc và chéo cạnh. Như thế mỗi ô có thể có nhiều nhất 8 ô ở kề nối với nó.

Các ô kết nối với nhau tạo thành vùng. Hãy tìm và in ra số phần tử của vùng lớn nhất.

Gợi ý: Xem đây là một đồ thị với đỉnh là các ô, và hai cạnh nối với nhau nếu 2 ô là kết nối (connected). Với mỗi đỉnh (ô), dùng thuật toán duyệt theo chiều sau (DFS) hoặc duyệt theo chiều rộng (BFS) để lan ra hết các đỉnh (ô) liên thông với nó. Khi duyệt, nếu đỉnh nào đã thăm rồi thì không duyệt nữa. Nói cách khác, đây là bài toán tìm thành phần liên thông của đồ thị.

Mã nguồn: Sinh viên có thể sử dụng phần chương trình sau;

trong đó viết sẵn việc nhập dữ liệu, khai báo mảng các ô grid[][] cũng như mảng lưu trạng thái các ô đã được thăm visited[][] chưa.

Sinh viên cần viết nốt phần hàm static int count_connected(int row, int col) đếm số ô của thành phần liên thông với ô có toạ độ (row, col). Trong hàm này cũng cần cập nhật/đánh dấu các ô đã thăm để không duyệt nữa vào mảng visited[][] được khai báo ở ngoài hàm.
