Làm bài Connected Cells in a Grid

Tóm tắt: Cho mảng hai chiều với các phần tử (ô) có giá trị là 0 hoặc 1. Hai phần từ được gọi là kết nối (connected) với nhau nếu chúng cùng có giá trị là 1 và ở sát nhau theo chiều ngang, chiều dọc và chéo cạnh. Như thế mỗi ô có thể có nhiều nhất 8 ô ở kề nối với nó.

Các ô kết nối với nhau tạo thành vùng. Hãy tìm và in ra số phần tử của vùng lớn nhất.

Gợi ý: Xem đây là một đồ thị với đỉnh là các ô, và hai cạnh nối với nhau nếu 2 ô là kết nối (connected). Với mỗi đỉnh (ô), dùng thuật toán duyệt theo chiều sau (DFS) hoặc duyệt theo chiều rộng (BFS) để lan ra hết các đỉnh (ô) liên thông với nó. Khi duyệt, nếu đỉnh nào đã thăm rồi thì không duyệt nữa. Nói cách khác, đây là bài toán tìm thành phần liên thông của đồ thị.

Mã nguồn: Sinh viên có thể sử dụng phần chương trình sau;

trong đó viết sẵn việc nhập dữ liệu, khai báo mảng các ô grid[][] cũng như mảng lưu trạng thái các ô đã được thăm visited[][] chưa.

Sinh viên cần viết nốt phần hàm static int count_connected(int row, int col) đếm số ô của thành phần liên thông với ô có toạ độ (row, col). Trong hàm này cũng cần cập nhật/đánh dấu các ô đã thăm để không duyệt nữa vào mảng visited[][] được khai báo ở ngoài hàm.

🔹 DFS (Depth First Search) – Tìm kiếm theo chiều sâu
✅ Khái niệm:

DFS là thuật toán duyệt đồ thị hoặc cây theo chiều sâu.
Nó bắt đầu từ một đỉnh gốc, sau đó đi sâu nhất có thể theo từng nhánh trước khi quay lại (backtrack) để đi sang nhánh khác.

✅ Cách hoạt động:

Bắt đầu từ đỉnh ban đầu (start node).

Đánh dấu đỉnh đó là đã thăm.

Chọn một đỉnh kề chưa được thăm và tiếp tục đi sâu.

Nếu không còn đỉnh kề nào chưa thăm, quay lui về đỉnh trước đó để tiếp tục tìm đỉnh khác.

Lặp lại cho đến khi tất cả các đỉnh đều được thăm.

✅ Cấu trúc dữ liệu sử dụng:

Stack (ngăn xếp) hoặc đệ quy (recursion).


🔹 BFS (Breadth First Search) – Tìm kiếm theo chiều rộng
✅ Khái niệm:

BFS là thuật toán duyệt đồ thị hoặc cây theo chiều rộng.
Nó bắt đầu từ một đỉnh gốc, sau đó duyệt tất cả các đỉnh kề (gần nhất) trước, rồi mới đến các đỉnh xa hơn.

✅ Cách hoạt động:

Bắt đầu từ đỉnh gốc (start node).

Đánh dấu đỉnh đó là đã thăm và đưa vào hàng đợi (queue).

Lấy một đỉnh trong hàng đợi ra và duyệt tất cả đỉnh kề chưa thăm của nó.

Các đỉnh này được đưa vào cuối hàng đợi.

Tiếp tục cho đến khi hàng đợi rỗng.

✅ Cấu trúc dữ liệu sử dụng:

Queue (hàng đợi)





















🔹 1. Ký hiệu

Giả sử ma trận có:

n hàng

m cột
→ Tổng số ô = N = n * m

Mỗi ô chứa giá trị 0 hoặc 1.

Ta duyệt qua tất cả các ô, và dùng DFS hoặc BFS để tìm các vùng (connected components).

🔹 2. Độ phức tạp thời gian (Time Complexity)
✅ Phân tích chi tiết:

Vòng lặp ngoài

for (int i = 0; i < n; i++) {
for (int j = 0; j < m; j++) {
...
}
}


→ Duyệt tất cả N ô trong ma trận.

Mỗi ô được xét 1 lần duy nhất:

Nếu matrix[i][j] == 0 → bỏ qua (O(1)).

Nếu matrix[i][j] == 1 và chưa thăm → gọi DFS/BFS để duyệt toàn bộ vùng chứa ô đó.

Trong DFS/BFS, mỗi ô được thăm đúng một lần duy nhất:

Khi thăm, ta kiểm tra tối đa 8 hướng kề (hằng số, không phụ thuộc n hoặc m).

Mỗi lần kiểm tra biên, giá trị và trạng thái visited → O(1).

→ Như vậy:

Mỗi ô chỉ mất O(1) thao tác khi được thăm.

Tổng cộng có N ô → tổng thời gian = O(N) = O(n × m).

✅ Không có chồng chéo:

Dù có nhiều vùng khác nhau, mỗi ô thuộc chính xác một vùng (được DFS/BFS thăm 1 lần duy nhất).
Không ô nào bị duyệt lặp lại → tổng thời gian tuyến tính theo số ô.

🧮 Kết luận:

Độ phức tạp thời gian:

𝑇
(
𝑛
,
𝑚
)
=
𝑂
(
𝑛
×
𝑚
)
T(n,m)=O(n×m)

Hay nói cách khác:
Dù ma trận có nhiều vùng hay chỉ một vùng lớn duy nhất, thuật toán chỉ cần thăm từng ô một lần.

🔹 3. Độ phức tạp không gian (Space Complexity)

Không gian được sử dụng bao gồm:

1️⃣ Mảng visited[n][m]

Lưu trạng thái đã thăm hay chưa.

Kích thước = n × m → O(n × m).

2️⃣ Ngăn xếp hoặc hàng đợi (Stack / Queue)

Dùng trong DFS hoặc BFS để lưu các ô cần thăm tiếp theo.

Trong trường hợp tệ nhất (ma trận toàn 1), ngăn xếp hoặc hàng đợi có thể chứa toàn bộ n × m ô.

→ Không gian phụ thuộc tuyến tính vào số ô: O(n × m).

3️⃣ Không gian đệ quy (nếu dùng DFS đệ quy)

Nếu dùng DFS đệ quy, ngăn xếp gọi hàm có thể sâu tới O(n × m) trong trường hợp vùng lớn nhất chiếm toàn bộ ma trận.

Gây StackOverflowError nếu ma trận rất lớn.

🧮 Kết luận:

Độ phức tạp không gian:

𝑆
(
𝑛
,
𝑚
)
=
𝑂
(
𝑛
×
𝑚
)
S(n,m)=O(n×m)
🔹 4. Tóm tắt cuối cùng
Thành phần	Giải thích	Độ phức tạp
Duyệt toàn bộ ma trận	2 vòng for để kiểm tra từng ô	O(n × m)
DFS/BFS duyệt vùng	Mỗi ô được thăm đúng 1 lần	O(n × m)
Tổng thời gian		✅ O(n × m)
Mảng visited	Kích thước n × m	O(n × m)
Stack/Queue hoặc recursion	Có thể chứa tối đa n × m ô	O(n × m)
Tổng không gian		✅ O(n × m)
🔹 5. So sánh nhanh
Cách duyệt	Ưu điểm	Nhược điểm
DFS (đệ quy)	Code ngắn, dễ hiểu	Dễ tràn stack khi vùng lớn
DFS (dùng Stack)	Tránh tràn stack	Code dài hơn chút
BFS (dùng Queue)	Duyệt theo tầng, dễ kiểm soát	Chiếm bộ nhớ tương đương DFS
✅ Kết luận tổng thể

Bài toán tìm vùng 1 lớn nhất trong ma trận 0–1 có:

Time Complexity:
𝑂
(
𝑛
×
𝑚
)
Space Complexity:
𝑂
(
𝑛
×
𝑚
)
Time Complexity: O(n×m)Space Complexity: O(n×m)
​
