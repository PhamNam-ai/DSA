Tóm tắt: Tìm đường đi ngắn nhất từ một đỉnh tới các đỉnh còn lại trong đồ thị bằng thuật toán Dijkstra. In ra các khoảng cách ngắn nhất tìm được.

Gợi ý:
Xem gợi ý về cấu trúc dữ liệu ở bài 2 ở trên (Prim).
Cách 1: Cách này không cần phải cập nhật lại giá trị đường đi đã tìm được trước đó; mà đơn giản là cứ tìm được đường mới thì cho vào hàng ưu tiên. Do hàng ưu tiên, nên cái nhỏ nhất luôn được lấy ra trước; Khi lấy ra cần kiểm tra thêm đỉnh đã được chọn trước đó chưa để xử lý tương ứng.

Chỉ cần sử dụng hàng ưu tiên nhỏ nhất thông thường và mảng đánh dấu đỉnh đã được chọn hay chưa
Mỗi khi tìm được/thêm một đỉnh thì cùng cho thêm đường đi ngắn nhất qua đỉnh đó vào hàng ưu tiên. Như vậy trong hàng ưu tiên, có thể có nhiều đường đi tới một đỉnh.
Khi lấy đỉnh có khoảng cách nhỏ nhất ra khỏi hàng ưu tiên, cần kiểm tra xem đỉnh đó đã được thăm/chọn chưa, nếu rồi thì bỏ qua, nếu chưa thì duyệt/xử lý.
Với cách làm này, hàng ưu tiên có thể lớn hơn nhiều lần số đỉnh của đồ thị (bởi có nhiều đường đi tới một đỉnh); nhưng thời gian chạy vẫn đủ nhanh bởi thao tác là log(n).

Cách 2: Dùng cây cân bằng làm hàng ưu tiên; nhờ đó vừa có thể lấy được giá trị nhỏ nhất, và có thể xóa và thêm vào để thực hiện thao tác cập nhật độ dài đường đi.
Với cách này hàng ưu tiên luôn có số phần tử ít hơn số đỉnh của đồ thị.


