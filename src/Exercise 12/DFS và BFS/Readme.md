Tuyệt vời 👏 — mình sẽ giúp bạn hiểu sâu và rõ ràng về hai thuật toán kinh điển:
➡️ DFS (Depth-First Search) và
➡️ BFS (Breadth-First Search) trong Java,
kèm theo code ví dụ minh họa + phân tích hoạt động + độ phức tạp.

🧭 I. TỔNG QUAN VỀ DFS & BFS
Thuật toán	Tên đầy đủ	Ý tưởng cốt lõi
DFS	Depth-First Search (Duyệt theo chiều sâu)	Đi sâu vào nhánh hiện tại đến khi không đi được nữa, rồi quay lui.
BFS	Breadth-First Search (Duyệt theo chiều rộng)	Duyệt theo lớp (level), thăm tất cả đỉnh cùng “độ sâu” trước khi sang lớp kế tiếp.

👉 Cả hai đều dùng để duyệt hoặc tìm kiếm trong đồ thị, cây, hoặc lưới (grid).
Chúng khác nhau ở cách quản lý thứ tự duyệt (DFS dùng Stack, BFS dùng Queue).

🧱 II. DFS (Depth-First Search)
💡 Ý tưởng

Bắt đầu từ một nút (ô, đỉnh, cell).

Duyệt sâu nhất có thể theo một hướng trước khi quay lại.

Có thể cài bằng đệ quy hoặc Stack (ngăn xếp).
🔍 Phân tích hoạt động

Bắt đầu tại một ô 1 chưa thăm.

Đánh dấu visited[row][col] = true.

Duyệt các ô kề (8 hướng).

Nếu ô kề có giá trị 1 và chưa thăm → thêm vào stack.

Lặp lại đến khi stack rỗng.

Trả về tổng số ô trong vùng liên thông.

⏱️ Độ phức tạp DFS
Loại	Ký hiệu	Phân tích
Thời gian	O(N × M)	Mỗi ô được duyệt đúng 1 lần.
Không gian	O(N × M)	Do visited[][] và stack.
🚀 III. BFS (Breadth-First Search)
💡 Ý tưởng

Bắt đầu tại một ô.

Duyệt theo lớp, tức là thăm tất cả ô kề trước, rồi mới đến các ô xa hơn.

Cài bằng hàng đợi (Queue).
Phân tích hoạt động BFS

Bắt đầu từ ô (row, col) và thêm vào queue.

Trong khi queue chưa rỗng:

Lấy một ô ra (poll()).

Duyệt 8 ô xung quanh.

Nếu là 1 và chưa thăm → đánh dấu và thêm vào queue.

Khi queue trống → đã duyệt hết vùng → trả về số ô.

⏱️ Độ phức tạp BFS
Loại	Ký hiệu	Phân tích
Thời gian	O(N × M)	Mỗi ô thăm 1 lần.
Không gian	O(N × M)	Do visited[][] và queue.
⚔️ IV. So sánh DFS vs BFS
Tiêu chí	DFS	BFS
Cấu trúc dùng	Stack (hoặc đệ quy)	Queue
Cách duyệt	Đi sâu trước	Đi rộng trước
Tìm đường ngắn nhất	❌ Không đảm bảo	✅ Có thể tìm đường ngắn nhất
Bộ nhớ	Ít hơn (trừ khi đệ quy sâu)	Có thể tốn hơn (queue lớn)
Ứng dụng	Tìm vùng liên thông, backtracking, topological sort, phát hiện chu trình	Tìm đường đi ngắn nhất, lan truyền, định mức cấp độ
Cài đặt	Dễ bằng đệ quy	Dễ bằng hàng đợi
🧩 V. Ví dụ trực quan

Giả sử bạn có ma trận:

1 1 0
0 1 1
0 0 1

DFS duyệt (theo sâu):
(0,0) → (0,1) → (1,1) → (1,2) → (2,2)

BFS duyệt (theo rộng):
(0,0)
→ (0,1)
→ (1,1)
→ (1,2)
→ (2,2)


⚠️ Kết quả cuối cùng như nhau (đếm số ô liên thông),
nhưng thứ tự duyệt khác nhau.

✅ Kết luận tổng hợp
Tên	Cấu trúc dữ liệu chính	Cách hoạt động	Thích hợp cho
DFS	Stack hoặc Recursion	Đi sâu vào nhánh rồi quay lui	Dò vùng liên thông, tìm chu trình, bài toán tìm tất cả đường đi
BFS	Queue	Duyệt theo lớp, gần gốc trước xa gốc sau	Tìm đường đi ngắn nhất, tìm cấp độ, lan truyền