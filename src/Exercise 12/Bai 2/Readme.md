Làm bài Breadth First Search: Shortest Reach

Tóm tắt: Cho đồ thị vô hướng; các đỉnh đánh số từ 1 tới n; hai cạnh nếu nối với nhau thì có trọng số luôn là 6. Cho vào đỉnh xuất phát, hãy tìm và in đường đi ngắn nhất từ đỉnh này tới (n-1) đỉnh còn lại. Nếu không có đường đi thì in ra -1.

Chú ý là dữ liệu vào có q câu hỏi, mỗi câu hỏi cho một đồ thị với một đỉnh xuất phát.

Gợi ý:

Dùng thuật toán duyệt theo chiều rộng (BFS) để tìm đường đi từ đỉnh xuất phát tới (n-1) đỉnh còn lại. (Không cần tới thuật toán Dijkstra bởi tất cả các cạnh đều có cùng trọng số là 6.)

Mã nguồn: Sinh viên có thể sử dụng phần chương trình sau;

trong đó viết sẵn việc nhập dữ liệu, khai báo và khởi tạo đồ thị. (Đồ thị được biểu diễn dạng danh sách đỉnh liền kề, với ArrayList. Các đỉnh đánh số từ 1, nên bỏ qua phần từ đầu của mảng có chỉ số là 0.)

Sinh viên cần viết nốt phần hàm static int[] findShortestReach(ArrayList> graph, int start) tìm đường đi ngắn nhất từ đỉnh start tới các đỉnh khác, lưu kết quả vào mảng costs[] và trả về.

